<template>
  <ion-img class="image-display" :alt="alt" :src="'/imgs/' + path" />
</template>

<script lang="ts">
import { IonImg } from "@ionic/vue";

export default {
  components: { IonImg },
  props: {
    path: {
      type: String,
      required: true,
    },
    alt: {
      type: String,
      default: "",
    },
  },
};
</script>
<style scoped>
.image-display {
  padding: 1em;
}
</style>
