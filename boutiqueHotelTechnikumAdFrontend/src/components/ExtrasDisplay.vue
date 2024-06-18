<template>
    <div>
        <ion-badge class="ion-margin" v-for="extra in extras" :key="extra">
            <ion-icon size="large" :name="getIconName(extra.name)">{{
                extra
            }}</ion-icon>
        </ion-badge>
    </div>
</template>

<script lang="ts">
import { IonBadge, IonIcon } from '@ionic/vue';

export default {
    components: { IonIcon, IonBadge },
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
