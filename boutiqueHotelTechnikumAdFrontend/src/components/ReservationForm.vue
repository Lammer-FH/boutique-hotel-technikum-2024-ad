<script lang="ts">
import { defineComponent } from 'vue';
import { IonButton, modalController } from '@ionic/vue';
import ReservationFormModal from './ReservationFormModal.vue';

export default defineComponent({
    name: 'ReservationForm',
    components: {
        IonButton,
    },
    methods: {
        async openModal() {
            const modal = await modalController.create({
                component: ReservationFormModal,
            });

            modal.present();
        },
    },
});
</script>

<template>
    <ion-button @click="openModal" expand="block">Reservieren</ion-button>
</template>

<style scoped></style>
