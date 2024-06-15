<template>
    <PageTemplate :use-back-button="true">
        <template #menuTitle> Reservation </template>
        <template #title>
            Reservation for - {{ reservation.roomTitle }}
        </template>
    </PageTemplate>
</template>

<script lang="ts">
import { useRoomStore } from '@/store/roomsStore';
import { toastController } from '@ionic/vue';
import { useRoute } from 'vue-router';
import RoomsItemList from '../components/RoomsItem/RoomsItemList.vue';
import PageTemplate from '@/components/PageTemplate.vue';

export default {
    components: {
        PageTemplate,
        RoomsItemList,
    },
    data: () => {
        const roomStore = useRoomStore();
        return {
            roomStore,
            reservation: roomStore.reservation,
            route: useRoute(),
        };
    },
    ionViewWillEnter() {
        console.log(this.route.params['id']);
        this.roomStore
            .getReservationConfirmation(this.route.params['id'] as string)
            .catch((error) => {});
    },
    methods: {},
};
</script>

<style scoped></style>
../components/RoomsItem.vue
