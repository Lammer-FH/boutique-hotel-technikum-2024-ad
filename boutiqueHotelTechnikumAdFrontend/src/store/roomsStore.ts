import {defineStore} from 'pinia'
import axios from 'axios';
import {Room} from "@/model/room";

const apiUrl = "http://localhost:8081/api";

export const useRoomStore = defineStore('room', {
    state: () => {
        return {
            rooms: [
                {
                    id: 1,
                    title: "Test Room 1",
                    imagePath: '/imgs/reception-1.jpg',
                    description: 'LASLDOAOLSD SLOAOLSAD LOALO SAOL LDOA',
                    price: 20.0,
                    extras: ['Bathroom', 'Windows']
                },
                {
                    id: 2,
                    title: "Test Room 2",
                    imagePath: '/imgs/reception-1.jpg',
                    description: 'LASLDOAOLSD SLOAOLSAD LOALO SAOL LDOA',
                    price: 20.0,
                    extras: ['Bathroom', 'Windows']
                },
                {
                    id: 3,
                    title: "Test Room 3",
                    imagePath: '/imgs/reception-1.jpg',
                    description: 'LASLDOAOLSD SLOAOLSAD LOALO SAOL LDOA',
                    price: 20.0,
                    extras: ['Bathroom', 'Windows']
                }
            ],
            selectedRoom: Room.prototype,
        }
    },
    actions: {
        getRooms(from = "", to = "") {
            if (apiUrl !== undefined) {
                if (from === "") {
                    from = "1000-01-01";
                }
                if (to === "") {
                    to = "3000-12-31";
                }
                axios.get<Room[]>(apiUrl + "/rooms?from=" + from + "&to=" + to, {
                    headers: {
                        'Content-Type': 'application/json',
                    }
                })
                    .then(response => {
                        this.rooms = response.data;
                        console.log(response);
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
        },
        selectRoom(room: Room) {
            this.selectedRoom = room;
        }
    },
})