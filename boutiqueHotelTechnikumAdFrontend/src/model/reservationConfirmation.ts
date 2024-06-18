export class ReservationConfirmation {
    constructor(
        public from: string = '',
        public to: string = '',
        public roomTitle: string = '',
        public roomDescription: string = '',
        public imagePath: string = '',
        public roomPrice: number = 0,
        public extras: string[] = [],
        public firstName: string = '',
        public lastName: string = '',
        public eMail: string = '',
        public doBreakfast: boolean = false
    ) {}
}
