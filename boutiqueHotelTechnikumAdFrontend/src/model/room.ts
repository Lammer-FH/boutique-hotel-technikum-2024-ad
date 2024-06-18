export class Room {
    constructor(
        public id: number,
        public title: string,
        public imagePath: string,
        public description: string,
        public price: number,
        public extras: string[]
    ) {}
}
