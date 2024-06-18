<template>
    <ion-page>
        <ion-header :translucent="true">
            <ion-toolbar>
                <ion-buttons slot="start" v-if="useBackButton">
                    <ion-back-button></ion-back-button>
                </ion-buttons>
                <ion-buttons slot="start" v-else>
                    <ion-menu-button color="primary"></ion-menu-button>
                </ion-buttons>
                <ion-title>
                    <slot name="menuTitle"></slot>
                </ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-header collapse="condense">
            <ion-toolbar>
                <ion-title size="large">
                    <slot name="title"></slot>
                </ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true" class="ion-padding">
            <slot></slot>
        </ion-content>
    </ion-page>
</template>

<script lang="ts">
import {
    IonBackButton,
    IonButtons,
    IonContent,
    IonHeader,
    IonMenuButton,
    IonPage,
    IonTitle,
    IonToolbar,
} from '@ionic/vue';

export default {
    components: {
        IonPage,
        IonContent,
        IonToolbar,
        IonHeader,
        IonButtons,
        IonMenuButton,
        IonTitle,
        IonBackButton,
    },
    props: {
        useBackButton: {
            type: Boolean,
            default: false,
        },
    },
};
</script>
