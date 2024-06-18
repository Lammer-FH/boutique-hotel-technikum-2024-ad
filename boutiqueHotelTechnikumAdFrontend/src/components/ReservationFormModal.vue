<script lang="ts">
import { defineComponent } from 'vue';
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
    toastController,
} from '@ionic/vue';
import { useRoomStore } from '@/store/roomsStore';
import HelperService from '@/service/HelperService';

export default defineComponent({
    name: 'ReservationFormModal',
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
        IonTitle,
    },
    data() {
        return {
            reservation: new Reservation(),
            confirmation: false,
            roomStore: useRoomStore(),
            isModalOpen: false,
        };
    },
    methods: {
        submitReservation() {
            if (this.confirmation) {
                this.roomStore
                    .reserveRoom(this.roomStore.selectedRoom, this.reservation)
                    .then(() => {
                        HelperService.showToast(
                            'Raum reserviert',
                            false,
                            'top'
                        );
                        this.dismiss();
                    })
                    .catch((error) => {
                        console.log(error);
                        if (
                            error.response !== undefined &&
                            error.response.data !== undefined &&
                            error.response.status === 422
                        ) {
                            HelperService.showToast(
                                'Raum ist nicht verfügbar in dem spezifizerten Zeitraum',
                                true,
                                'top'
                            );
                        } else {
                            HelperService.showToast(
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
            this.isModalOpen = false;
        },
        openModal() {
            this.reservation.from = this.roomStore.filter.from;
            this.reservation.to = this.roomStore.filter.to;
            this.isModalOpen = true;
        },
    },
});
</script>

<template>
    <ion-button @click="openModal" expand="block">Reserve</ion-button>
    <ion-modal :is-open="isModalOpen" @did-dismiss="dismiss">
        <ion-header>
            <ion-toolbar>
                <ion-buttons slot="start">
                    <ion-button @click="dismiss()">Cancel</ion-button>
                </ion-buttons>
                <ion-title>Reserve room</ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding">
            <ion-list>
                <form @submit.prevent="submitReservation">
                    <ion-item>
                        <ion-input
                            label="Book from"
                            type="date"
                            :value="reservation.fromFormated()"
                            required
                            :disabled="true"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-input
                            label="Book to"
                            type="date"
                            :value="reservation.toFormated()"
                            required
                            :disabled="true"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-input
                            label="Firstname*"
                            type="text"
                            v-model="reservation.firstName"
                            required
                            :disabled="confirmation"
                        ></ion-input>
                    </ion-item>
                    <ion-item>
                        <ion-input
                            label="Lastname*"
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
                            v-model="reservation.doBreakfast"
                            :disabled="confirmation"
                            >Breakfast Yes/No</ion-checkbox
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
    </ion-modal>
</template>

<style scoped></style>
