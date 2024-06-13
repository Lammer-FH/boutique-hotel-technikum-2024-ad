<template>
  <ion-card>
    <ImageDisplay :path="room.imagePath"></ImageDisplay>
    <ion-card-header>
      <ion-card-title>{{ room.title }}</ion-card-title>
    </ion-card-header>
    <ion-card-content>
      <ion-text>{{ room.description }}</ion-text>
    </ion-card-content>
    <ion-card-content>
      <ExtrasDisplay :extras="room.extras"></ExtrasDisplay>
    </ion-card-content>
    <ion-button fill="clear" @click="$emit('clickDetail')">Go to detail</ion-button>
  </ion-card>
</template>

<script lang="ts">
import { Room } from '@/model/room';
import {IonButton, IonCard, IonCardContent, IonCardHeader, IonCardTitle, IonText} from '@ionic/vue';
import ImageDisplay from './ImageDisplay.vue';
import ExtrasDisplay from './ExtrasDisplay.vue';
import {PropType} from "vue";

export default {
  components: {IonCard, IonCardContent, IonCardHeader, IonCardTitle, IonButton, IonText,
    ImageDisplay, ExtrasDisplay},
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