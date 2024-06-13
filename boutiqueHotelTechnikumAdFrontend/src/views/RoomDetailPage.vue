<template>
  <PageTemplate :use-back-button="true">
    <template #menuTitle>
      Raum - {{ selectedRoom.title }}
    </template>
    <template #title>
      Raum - {{ selectedRoom.title }}
    </template>

    <ion-list>
      <ion-list-header>
        <ion-title>Raum - {{ selectedRoom.title }}</ion-title>
      </ion-list-header>
      <ion-item>
        <ion-label>Beschreibung:</ion-label>
        <ion-text>{{ selectedRoom.description }}</ion-text>
      </ion-item>
      <ion-item>
        <ion-label>Preis:</ion-label>
        <ion-text>{{ selectedRoom.price }} € per Person</ion-text>
      </ion-item>
      <ion-item>
        <ion-label>Extras:</ion-label>
        <ExtrasDisplay :extras="selectedRoom.extras"></ExtrasDisplay>
      </ion-item>
      <ion-item>
        <ImageDisplay :path="selectedRoom.imagePath"></ImageDisplay>
      </ion-item>
    </ion-list>
  </PageTemplate>
</template>

<script lang="ts">
import ExtrasDisplay from '@/components/ExtrasDisplay.vue';
import ImageDisplay from '@/components/ImageDisplay.vue';
import PageTemplate from '@/components/PageTemplate.vue';
import {useRoomStore} from '@/store/roomsStore';
import {IonItem, IonLabel, IonList, IonListHeader, IonText, IonTitle} from "@ionic/vue";

export default {
  components: {
    ImageDisplay, ExtrasDisplay, PageTemplate,
    IonTitle, IonLabel, IonList, IonListHeader, IonText, IonItem,
  },
  data: () => {
    const roomStore = useRoomStore()
    return {
      roomStore,
      selectedRoom: roomStore.selectedRoom
    }
  },
}
</script>

<style scoped></style>
