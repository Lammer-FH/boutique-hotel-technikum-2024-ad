<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-menu-button color="primary"></ion-menu-button>
        </ion-buttons>
        <ion-title>About</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">About</ion-title>
        </ion-toolbar>
      </ion-header>
      <h1>Boutique Hotel Technikum: Where Elegance Meets Comfort</h1>
      <p>
        Welcome to <strong>Boutique Hotel Technikum</strong>, a hidden gem
        nestled in the heart of Vienna. Our commitment to personalized service
        and attention to detail sets us apart as a unique 4-star hotel. Whether
        you’re visiting for business or leisure, we invite you to experience the
        warmth and charm that define our establishment.
      </p>
      <h2>Prime Location</h2>
      <p>
        Situated in the vibrant city center, Boutique Hotel Technikum offers
        unparalleled convenience. Just steps away from iconic landmarks,
        including St. Stephen’s Cathedral, our central location allows you to
        explore Vienna’s rich history and culture effortlessly. Popular shopping
        streets and public transportation hubs are right at our doorstep, making
        it easy to navigate the city.
      </p>
      <h2>Refined Comfort</h2>
      <p>
        Our recently refurbished rooms blend modern elegance with comfort. Sink
        into plush beds, surrounded by tasteful decor and soothing colors. Each
        room is equipped with amenities to enhance your stay, including blackout
        curtains, a coffee/tea maker, and high-speed Wi-Fi. Whether you’re here
        for work or relaxation, we’ve created a tranquil oasis for you.
      </p>
      <h2>Relax and Unwind</h2>
      <p>
        After a day of sightseeing or meetings, indulge in our little spa. Let
        the stress melt away as you rejuvenate in our wellness area.
        Alternatively, savor a cup of coffee and a slice of cake at our charming
        Café Giacomo Aragall. For wine enthusiasts, our selection of excellent
        wines awaits – the perfect way to unwind while watching the city’s
        hustle and bustle from our unique vantage point.
      </p>
      <h2>Your Home Away from Home</h2>
      <p>
        At Boutique Hotel Technikum, we treat every guest like family. Our
        dedicated staff is here to ensure your stay is memorable and
        comfortable. Whether you need local recommendations, assistance with
        reservations, or simply a friendly chat, we’re always at your service.
      </p>
      <p>
        We look forward to welcoming you soon to Boutique Hotel Technikum, where
        Viennese hospitality meets sophistication. 🌟
      </p>
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
