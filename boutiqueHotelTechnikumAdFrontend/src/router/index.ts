import { routeUrls } from '@/navigation.config';
import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
    {
        path: routeUrls.home,
        component: () => import('../views/LandingPage.vue'),
    },
    {
        path: routeUrls.about,
        component: () => import('../views/AboutPage.vue'),
    },
    {
        path: routeUrls.impressum,
        component: () => import('../views/ImpressumPage.vue'),
    },
    {
        path: routeUrls.rooms,
        component: () => import('../views/RoomsPage.vue'),
    },
    {
        path: routeUrls.roomDetails,
        component: () => import('../views/RoomDetailPage.vue'),
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});

export default router;
