<template>
  <ion-card>
    <ImageDisplay :path="room.imagePath"></ImageDisplay>
    <ion-card-header>
      <ion-card-title>{{ room.title }}</ion-card-title>
    </ion-card-header>
    <ion-card-content>
      {{ room.description }}
      <ExtrasDisplay :extras="room.extras"></ExtrasDisplay>
      <ion-button @click="$emit('clickDetail')">Go to detail</ion-button>
    </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
import { Room } from '@/model/room';
import {IonButton, IonCard, IonCardContent, IonCardHeader, IonCardTitle} from '@ionic/vue';
import ImageDisplay from './ImageDisplay.vue';
import ExtrasDisplay from './ExtrasDisplay.vue';
import {PropType} from "vue";

export default {
  components: {IonCard, IonCardContent, IonCardHeader, IonCardTitle, IonButton, ImageDisplay, ExtrasDisplay},
  props: {
    room: {
      type: Object as PropType<Room>,
      required: true
    },
  },
  emits: ['clickDetail']
}
</script>
<style scoped></style>