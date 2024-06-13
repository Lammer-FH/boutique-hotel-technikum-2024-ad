<template>
  <ion-img :alt="alt" :src="'/imgs/' + path"/>
</template>

<script lang="ts">
import {IonImg} from '@ionic/vue';

export default {
  components: {IonImg},
  props: {
    path: {
      type: String,
      required: true
    },
    alt: {
      type: String,
      default: '',
    }
  },
}
</script>
<style scoped></style>