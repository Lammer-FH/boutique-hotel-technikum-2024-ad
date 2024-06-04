<template>
	<swiper
		:modules="modules"
		:centeredSlides="true"
		navigation
		:pagination="{ clickable: true }"
		:scrollbar="{ draggable: true }"
	>
		<swiper-slide v-for="img in imgs" :key="img">
			<img :src="'imgs/' + img" />
		</swiper-slide>
	</swiper>

	<!-- <div>
		<div class="row" v-for="(group, i) in imgGroups" :key="group">
			<div
				v-for="img in imgs.slice(i * 4, (i + 1) * 4)"
				class="column"
				:key="img"
			>
				<img :src="'imgs/' + img" style="width: 100%" />
			</div>
		</div>
	</div> -->
</template>

<!-- ../../public/img -->

<script setup lang="ts">
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Navigation, Pagination, Scrollbar, A11y } from 'swiper/modules';

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
