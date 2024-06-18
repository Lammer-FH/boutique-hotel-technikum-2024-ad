<template>
    <form>
        <ion-input
            label="Book from:"
            type="date"
            v-model="from"
            required
            class="date-picker"
        ></ion-input>

        <ion-input
            label="Book to:"
            type="date"
            v-model="to"
            required
            class="date-picker"
        ></ion-input>

        <ion-button @click="filter">Search</ion-button>
    </form>
</template>

<script lang="ts">
import { useRoomStore } from '@/store/roomsStore';
import { IonButton, IonInput } from '@ionic/vue';
import HelperService from '../../service/HelperService';

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
            if (this.to >= this.from) {
                this.roomStorage.setFilter(this.from, this.to);
                this.$emit('filterRoomItems');
            } else {
                HelperService.showToast(
                    "'Book To' is not allowed to be before 'Book from'!",
                    true,
                    'top'
                );
            }
        },
    },
    emit: {
        emits: ['filterRoomItems'],
    },
};
</script>
<style scoped>
.button {
    width: 100%;
    margin-bottom: 1rem;
}

@media only screen and (min-width: 600px) {
    form {
        display: flex;
        margin-left: 1rem;
    }

    .date-picker {
        width: 16rem;
        margin-right: 1.5rem;
    }

    .button {
        width: auto;
        min-width: 10rem;
        margin-bottom: 0;
    }
}
</style>
