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
                    <ion-button class="cancel-button" @click="dismiss()"
                        >Cancel</ion-button
                    >
                </ion-buttons>
                <ion-title>Reserve room</ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding">
            <ion-list>
                <form @submit.prevent="submitReservation">
                    <ion-list>
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
                                placeholder="Max"
                                v-model="reservation.firstName"
                                required
                                :disabled="confirmation"
                            ></ion-input>
                        </ion-item>
                        <ion-item>
                            <ion-input
                                label="Lastname*"
                                type="text"
                                placeholder="Mustermann"
                                v-model="reservation.lastName"
                                required
                                :disabled="confirmation"
                            ></ion-input>
                        </ion-item>
                        <ion-item>
                            <ion-input
                                label="E-Mail*"
                                type="email"
                                placeholder="max.mustermann@gmx.at"
                                v-model="reservation.eMail"
                                required
                                :disabled="confirmation"
                            ></ion-input>
                        </ion-item>
                        <ion-item>
                            <ion-checkbox
                                v-model="reservation.doBreakfast"
                                :disabled="confirmation"
                                >With breakfast?</ion-checkbox
                            >
                        </ion-item>
                    </ion-list>
                    <div class="button-group">
                        <ion-button
                            type="button"
                            v-if="confirmation"
                            @click="backToEdit"
                            >Edit</ion-button
                        >
                        <ion-button type="submit">{{
                            confirmation ? 'Submit Reservation' : 'Reserve'
                        }}</ion-button>
                    </div>
                </form>
            </ion-list>
        </ion-content>
    </ion-modal>
</template>

<style scoped>
.button-group {
    display: flex;
    width: auto;
    flex-direction: column;
    margin-right: 1rem;
    margin-left: 1rem;
}

.cancel-button {
    background-color: #290000;
}

@media only screen and (min-width: 600px) {
    .button-group {
        flex-direction: row;
        margin-right: 0;
        :first-child {
            margin-right: 1rem;
        }
    }

    .button {
        min-width: 10rem;
    }
}
</style>
