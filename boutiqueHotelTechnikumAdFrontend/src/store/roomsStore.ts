import { defineStore } from 'pinia';
import axios from 'axios';
import { Room } from '@/model/room';

const apiUrl = 'http://localhost:8081/api';

export const useRoomStore = defineStore('room', {
    state: () => {
        return {
            rooms: [] as Room[],
            selectedRoom: Room.prototype,
            filter: { to: new Date(), from: new Date() },
        };
    },
    actions: {
        async getRooms(
            from: Date = new Date(1000, 1, 1),
            to: Date = new Date(3000, 12, 31)
        ) {
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
    },
});
