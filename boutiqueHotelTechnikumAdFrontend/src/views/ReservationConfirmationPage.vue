<template>
    <PageTemplate :use-back-button="true">
        <template #menuTitle> Reservation </template>
        <template #title>
            Reservation for - {{ roomStore.reservation.roomTitle }}
        </template>
        <h1>
            Reservation from {{ roomStore.reservation.from }} -
            {{ roomStore.reservation.to }}
        </h1>
        <p>{{ roomStore.reservation.eMail }}</p>
        <p>{{ roomStore.reservation.firstName }}</p>
        <p>{{ roomStore.reservation.lastName }}</p>
        <p>{{ roomStore.reservation.doBreakfast ? 'Yes' : 'No' }}</p>
        <h2>Room - {{ roomStore.reservation.roomTitle }}</h2>
        <ImageDisplay :path="roomStore.reservation.imagePath"></ImageDisplay>
        <h3>Beschreibung:</h3>
        <p>{{ roomStore.reservation.roomDescription }}</p>
        <h3>Extras:</h3>
        <ExtrasDisplay :extras="roomStore.reservation.extras"></ExtrasDisplay>

        <h3>Preis:</h3>
        <p>{{ roomStore.reservation.roomPrice }} € per Person</p>
        <h2>Jounrey description</h2>
        <p>Höchstädtplatz 6</p>
        <p>1200 Wien</p>
        <h3>Public transport</h3>
        <p>U-Bahn: U6 - Station Dresdner Straße</p>
        <p>
            Straßenbahnen: Linie 2, Linie 31, Linie 33 - Station Höchstädtplatz
        </p>
        <p>Schnellbahnen: Station Handelskai bzw. Traisengasse</p>
        <p>Autobus: Linie 37A – Station Höchstädtplatz</p>
        <h2>Contact</h2>
        <p>Tel: +43 XXXX XXXX</p>
        <p>Email: hotel-email@example.at</p>
    </PageTemplate>
</template>

<script lang="ts">
import { useRoomStore } from '@/store/roomsStore';
import { toastController } from '@ionic/vue';
import { useRoute } from 'vue-router';
import RoomsItemList from '../components/RoomsItem/RoomsItemList.vue';
import PageTemplate from '@/components/PageTemplate.vue';
import ExtrasDisplay from '@/components/ExtrasDisplay.vue';
import ImageDisplay from '@/components/ImageDisplay.vue';

export default {
    components: {
        PageTemplate,
        RoomsItemList,
        ImageDisplay,
    },
    data: () => {
        return {
            roomStore: useRoomStore(),
            route: useRoute(),
        };
    },
    ionViewWillEnter() {
        this.roomStore
            .getReservationConfirmation(this.route.params['id'] as string)
            .catch((error) => {});
    },
    methods: {},
};
</script>

<style scoped></style>
