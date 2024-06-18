<template>
    <PageTemplate :use-back-button="true">
        <template #menuTitle> Room - {{ selectedRoom.title }} </template>
        <template #title> Room - {{ selectedRoom.title }} </template>
        <h1>Room - {{ selectedRoom.title }}</h1>

        <ImageDisplay :path="selectedRoom.imagePath"></ImageDisplay>

        <h2>Description:</h2>
        <p>{{ selectedRoom.description }}</p>

        <h2>Extras:</h2>
        <ExtrasDisplay :extras="selectedRoom.extras"></ExtrasDisplay>

        <h2>Price:</h2>
        <div class="price">
            <p>{{ selectedRoom.price }} € per person</p>
            <ReservationFormModal></ReservationFormModal>
        </div>
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

.price {
    display: flex;
    flex-direction: column;
}

@media only screen and (min-width: 600px) {
    .price {
        flex-direction: row;
        > p {
            margin-right: 1rem;
            font-size: larger;
        }
    }
}
</style>
