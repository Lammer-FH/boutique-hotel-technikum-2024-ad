<template>
    <PageTemplate :use-back-button="true">
        <template #menuTitle> Raum - {{ selectedRoom.title }} </template>
        <template #title> Raum - {{ selectedRoom.title }} </template>
        <h1>Raum - {{ selectedRoom.title }}</h1>

        <ImageDisplay :path="selectedRoom.imagePath"></ImageDisplay>

        <h2>Beschreibung:</h2>
        <p>{{ selectedRoom.description }}</p>

        <h2>Extras:</h2>
        <ExtrasDisplay :extras="selectedRoom.extras"></ExtrasDisplay>

        <h2>Preis:</h2>
        <p>{{ selectedRoom.price }} € per Person</p>
        <ReservationForm
            :from="roomStore.filter.from"
            :to="roomStore.filter.to"
            @submitReservationForGuest="submitReservation"
        ></ReservationForm>
    </PageTemplate>
</template>

<script lang="ts">
import ExtrasDisplay from '@/components/ExtrasDisplay.vue';
import ImageDisplay from '@/components/ImageDisplay.vue';
import PageTemplate from '@/components/PageTemplate.vue';
import { useRoomStore } from '@/store/roomsStore';
import ReservationForm from '@/components/ReservationForm.vue';
import { Reservation } from '@/model/reservation';

export default {
    components: {
        ReservationForm,
        ImageDisplay,
        ExtrasDisplay,
        PageTemplate,
    },
    data: () => {
        const roomStore = useRoomStore();
        return {
            roomStore,
            selectedRoom: roomStore.selectedRoom,
        };
    },
    methods: {
        submitReservation(reservation: Reservation) {
            this.roomStore.reserveRoom(this.selectedRoom, reservation);
        },
    },
};
</script>

<style scoped>
.image-display {
    height: 50%;
    width: 100%;
}
</style>
