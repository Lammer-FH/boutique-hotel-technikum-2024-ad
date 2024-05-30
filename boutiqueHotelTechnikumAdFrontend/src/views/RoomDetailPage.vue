<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button></ion-back-button>
        </ion-buttons>
        <ion-title>Raum</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Raum</ion-title>
        </ion-toolbar>
      </ion-header>
      <h1>Raum - {{ roomStore.selectedRoom.title }}</h1>
      <ion-img alt="" :src="roomStore.selectedRoom.imagePath"/>
      <ion-badge v-for="extra in roomStore.selectedRoom.extras" :key="extra">{{ extra }}</ion-badge>
      <p>
        {{ roomStore.selectedRoom.description }}
      </p>
      <p>{{ roomStore.selectedRoom.price }} € per Person</p>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {useRoomStore} from '@/store/roomsStore';
import {
  IonButtons,
  IonContent,
  IonHeader,
  IonBackButton,
  IonPage,
  IonTitle,
  IonToolbar,
  IonImg,
  IonBadge
} from '@ionic/vue';

export default {
  components: {IonBadge, IonImg, IonButtons, IonContent, IonHeader, IonBackButton, IonPage, IonTitle, IonToolbar},
  data: () => {
    return {
      roomStore: useRoomStore(),
    }
  },
}
</script>

<style scoped></style>
