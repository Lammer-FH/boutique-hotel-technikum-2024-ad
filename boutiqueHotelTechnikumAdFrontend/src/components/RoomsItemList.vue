<template>
  <ion-list>
    <RoomsItem v-for="room in roomsPage" :key="room.id"
               @clickDetail="() => { $emit('navigateToDetail', room); }" :room="room"/>
  </ion-list>
  <ion-toolbar v-if="pageAmount > 0">
    <ion-buttons slot="start">
      <ion-button @click="previousPage">Previous</ion-button>
    </ion-buttons>
    <ion-title>Seite {{ pageDisplay }} von {{ pageAmount }}</ion-title>
    <ion-buttons slot="end">
      <ion-button @click="nextPage">Next</ion-button>
    </ion-buttons>
  </ion-toolbar>
</template>

<script lang="ts">
import {Room} from '@/model/room';
import {IonButton, IonButtons, IonList, IonTitle, IonToolbar} from '@ionic/vue';
import RoomsItem from "@/components/RoomsItem.vue";

export default {
  components: {RoomsItem, IonList, IonToolbar, IonButtons, IonButton, IonTitle },
  data() {
    return {
      pageIndex: 0,
      itemsPerPage: 5,
    }
  },
  props: {
    rooms: {
      type: Array<Room>,
      required: true
    },
  },
  emits: ['navigateToDetail'],
  computed: {
    roomsPage(): Room[] {
      return this.rooms.slice(this.pageIndex * this.itemsPerPage, this.pageIndex * this.itemsPerPage + this.itemsPerPage);
    },
    pageAmount(): number {
      return Math.ceil(this.rooms.length / this.itemsPerPage);
    },
    pageDisplay(): number {
      return this.pageIndex + 1;
    },
  },
  methods: {
    nextPage() {
      if (this.pageIndex < this.pageAmount - 1) {
        this.pageIndex++;
      }
    },
    previousPage() {
      if (this.pageIndex > 0) {
        this.pageIndex--;
      }
    }
  }
}
</script>
<style scoped></style>