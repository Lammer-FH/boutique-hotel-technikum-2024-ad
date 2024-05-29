<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-menu-button color="primary"></ion-menu-button>
        </ion-buttons>
        <ion-title>Home</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-header collapse="condense">
      <ion-toolbar>
        <ion-title size="large">Willkommen</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <h1>Willkommen zu Boutique Hotel Technikum</h1>
      <div>
        <p>
          Liebe Gäste, wir freuen uns sehr, Sie im Boutique Hotel Technikum
          begrüßen zu dürfen! Unser Hotel liegt im Herzen von [Stadt/Region],
          umgeben von malerischen Landschaften und nur einen Katzensprung
          entfernt von den wichtigsten Sehenswürdigkeiten und Attraktionen.
          Unser Team hat es sich zur Aufgabe gemacht, Ihnen einen
          unvergesslichen Aufenthalt zu bereiten. Genießen Sie den Komfort
          unserer stilvoll eingerichteten Zimmer, die exquisite Küche in unserem
          hauseigenen Restaurant und die Vielzahl an Freizeitmöglichkeiten, die
          Ihnen zur Verfügung stehen. Egal ob Sie geschäftlich oder privat
          unterwegs sind, wir bieten Ihnen erstklassigen Service und zahlreiche
          Annehmlichkeiten, um Ihren Aufenthalt so angenehm wie möglich zu
          gestalten. Unser Wellnessbereich lädt zum Entspannen ein, während
          unser Fitnesscenter dafür sorgt, dass Sie auch unterwegs fit bleiben.
          Erleben Sie die Gastfreundschaft und den Charme des Boutique Hotel
          Technikum. Wir stehen Ihnen jederzeit zur Verfügung, um Ihre Wünsche
          zu erfüllen und Ihren Aufenthalt perfekt zu machen. Herzlich
          willkommen und genießen Sie Ihren Aufenthalt!
        </p>
        <!--
          Long nice quote

          Photo Gallery

          Toole Pluspunkte für unser Hotel
        -->
        <ul>
          <li>
            <strong>Zentrale Lage</strong>: Unser Hotel liegt im Herzen von
            [Stadt/Region], in unmittelbarer Nähe zu den wichtigsten
            Sehenswürdigkeiten, Einkaufsmöglichkeiten und kulturellen
            Highlights.
          </li>
          <li>
            <strong>Komfortable Zimmer</strong>: Unsere Zimmer sind stilvoll und
            modern eingerichtet und bieten höchsten Komfort sowie
            Annehmlichkeiten wie kostenloses WLAN, Klimaanlage und
            Flachbildfernseher.
          </li>
          <li>
            <strong>Exquisites Restaurant</strong>: Genießen Sie in unserem
            hauseigenen Restaurant kulinarische Köstlichkeiten aus regionalen
            und internationalen Spezialitäten, zubereitet von unseren erfahrenen
            Küchenchefs.
          </li>
          <li>
            <strong>Entspannender Wellnessbereich</strong>: Lassen Sie die Seele
            baumeln in unserem luxuriösen Wellnessbereich mit Sauna, Dampfbad
            und einem breiten Angebot an Massage- und Beauty-Behandlungen.
          </li>
          <li>
            <strong>Modernes Fitnesscenter</strong>: Halten Sie sich fit in
            unserem gut ausgestatteten Fitnesscenter, das 24 Stunden für Sie
            geöffnet ist.
          </li>
          <li>
            <strong>Freundlicher und professioneller Service</strong>: Unser
            engagiertes Team steht Ihnen rund um die Uhr zur Verfügung, um Ihnen
            einen angenehmen und unvergesslichen Aufenthalt zu ermöglichen.
          </li>
          <li>
            <strong>Kostenloses WLAN</strong>: Bleiben Sie stets verbunden mit
            unserem kostenlosen Highspeed-WLAN, das im gesamten Hotel verfügbar
            ist.
          </li>
          <li>
            <strong>Flexible Tagungs- und Veranstaltungsräume</strong>: Für
            geschäftliche oder private Anlässe bieten wir moderne Tagungs- und
            Veranstaltungsräume mit neuester Technik und maßgeschneidertem
            Service.
          </li>
          <li>
            <strong>Familienfreundlich</strong>: Wir heißen Familien herzlich
            willkommen und bieten spezielle Familienzimmer sowie zahlreiche
            Aktivitäten und Services für Kinder.
          </li>
          <li>
            <strong>Haustierfreundlich</strong>: Ihre vierbeinigen Freunde sind
            bei uns ebenfalls willkommen. Wir bieten spezielle Annehmlichkeiten
            und Services für Haustiere.
          </li>
          <li>
            <strong>Kostenloser Shuttle-Service</strong>: Nutzen Sie unseren
            kostenlosen Shuttle-Service zu wichtigen Zielen in der Umgebung, wie
            zum Beispiel dem Flughafen oder den wichtigsten Sehenswürdigkeiten.
          </li>
          <li>
            <strong>Umweltfreundliches Hotel</strong>: Wir setzen auf
            Nachhaltigkeit und umweltfreundliche Praktiken, um unseren
            ökologischen Fußabdruck zu minimieren.
          </li>
          <li>
            <strong>Attraktive Sonderangebote und Pakete</strong>: Profitieren
            Sie von unseren regelmäßig wechselnden Sonderangeboten und
            Urlaubspaketen, die Ihnen einen noch angenehmeren Aufenthalt
            ermöglichen.
          </li>
        </ul>
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
