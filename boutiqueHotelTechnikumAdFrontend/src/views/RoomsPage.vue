<template>
    <PageTemplate>
        <template #menuTitle> Available Rooms </template>
        <template #title> Rooms </template>
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
import { loadingController } from '@ionic/vue';
import { useRouter } from 'vue-router';
import RoomsItemList from '../components/RoomsItem/RoomsItemList.vue';
import { Room } from '@/model/room';
import PageTemplate from '@/components/PageTemplate.vue';
import RoomsItemListFilter from '@/components/RoomsItem/RoomsItemListFilter.vue';
import HelperService from '../service/HelperService';

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
                    HelperService.showToast(
                        'The rooms could not be loaded!',
                        true,
                        'top'
                    );
                })
                .finally(() => {
                    loadingIndicator.dismiss();
                });
        },
        async showLoading() {
            const loading = await loadingController.create({
                message: 'Loading rooms...',
            });

            await loading.present();
            return loading;
        },
    },
};
</script>

<style scoped></style>
