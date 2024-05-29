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
      <h1>Räume</h1>
      <ion-card v-for="room in rooms">
        <ion-card-header>
          <ion-card-title>{{ room.name }}</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ion-button @click="() => router.push('/rooms/' + room.id)">Go to detail</ion-button>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

var rooms = ref([{name:'Test', id:1}]);

const router = useRouter();
</script>

<style scoped>

</style>
