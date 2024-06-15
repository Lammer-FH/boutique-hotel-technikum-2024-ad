export class Reservation {
    constructor(
        public id: number | null = null,
        public firstName: string = '',
        public lastName: string = '',
        public eMail: string = '',
        public breakfast: boolean = false,
        public from: Date = new Date(),
        public to: Date = new Date()
    ) {}
}
