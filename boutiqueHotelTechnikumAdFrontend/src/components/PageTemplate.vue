<template>
	<ion-page>
		<ion-header :translucent="true">
			<ion-toolbar>
				<ion-buttons slot="start">
					<ion-menu-button color="primary"></ion-menu-button>
				</ion-buttons>
				<ion-title>
					<slot name="menuTitle"></slot>
				</ion-title>
			</ion-toolbar>
		</ion-header>
		<ion-header collapse="condense">
			<ion-toolbar>
				<ion-title size="large">
					<slot name="title"></slot>
				</ion-title>
			</ion-toolbar>
		</ion-header>
		<ion-content :fullscreen="true" class="ion-padding">
			<slot></slot>
		</ion-content>
	</ion-page>
</template>

<script setup lang="ts">
import {
	IonButtons,
	IonContent,
	IonHeader,
	IonMenuButton,
	IonPage,
	IonTitle,
	IonToolbar,
} from '@ionic/vue';
</script>

<script lang="ts">
export default {

};
</script>
