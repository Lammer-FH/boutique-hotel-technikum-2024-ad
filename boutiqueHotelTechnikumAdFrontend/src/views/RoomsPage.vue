<template>
    <PageTemplate>
        <template #menuTitle> Räume </template>
        <template #title> Räume </template>
        <RoomsItemListFilter
            @filterRoomItems="filterRooms"
        ></RoomsItemListFilter>
        <RoomsItemList
            :rooms="roomStore.rooms"
            @navigateToDetail="navigateToDetail"
        ></RoomsItemList>
    </PageTemplate>
</template>

<script lang="ts">
import { useRoomStore } from '@/store/roomsStore';
import { loadingController, toastController } from '@ionic/vue';
import { useRouter } from 'vue-router';
import RoomsItemList from '../components/RoomsItem/RoomsItemList.vue';
import { Room } from '@/model/room';
import PageTemplate from '@/components/PageTemplate.vue';
import RoomsItemListFilter from '@/components/RoomsItem/RoomsItemListFilter.vue';

export default {
    components: {
        PageTemplate,
        RoomsItemList,
        RoomsItemListFilter,
    },
    data: () => {
        return {
            roomStore: useRoomStore(),
            router: useRouter(),
        };
    },
    methods: {
        navigateToDetail(room: Room) {
            this.roomStore.selectRoom(room);
            this.router.push('/rooms/' + room.id);
        },
        async filterRooms() {
            const loadingIndicator = await this.showLoading();
            this.roomStore
                .getRooms(this.roomStore.filter.from, this.roomStore.filter.to)
                .catch(() => {
                    this.showError('bottom');
                })
                .finally(() => {
                    loadingIndicator.dismiss();
                });
        },
        async showError(position: 'top' | 'middle' | 'bottom') {
            const toast = await toastController.create({
                message: 'Die Räume konnten nicht geladen werden!',
                duration: 3000,
                position: position,
                color: 'danger',
            });
            await toast.present();
        },
        async showLoading() {
            const loading = await loadingController.create({
                message: 'Räume werden geladen...',
            });

            await loading.present();
            return loading;
        },
    },
};
</script>

<style scoped></style>
