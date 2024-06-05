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
      <RoomsItem v-for="room in roomStore.rooms" :key="room.id"
                 @clickDetail="() => { navigateToDetail(room); }" :room="room"/>
    </ion-content> 
  </ion-page>
</template>

<script lang="ts">
import {useRoomStore} from '@/store/roomsStore';
import {IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar} from '@ionic/vue';
import {useRouter} from 'vue-router';
import RoomsItem from '../components/RoomsItem.vue';
import { Room } from '@/model/room';

export default {
  components: {IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar, RoomsItem},
  data: () => {
    return {
      roomStore: useRoomStore(),
      router: useRouter(),
    }
  },
  ionViewWillEnter() {
    this.roomStore.getRooms();
  },
  methods: {
    navigateToDetail(room : Room) {
      this.roomStore.selectRoom(room);
      this.router.push('/rooms/' + room.id);
    }
  }
}
</script>

<style scoped></style>../components/RoomsItem.vue
