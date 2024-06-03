<template>
	<div>
		<div class="row" v-for="(group, i) in imgGroups" :key="group">
			<div
				v-for="img in imgs.slice(i * 4, (i + 1) * 4)"
				class="column"
				:key="img"
			>
				<img :src="'imgs/' + img" style="width: 100%" />
			</div>
		</div>
	</div>
</template>

<!-- ../../public/img -->

<script setup lang="ts">
interface Props {
	imgs: string[];
}

defineProps<Props>();
</script>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
	name: 'PhotoGallery',
	computed: {
		imgGroups(): number[] {
			return Array.from(Array(Math.ceil(this.imgs.length / 4)).keys());
		},
	},
});
</script>

<style lang="scss" scoped>
* {
	box-sizing: border-box;
}

.header {
	text-align: center;
	padding: 32px;
}

.row {
	display: -ms-flexbox; /* IE10 */
	display: flex;
	-ms-flex-wrap: wrap; /* IE10 */
	flex-wrap: wrap;
	padding: 0 4px;
}

/* Create four equal columns that sits next to each other */
.column {
	-ms-flex: 25%; /* IE10 */
	flex: 25%;
	max-width: 25%;
	padding: 0 4px;
}

.column img {
	margin-top: 8px;
	vertical-align: middle;
	width: 100%;
}

/* Responsive layout - makes a two column-layout instead of four columns */
@media screen and (max-width: 800px) {
	.column {
		-ms-flex: 50%;
		flex: 50%;
		max-width: 50%;
	}
}

/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.column {
		-ms-flex: 100%;
		flex: 100%;
		max-width: 100%;
	}
}
</style>
