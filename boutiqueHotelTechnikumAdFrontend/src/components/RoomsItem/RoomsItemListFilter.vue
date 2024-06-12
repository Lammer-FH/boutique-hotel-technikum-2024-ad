<template>
  <form>
    <ion-item>
      <ion-input label="Buchen von:" type="date" v-model="from" required></ion-input>
    </ion-item>
    <ion-item>
      <ion-input label="Buchen bis:" type="date" v-model="to" required></ion-input>
    </ion-item>
    <ion-button @click="filter">Suchen</ion-button>
  </form>
</template>

<script lang="ts">
import {IonButton, IonInput, IonItem} from '@ionic/vue';
import {useRoomStore} from "@/store/roomsStore";

export default {
  components: {IonInput, IonButton, IonItem},
  data() {
    return {
      roomStorage: useRoomStore(),
      to: new Date().toISOString().split('T')[0],
      from: new Date().toISOString().split('T')[0],
    }
  },
  methods: {
    filter() {
      this.roomStorage.setFilter(this.from, this.to);
      this.$emit('filterRoomItems');
    }
  },
  emit: {
    emits: ['filterRoomItems'],
  }
}
</script>
<style scoped></style>