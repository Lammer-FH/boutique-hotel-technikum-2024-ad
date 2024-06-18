import { defineStore } from 'pinia';
import axios from 'axios';
import { Room } from '@/model/room';
import { ReservationResult } from '@/model/reservationResult';
import { Reservation } from '@/model/reservation';
import { ReservationConfirmation } from '@/model/reservationConfirmation';

const apiUrl = 'http://localhost:8081/api';

export const useRoomStore = defineStore('room', {
    state: () => {
        return {
            rooms: [] as Room[],
            selectedRoom: Room.prototype,
            reservation: ReservationConfirmation.prototype,
            filter: { to: new Date(), from: new Date() },
        };
    },
    actions: {
        async getRooms(from: Date = new Date(), to: Date = new Date()) {
            if (apiUrl !== undefined) {
                return axios
                    .get<Room[]>(
                        apiUrl +
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
            if (apiUrl !== undefined) {
                return axios
                    .post<ReservationResult>(
                        apiUrl + '/reservation/' + room.id,
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
        async getReservationConfirmation(reservationId: string) {
            if (apiUrl !== undefined) {
                return axios
                    .get<ReservationConfirmation>(
                        apiUrl + '/reservation/confirmation/' + reservationId,
                        {
                            headers: {
                                'Content-Type': 'application/json',
                            },
                        }
                    )
                    .then((response) => {
                        this.reservation = response.data;
                    });
            }
        },
    },
});
