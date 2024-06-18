<template>
    <ion-badge class="badge" v-for="extra in extras" :key="extra">
        <ion-icon size="large" :name="getIconName(extra.name)">{{
            extra
        }}</ion-icon>
    </ion-badge>
</template>

<script lang="ts">
import { IonIcon } from '@ionic/vue';

export default {
    components: { IonIcon },
    props: {
        extras: {
            type: Array,
            required: true,
        },
    },
    methods: {
        getIconName(name: string) {
            switch (name) {
                case 'AIR_CONDITIONING':
                    return 'snow-outline';
                case 'FREE_WIFI':
                    return 'wifi-outline';
                case 'BALCONY':
                    return 'image-outline';
                case 'FLAT_SCREEN_TV':
                    return 'tv-outline';
                default:
                    return 'add-circle-outline';
            }
        },
    },
};
</script>

<style scoped>
.badge {
    margin-right: 1rem;
}

@media only screen and (min-width: 600px) {
    .badge {
        margin-top: 1.5rem;
    }
}
</style>
