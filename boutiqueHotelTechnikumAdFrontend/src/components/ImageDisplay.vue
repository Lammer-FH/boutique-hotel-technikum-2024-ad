<template>
  <ion-img alt="" :src="'/imgs/' + path"/>
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
  },
}
</script>
<style scoped></style>