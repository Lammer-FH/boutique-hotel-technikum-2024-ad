<script lang="ts">
import { defineComponent } from 'vue';
import { Reservation } from '@/model/reservation';
import {
    IonButton,
    IonCard,
    IonCardContent,
    IonCardHeader,
    IonCheckbox,
    IonInput,
    IonItem,
} from '@ionic/vue';

export default defineComponent({
    name: 'ReservationForm',
    data() {
        return {
            reservation: new Reservation(),
        };
    },
    components: {
        IonInput,
        IonItem,
        IonCheckbox,
        IonButton,
        IonCard,
        IonCardHeader,
        IonCardContent,
    },
    methods: {
        submitReservation() {
            this.reservation.from = this.$props.from;
            this.reservation.to = this.$props.to;
            this.$emit('submitReservationForGuest', this.reservation);
        },
    },
    emits: ['submitReservationForGuest'],
    props: {
        from: {
            type: Date,
            required: true,
        },
        to: {
            type: Date,
            required: true,
        },
    },
});
</script>

<template>
    <ion-card>
        <ion-card-header>Raum reservieren</ion-card-header>
        <ion-card-content>
            <form @submit.prevent="submitReservation">
                <ion-item>
                    <ion-input
                        label="Vorname*"
                        type="text"
                        v-model="reservation.firstName"
                        required
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-input
                        label="Nachname*"
                        type="text"
                        v-model="reservation.lastName"
                        required
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-input
                        label="E-Mail*"
                        type="email"
                        v-model="reservation.eMail"
                        required
                    ></ion-input>
                </ion-item>
                <ion-item>
                    <ion-checkbox v-model="reservation.breakfast"
                        >Frühstück Ja/Nein</ion-checkbox
                    >
                </ion-item>
                <ion-button type="submit">Reservieren</ion-button>
            </form>
        </ion-card-content>
    </ion-card>
</template>

<style scoped></style>
