<template>
    <ion-card class="desktop-card">
        <div>
            <ImageDisplay :path="room.imagePath"></ImageDisplay>
        </div>
        <div>
            <div>{{ room.title }}</div>
            <div>{{ room.description }}</div>
            <div>
                <ExtrasDisplay :extras="room.extras"></ExtrasDisplay>
            </div>
        </div>
        <div>
            <ion-button
                fill="clear"
                @click="$emit('clickDetail')"
                class="desktop-button"
                >Go to detail</ion-button
            >
        </div>
    </ion-card>

    <ion-card class="mobile-card">
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
        <ion-button fill="clear" @click="$emit('clickDetail')"
            >Go to detail</ion-button
        >
    </ion-card>
</template>

<script lang="ts">
import { Room } from '@/model/room';
import { IonButton, IonCard } from '@ionic/vue';
import ImageDisplay from './ImageDisplay.vue';
import ExtrasDisplay from './ExtrasDisplay.vue';
import { PropType } from 'vue';

export default {
    components: {
        IonCard,
        IonButton,
        ImageDisplay,
        ExtrasDisplay,
    },
    props: {
        room: {
            type: Object as PropType<Room>,
            required: true,
        },
    },
    emits: ['clickDetail'],
};
</script>
<style scoped>
.mobile-card {
    display: block;
    padding: 1em;
    background-color: #3e3c3e;
}

.image-display {
    height: auto;
    padding: auto;
}

.desktop-card {
    display: none;
}

@media only screen and (min-width: 600px) {
    .desktop-card {
        display: flex;
        padding: 1em;
        background-color: #3e3c3e;
        gap: 1em;
        align-items: center;
    }

    .image-display {
        height: 10rem;
        padding: 0;
    }

    .desktop-button {
        width: 10rem;
    }

    .mobile-card {
        display: none;
    }
}
</style>
