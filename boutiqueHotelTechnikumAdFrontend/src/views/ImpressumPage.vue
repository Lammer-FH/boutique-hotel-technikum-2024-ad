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
      <div id="container">
        <p>Für den Inhalt auf dieser Website verantwortlich</p>
        <h2>Hotel Schani GmbH</h2>
        <p>
          Hotel Boutique Hotel Technikum GmbH<br />
          Example-Straße 42<br />
          1100 Wien, Austria<br />
        </p>
      </div>
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
</script>

<style scoped>
#container {
  text-align: center;
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  transform: translateY(-50%);
}

#container strong {
  font-size: 1.25rem;
  line-height: 1.625rem;
}

#container p {
  font-size: 1rem;
  line-height: 1.375rem;
  color: #8c8c8c;
  margin: 0;
}

#container a {
  text-decoration: none;
}
</style>
