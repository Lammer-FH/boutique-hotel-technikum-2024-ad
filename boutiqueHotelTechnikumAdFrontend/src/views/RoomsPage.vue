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
import RoomsItemList from '../components/RoomsItemList.vue';
import {Room} from '@/model/room';

export default {
  components: {IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar, RoomsItemList},
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
