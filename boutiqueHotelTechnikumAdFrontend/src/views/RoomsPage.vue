<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-menu-button color="primary"></ion-menu-button>
        </ion-buttons>
        <ion-title>Räume</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Räume</ion-title>
        </ion-toolbar>
      </ion-header>
      <RoomsItemListFilter @filterRoomItems="filterRooms"></RoomsItemListFilter>
      <RoomsItemList :rooms="roomStore.rooms" @navigateToDetail="navigateToDetail"></RoomsItemList>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {useRoomStore} from '@/store/roomsStore';
import {
  IonButtons,
  IonContent,
  IonHeader,
  IonMenuButton,
  IonPage,
  IonTitle,
  IonToolbar,
  toastController
} from '@ionic/vue';
import {useRouter} from 'vue-router';
import RoomsItemList from '../components/RoomsItem/RoomsItemList.vue';
import {Room} from '@/model/room';
import RoomsItemListFilter from "@/components/RoomsItem/RoomsItemListFilter.vue";

export default {
  components: {
    IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar, RoomsItemList,
    RoomsItemListFilter,},
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
    filterRooms() {
      this.roomStore.getRooms(this.roomStore.filter.from, this.roomStore.filter.to);
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
