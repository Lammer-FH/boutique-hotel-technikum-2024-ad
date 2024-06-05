<template>
	<swiper
		:modules="modules"
		:centeredSlides="true"
		navigation
		:pagination="{ clickable: true }"
		:scrollbar="{ draggable: true }"
	>
		<swiper-slide v-for="img in imgs" :key="img">
			<ImageDisplay :path="img"></ImageDisplay>
		</swiper-slide>
	</swiper>
</template>

<script setup lang="ts">
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Navigation, Pagination, Scrollbar, A11y } from 'swiper/modules';
import ImageDisplay from '@/components/ImageDisplay.vue'

import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';

interface Props {
	imgs: string[];
}

defineProps<Props>();

const modules = [Navigation, Pagination, Scrollbar, A11y];
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
.swiper {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;

	/* Center slide text vertically */
	display: flex;
	justify-content: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.swiper-slide {
	width: 60%;
}

.swiper-slide:nth-child(2n) {
	width: 40%;
}

.swiper-slide:nth-child(3n) {
	width: 20%;
}
</style>
