<template>
  <PageTemplate :use-back-button="true">
    <template #menuTitle>
      Räume
    </template>
    <template #title>
      Räume
    </template>
      <RoomsItemList :rooms="roomStore.rooms" @navigateToDetail="navigateToDetail"></RoomsItemList>
  </PageTemplate>
</template>

<script lang="ts">
import {useRoomStore} from '@/store/roomsStore';
import {
  toastController
} from '@ionic/vue';
import {useRouter} from 'vue-router';
import RoomsItemList from '../components/RoomsItemList.vue';
import {Room} from '@/model/room';
import PageTemplate from "@/components/PageTemplate.vue";

export default {
  components: {
    PageTemplate, RoomsItemList},
  data: () => {
    return {
      roomStore: useRoomStore(),
      router: useRouter(),
    }
  },
  ionViewWillEnter() {
    this.roomStore.getRooms()
        .catch((error) => {
          this.showError('bottom');
          console.log(error)
        });
  },
  methods: {
    navigateToDetail(room: Room) {
      this.roomStore.selectRoom(room);
      this.router.push('/rooms/' + room.id);
    },
    async showError(position: 'top' | 'middle' | 'bottom') {
      const toast = await toastController.create({
        message: 'Die Räume konnten nicht geladen werden!',
        duration: 3000,
        position: position,
        color: "danger",
      });
      await toast.present();
    },
  }
}
</script>

<style scoped></style>../components/RoomsItem.vue
