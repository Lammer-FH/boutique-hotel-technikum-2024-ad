<template>
  <ion-badge v-for="extra in extras" >{{ extra }}</ion-badge>
</template>

<script lang="ts">
import {IonBadge} from '@ionic/vue';

export default {
  components: { IonBadge },
  props: {
    extras: {
      type: Array,
      required: true
    },
  },
}
</script>
<style scoped></style>