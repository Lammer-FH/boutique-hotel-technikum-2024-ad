<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-menu-button color="primary"></ion-menu-button>
        </ion-buttons>
        <ion-title>Impressum</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">{{ $route.params.id }}</ion-title>
        </ion-toolbar>
      </ion-header>
      <h1>Impressum der Boutique Hotel Technikum</h1>
      <!-- TODO: eigene componente für den container -->
      <content-container>
        <p>Für den Inhalt auf dieser Website verantwortlich</p>
        <h2>Hotel Schani GmbH</h2>
        <p>
          Hotel Boutique Hotel Technikum GmbH<br />
          Example-Straße 42<br />
          1100 Wien, Austria<br />
        </p>
      </content-container>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonButtons,
  IonContent,
  IonHeader,
  IonMenuButton,
  IonPage,
  IonTitle,
  IonToolbar,
} from "@ionic/vue";
import ContentContainer from "../components/ContentContainer.vue";
</script>
