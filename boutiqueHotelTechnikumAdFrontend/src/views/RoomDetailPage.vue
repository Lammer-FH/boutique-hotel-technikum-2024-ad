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

        <ReservationFormModal></ReservationFormModal>
    </PageTemplate>
</template>

<script lang="ts">
import ExtrasDisplay from '@/components/ExtrasDisplay.vue';
import ImageDisplay from '@/components/ImageDisplay.vue';
import PageTemplate from '@/components/PageTemplate.vue';
import { useRoomStore } from '@/store/roomsStore';
import ReservationFormModal from '@/components/ReservationFormModal.vue';

export default {
    components: {
        ReservationFormModal,
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
};
</script>

<style scoped>
.image-display {
    height: 50%;
    width: 100%;
}
</style>
