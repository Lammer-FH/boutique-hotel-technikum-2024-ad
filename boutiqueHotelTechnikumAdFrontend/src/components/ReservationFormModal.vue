<script lang="ts">
import { defineComponent, ref } from 'vue';
import { Reservation } from '@/model/reservation';
import {
    IonButton,
    IonButtons,
    IonCheckbox,
    IonContent,
    IonHeader,
    IonInput,
    IonItem,
    IonList,
    IonModal,
    IonToolbar,
    IonTitle,
    modalController,
    toastController,
} from '@ionic/vue';
import { useRoomStore } from '@/store/roomsStore';

export default defineComponent({
    name: 'ReservationForm',
    data() {
        return {
            reservation: new Reservation(),
            confirmation: false,
            roomStore: useRoomStore(),
        };
    },
    components: {
        IonHeader,
        IonToolbar,
        IonButtons,
        IonContent,
        IonInput,
        IonItem,
        IonList,
        IonCheckbox,
        IonButton,
        IonModal,
    },
    ionViewWillEnter() {
        this.reservation.from = this.roomStore.filter.from;
        this.reservation.to = this.roomStore.filter.to;
    },
    methods: {
        submitReservation() {
            if (this.confirmation) {
                this.roomStore
                    .reserveRoom(this.roomStore.selectedRoom, this.reservation)
                    .then(() => {
                        this.showToast('Raum reserviert', false, 'top');
                        modalController.dismiss();
                    })
                    .catch((error) => {
                        console.log(error);
                        if (
                            error.response !== undefined &&
                            error.response.data !== undefined &&
                            error.response.status === 422
                        ) {
                            this.showToast(
                                'Raum ist nicht verfügbar in dem spezifizerten Zeitraum',
                                true,
                                'top'
                            );
                        } else {
                            this.showToast(
                                'Raum reservierung fehlgeschlagen!',
                                true,
                                'top'
                            );
                        }
                    });
            }
            this.confirmation = true;
        },
        backToEdit() {
            this.confirmation = false;
        },
        dismiss() {
            modalController.dismiss();
        },
        async showToast(
            message: string,
            error = false,
            position: 'top' | 'middle' | 'bottom'
        ) {
            const toast = await toastController.create({
                message: message,
                duration: 3000,
                position: position,
                color: error ? 'danger' : 'success',
            });
            await toast.present();
        },
    },
});
</script>

<template>
    <ion-header>
        <ion-toolbar>
            <ion-buttons slot="start">
                <ion-button @click="dismiss()">Abbrechen</ion-button>
            </ion-buttons>
            <ion-title>Raum reservieren</ion-title>
        </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
        <ion-list>
            <form @submit.prevent="submitReservation">
                <ion-item>
                    <ion-input
                        label="Buchen von"
                        type="date"
                        :value="reservation.from.toISOString().split('T')[0]"
                        required
                        :disabled="true"
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-input
                        label="Buchen bis"
                        type="date"
                        :value="reservation.to.toISOString().split('T')[0]"
                        required
                        :disabled="true"
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-input
                        label="Vorname*"
                        type="text"
                        v-model="reservation.firstName"
                        required
                        :disabled="confirmation"
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-input
                        label="Nachname*"
                        type="text"
                        v-model="reservation.lastName"
                        required
                        :disabled="confirmation"
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-input
                        label="E-Mail*"
                        type="email"
                        v-model="reservation.eMail"
                        required
                        :disabled="confirmation"
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-checkbox
                        v-model="reservation.breakfast"
                        :disabled="confirmation"
                        >Frühstück Ja/Nein</ion-checkbox
                    >
                </ion-item>
                <ion-button
                    type="button"
                    v-if="confirmation"
                    @click="backToEdit"
                    >Zurück Editeren</ion-button
                >
                <ion-button type="submit">{{
                    confirmation === true
                        ? 'Reservieren'
                        : 'Reservierung bestätigen'
                }}</ion-button>
            </form>
        </ion-list>
    </ion-content>
</template>

<style scoped></style>
