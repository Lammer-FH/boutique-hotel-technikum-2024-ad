import {defineStore} from 'pinia'
import axios from 'axios';
import {Room} from "@/model/room";

const apiUrl = "http://localhost:8081/api";

export const useRoomStore = defineStore('room', {
    state: () => {
        return {
            rooms: [] as Room[],
            selectedRoom: Room.prototype,
        }
    },
    actions: {
        async getRooms(from = "", to = "") {
            if (apiUrl !== undefined) {
                if (from === "") {
                    from = "1000-01-01";
                }
                if (to === "") {
                    to = "3000-12-31";
                }
                return axios.get<Room[]>(apiUrl + "/rooms?from=" + from + "&to=" + to, {
                    headers: {
                        'Content-Type': 'application/json',
                    }
                })
                .then(response => {
                    this.rooms = response.data;
                });
            }
        },
        selectRoom(room: Room) {
            this.selectedRoom = room;
        }
    },
})