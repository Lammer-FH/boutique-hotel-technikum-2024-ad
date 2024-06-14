<template>
    <form>
        <ion-input
            label="Buchen von:"
            type="date"
            v-model="from"
            required
            class="date-picker"
        ></ion-input>

        <ion-input
            label="Buchen bis:"
            type="date"
            v-model="to"
            required
            class="date-picker"
        ></ion-input>

        <ion-button @click="filter">Suchen</ion-button>
    </form>
</template>

<script lang="ts">
import { IonButton, IonInput } from '@ionic/vue';
import { useRoomStore } from '@/store/roomsStore';

export default {
    components: { IonInput, IonButton },
    data() {
        return {
            roomStorage: useRoomStore(),
            to: new Date().toISOString().split('T')[0],
            from: new Date().toISOString().split('T')[0],
        };
    },
    methods: {
        filter() {
            this.roomStorage.setFilter(this.from, this.to);
            this.$emit('filterRoomItems');
        },
    },
    emit: {
        emits: ['filterRoomItems'],
    },
};
</script>
<style scoped>
form {
    display: flex;
    margin-left: 1rem;
}

.date-picker {
    width: 16rem;
    margin-right: 1.5rem;
}
</style>
