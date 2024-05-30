<template>
  <ion-card>
    <ion-img alt="" :src="room.imagePath"/>
    <ion-card-header>
      <ion-card-title>{{ room.title }}</ion-card-title>
    </ion-card-header>
    <ion-card-content>
      {{ room.description }}
      <ion-badge v-for="extra in room.extras" :key="extra">{{ extra }}</ion-badge>
      <ion-button @click="$emit('clickDetail')">Go to detail</ion-button>
    </ion-card-content>
  </ion-card>
</template>

<script lang="ts">
import {IonBadge, IonButton, IonCard, IonCardContent, IonCardHeader, IonCardTitle, IonImg} from '@ionic/vue';

export default {
  components: {IonCard, IonCardContent, IonCardHeader, IonCardTitle, IonBadge, IonButton, IonImg},
  props: {
    room: {
      type: Object,
      required: true
    },
  },
  emits: ['clickDetail']
}
</script>
<style scoped></style>