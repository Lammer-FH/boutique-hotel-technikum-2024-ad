<template>
    <PageTemplate :use-back-button="true">
        <template #menuTitle> Reservation </template>
        <template #title>
            Reservation for - {{ roomStore.reservation.roomTitle }}
        </template>
        <section>
            <h1>
                Reservation from
                {{ roomStore.reservation.from.split('T')[0] }} to
                {{ roomStore.reservation.to.split('T')[0] }}
            </h1>
            <p>E-Mail: {{ roomStore.reservation.eMail }}</p>
            <p>Firstname: {{ roomStore.reservation.firstName }}</p>
            <p>Lastname: {{ roomStore.reservation.lastName }}</p>
            <p>
                Breakfast:
                {{ roomStore.reservation.doBreakfast ? 'Yes' : 'No' }}
            </p>
        </section>
        <section v-if="roomStore.reservation !== undefined">
            <h2>Room - {{ roomStore.reservation.roomTitle }}</h2>
            <ImageDisplay
                :path="roomStore.reservation.imagePath"
            ></ImageDisplay>
            <h3>Beschreibung:</h3>
            <p>{{ roomStore.reservation.roomDescription }}</p>
            <h3 class="extra">Extras:</h3>
            <ExtrasDisplay
                :extras="roomStore.reservation.extras"
                class="extra"
            ></ExtrasDisplay>
            <h3>Preis:</h3>
            <p>{{ roomStore.reservation.roomPrice }} € per person</p>
        </section>
        <section>
            <h2>Jounrey description</h2>
            <p>Höchstädtplatz 6</p>
            <p>1200 Wien</p>
            <h3>Public transport</h3>
            <p>U-Bahn: U6 - Station Dresdner Straße</p>
            <p>
                Straßenbahnen: Linie 2, Linie 31, Linie 33 - Station
                Höchstädtplatz
            </p>
            <p>Schnellbahnen: Station Handelskai bzw. Traisengasse</p>
            <p>Autobus: Linie 37A - Station Höchstädtplatz</p>
        </section>
        <section>
            <MapDisplay></MapDisplay>
        </section>
        <section>
            <h2>Contact</h2>
            <p>Tel: +43 XXXX XXXX</p>
            <p>Email: hotel-email@example.at</p>
        </section>
    </PageTemplate>
</template>

<script lang="ts">
import { useRoomStore } from '@/store/roomsStore';
import { useRoute } from 'vue-router';
import PageTemplate from '@/components/PageTemplate.vue';
import ExtrasDisplay from '@/components/ExtrasDisplay.vue';
import ImageDisplay from '@/components/ImageDisplay.vue';
import MapDisplay from '@/components/MapDisplay.vue';

export default {
    components: {
        PageTemplate,
        ImageDisplay,
        ExtrasDisplay,
        MapDisplay,
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
            .catch((_) => {});
    },
    methods: {},
};
</script>

<style scoped>
.image-display {
    height: 50%;
    width: 100%;
}

@media only screen and (min-width: 600px) {
    .image-display {
        height: 25rem;
        width: auto;
    }
}

@media print {
    .image-display {
        display: none;
    }
    .extra {
        display: none;
    }
}
</style>
