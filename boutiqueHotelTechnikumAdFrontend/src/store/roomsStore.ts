import { defineStore } from 'pinia';
import axios from 'axios';
import { Room } from '@/model/room';
import { ReservationResult } from '@/model/reservationResult';
import { Reservation } from '@/model/reservation';

export const useRoomStore = defineStore('room', {
    state: () => {
        return {
            rooms: [] as Room[],
            selectedRoom: Room.prototype,
            filter: { to: new Date(), from: new Date() },
        };
    },
    actions: {
        async getRooms(from: Date = new Date(), to: Date = new Date()) {
            if (import.meta.env.VITE_BACKEND_API_URL !== undefined) {
                return axios
                    .get<Room[]>(
                        import.meta.env.VITE_BACKEND_API_URL +
                            '/rooms?from=' +
                            from.toISOString().split('T')[0] +
                            '&to=' +
                            to.toISOString().split('T')[0],
                        {
                            headers: {
                                'Content-Type': 'application/json',
                            },
                        }
                    )
                    .then((response) => {
                        this.rooms = response.data;
                    });
            }
        },
        selectRoom(room: Room) {
            this.selectedRoom = room;
        },
        setFilter(from: string, to: string) {
            this.filter.to = new Date(to);
            this.filter.from = new Date(from);
        },
        async reserveRoom(room: Room, reservation: Reservation) {
            if (import.meta.env.VITE_BACKEND_API_URL !== undefined) {
                return axios
                    .post<ReservationResult>(
                        import.meta.env.VITE_BACKEND_API_URL +
                            '/reservation/' +
                            room.id,
                        reservation,
                        {
                            headers: {
                                'Content-Type': 'application/json',
                            },
                        }
                    )
                    .then((response) => {
                        reservation.id = response.data.reservationId;
                    });
            }
        },
    },
});
