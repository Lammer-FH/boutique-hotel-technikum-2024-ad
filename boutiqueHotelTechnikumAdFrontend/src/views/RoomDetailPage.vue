<template>
  <PageTemplate>
    <template #menuTitle>
      Raum - {{ selectedRoom.title }}
    </template>
    <template #title>
      Raum - {{ selectedRoom.title }}
    </template>
    <h1>Raum - {{ selectedRoom.title }}</h1>
    <ImageDisplay :path="selectedRoom.imagePath"></ImageDisplay>
    <ExtrasDisplay :extras="selectedRoom.extras"></ExtrasDisplay>
    <p>
      {{ selectedRoom.description }}
    </p>
    <p>{{ selectedRoom.price }} € per Person</p>
  </PageTemplate>
</template>

<script lang="ts">
import ExtrasDisplay from '@/components/ExtrasDisplay.vue';
import ImageDisplay from '@/components/ImageDisplay.vue';
import PageTemplate from '@/components/PageTemplate.vue';
import { useRoomStore } from '@/store/roomsStore';

export default {
  components: {ImageDisplay, ExtrasDisplay, PageTemplate },
  data: () => {
    const roomStore = useRoomStore()
    return {
      roomStore,
      selectedRoom: roomStore.selectedRoom
    }
  },
}
</script>

<style scoped></style>
