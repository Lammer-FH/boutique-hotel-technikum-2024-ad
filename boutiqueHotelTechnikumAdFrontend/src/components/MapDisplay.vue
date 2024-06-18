<template>
    <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2657.303590164777!2d16.37474917614777!3d48.23928307125493!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x476d064f6ed971cf%3A0x99fec738bbb12f9d!2sTechnikum%20Wien!5e0!3m2!1sde!2sat!4v1718728293124!5m2!1sde!2sat"
        class="map"
        style="border: 0"
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
    ></iframe>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({
    components: {},
    data() {
        return {};
    },
});
</script>
<style scoped>
.map {
    width: 100%;
    height: 18.75rem;
}

@media only screen and (min-width: 600px) {
    .map {
        width: 50%;
        height: 37.5rem;
    }
}
</style>
