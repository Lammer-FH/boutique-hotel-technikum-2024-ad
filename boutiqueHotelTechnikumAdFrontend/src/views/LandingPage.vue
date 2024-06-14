<template>
    <PageTemplate :use-back-button="true">
        <template #menuTitle> Home </template>
        <template #title> Welcome </template>
        <h1>Welcome to Boutique Hotel Technikum</h1>

        <PhotoGallery :imgs="imgs" />

        <h2>Discover Vienna’s Hidden Gem</h2>
        <p>
            At Boutique Hotel Technikum, we invite you to experience the perfect
            blend of elegance, comfort, and personalized service. Nestled in the
            heart of Vienna, our 4-star hotel offers a unique stay that combines
            modern amenities with Viennese charm.
        </p>
        <h2>Location: Unbeatable Convenience</h2>
        <p>
            Situated in the vibrant district of Vienna, our hotel is just a
            stone’s throw away from the city’s iconic landmarks. Whether you’re
            here for business or leisure, our central location ensures easy
            access to:
        </p>
        <ul>
            <li>
                <strong>St. Stephen’s Cathedral:</strong> Step outside our
                doors, and you’ll find yourself facing the magnificent St.
                Stephen’s Cathedral. Explore its Gothic architecture and climb
                the tower for panoramic views of Vienna.
            </li>
            <li>
                <strong>City Center Sights:</strong> Vienna’s major attractions,
                including the Hofburg Palace, Belvedere Palace, and the Vienna
                State Opera, are minutes away. Immerse yourself in history, art,
                and culture.
            </li>
            <li>
                <strong>Shopping Delight:</strong> Wander through charming
                streets and discover boutique shops, high-end fashion, and local
                markets. Mariahilfer Straße, Vienna’s premier shopping street,
                is within walking distance.
            </li>
            <li>
                <strong>Efficient Transportation:</strong> Our hotel is
                conveniently located near public transportation hubs, making it
                easy to explore the city. Hop on a tram, bus, or subway right
                from our doorstep.
            </li>
        </ul>
        <h2>Your Home Away from Home</h2>
        <ul>
            <li>
                <strong>Elegantly Appointed Rooms:</strong> Our spacious rooms
                feature contemporary design, plush bedding, and modern
                amenities. Unwind after a day of exploration and enjoy a restful
                night’s sleep.
            </li>
            <li>
                <strong>Relaxation at the Spa:</strong> Treat yourself to our
                little oasis—the hotel’s spa. Rejuvenate with a soothing massage
                or unwind in the sauna. You deserve it!
            </li>
            <li>
                <strong>Café Giacomo Aragall:</strong> Sip a cup of Viennese
                coffee or indulge in a slice of cake at our cozy café. The
                perfect spot to people-watch and soak in the city’s energy.
            </li>
        </ul>
        <h2>Book Your Stay Today</h2>
        <p>
            Whether you’re here for business, a romantic getaway, or a family
            vacation, Boutique Hotel Technikum promises an unforgettable
            experience. We look forward to welcoming you soon!
        </p>
    </PageTemplate>
</template>

<script setup lang="ts">
import PhotoGallery from '../components/PhotoGallery.vue';
import PageTemplate from '@/components/PageTemplate.vue';
</script>

<script lang="ts">
export default {
    data() {
        return {
            imgs: [
                'hotel-outside.jpg',
                'reception-1.jpg',
                'reception-2.jpg',
                'spa-area.jpg',
            ],
        };
    },
};
</script>
