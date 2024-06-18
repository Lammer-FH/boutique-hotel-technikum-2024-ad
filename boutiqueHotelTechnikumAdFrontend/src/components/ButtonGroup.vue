<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'ButtonGroup',
    components: {},
});
</script>

<template>
    <div class="button-group">
        <slot></slot>
    </div>
</template>

<style scoped>
.button-group {
    display: flex;
    width: auto;
    flex-direction: column;
    margin-right: 1rem;
    margin-left: 1rem;
}

@media only screen and (min-width: 600px) {
    .button-group {
        flex-direction: row;
        margin-right: 0;
    }
}
</style>
