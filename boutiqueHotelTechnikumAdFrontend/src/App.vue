<template>
    <ion-app>
        <ion-split-pane content-id="main-content">
            <ion-menu content-id="main-content" type="overlay">
                <ion-content>
                    <ion-list id="inbox-list">
                        <ion-list-header
                            >Boutique Hotel Technikum</ion-list-header
                        >

                        <ion-menu-toggle
                            :auto-hide="false"
                            v-for="(p, i) in appPages"
                            :key="i"
                        >
                            <ion-item
                                @click="selectedIndex = i"
                                router-direction="root"
                                :router-link="p.url"
                                lines="none"
                                :detail="false"
                                class="hydrated"
                                :class="{ selected: selectedIndex === i }"
                            >
                                <ion-icon
                                    aria-hidden="true"
                                    slot="start"
                                    :ios="p.iosIcon"
                                    :md="p.mdIcon"
                                ></ion-icon>
                                <ion-label>{{ p.title }}</ion-label>
                            </ion-item>
                        </ion-menu-toggle>
                    </ion-list>
                </ion-content>
            </ion-menu>
            <ion-router-outlet id="main-content"></ion-router-outlet>
        </ion-split-pane>
    </ion-app>
</template>

<script setup lang="ts">
import {
    IonApp,
    IonContent,
    IonIcon,
    IonItem,
    IonLabel,
    IonList,
    IonListHeader,
    IonMenu,
    IonMenuToggle,
    IonRouterOutlet,
    IonSplitPane,
} from '@ionic/vue';
import { ref } from 'vue';
import {
    heartOutline,
    heartSharp,
    mailOutline,
    mailSharp,
    paperPlaneOutline,
    paperPlaneSharp,
    bookmarksOutline,
    bookmarksSharp,
} from 'ionicons/icons';
import { routeUrls } from './navigation.config';

const selectedIndex = ref(0);
const appPages = [
    {
        title: 'Home',
        url: routeUrls.home,
        iosIcon: mailOutline,
        mdIcon: mailSharp,
    },
    {
        title: 'About',
        url: routeUrls.about,
        iosIcon: paperPlaneOutline,
        mdIcon: paperPlaneSharp,
    },
    {
        title: 'Impressum',
        url: routeUrls.impressum,
        iosIcon: heartOutline,
        mdIcon: heartSharp,
    },
    {
        title: 'Rooms',
        url: routeUrls.rooms,
        iosIcon: bookmarksOutline,
        mdIcon: bookmarksSharp,
    },
];

const path = window.location.pathname;
if (path !== undefined) {
    selectedIndex.value = appPages.findIndex((page) => page.url === path);
}
</script>

<style scoped>
ion-menu ion-content {
    --background: var(--ion-item-background, var(--ion-background-color, #fff));
}

ion-menu.md ion-content {
    --padding-start: 0.5rem;
    --padding-end: 0.5rem;
    --padding-top: 1.25rem;
    --padding-bottom: 1.25rem;
}

ion-menu.md ion-list {
    padding: 1.25rem 0;
}

ion-menu.md ion-note {
    margin-bottom: 1.875rem;
}

ion-menu.md ion-list-header,
ion-menu.md ion-note {
    padding-left: 0.625rem;
}

ion-menu.md ion-list#inbox-list {
    border-bottom: 1px solid var(--ion-background-color-step-150, #d7d8da);
}

ion-menu.md ion-list#inbox-list ion-list-header {
    font-size: 1.375rem;
    font-weight: 600;

    min-height: 1.25rem;
}

ion-menu.md ion-list#labels-list ion-list-header {
    font-size: 1rem;

    margin-bottom: 10.5rem;

    color: #757575;

    min-height: 1.625rem;
}

ion-menu.md ion-item {
    --padding-start: 0.625rem;
    --padding-end: 0.625rem;
    border-radius: 4px;
}

ion-menu.md ion-item.selected {
    --background: rgba(var(--ion-color-primary-rgb), 0.14);
}

ion-menu.md ion-item.selected ion-icon {
    color: var(--ion-color-primary);
}

ion-menu.md ion-item ion-icon {
    color: #616e7e;
}

ion-menu.md ion-item ion-label {
    font-weight: 500;
}

ion-menu.ios ion-content {
    --padding-bottom: 1.25rem;
}

ion-menu.ios ion-list {
    padding: 1.25rem 0 0 0;
}

ion-menu.ios ion-note {
    line-height: 1.5rem;
    margin-bottom: 1.25rem;
}

ion-menu.ios ion-item {
    --padding-start: 1rem;
    --padding-end: 1rem;
    --min-height: 3.125rem;
}

ion-menu.ios ion-item.selected ion-icon {
    color: var(--ion-color-primary);
}

ion-menu.ios ion-item ion-icon {
    font-size: 1.5rem;
    color: #73849a;
}

ion-menu.ios ion-list#labels-list ion-list-header {
    margin-bottom: 0.5rem;
}

ion-menu.ios ion-list-header,
ion-menu.ios ion-note {
    padding-left: 1rem;
    padding-right: 1rem;
}

ion-menu.ios ion-note {
    margin-bottom: 0.5rem;
}

ion-note {
    display: inline-block;
    font-size: 1rem;

    color: var(--ion-color-medium-shade);
}

ion-item.selected {
    --color: var(--ion-color-primary);
}

@media print {
    ion-header,
    ion-backdrop,
    .tabbar,
    ion-footer,
    ion-content::part(background) {
        display: none !important;
    }
    ion-nav {
        contain: none;
        overflow: visible;
    }
    ion-split-pane {
        display: block;
    }
    .scroll-content,
    ion-modal,
    ion-modal .modal-wrapper,
    ion-modal .ion-page,
    ion-modal .ion-page > ion-content,
    .ion-page,
    .ion-page > ion-content,
    ion-split-pane,
    ion-tab,
    ion-tabs,
    ion-router-outlet,
    .app-root,
    ion-content::part(scroll),
    body {
        contain: none;
        position: initial;
        height: auto;
        overflow: visible;
    }
    .fixed-content,
    .scroll-content {
        margin-top: 0 !important;
    }
}
</style>
