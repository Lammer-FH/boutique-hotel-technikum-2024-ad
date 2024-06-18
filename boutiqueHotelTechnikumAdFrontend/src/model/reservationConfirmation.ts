export class ReservationConfirmation {
    constructor(
        public from: Date = new Date(),
        public to: Date = new Date(),
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

    public get fromFormated() {
        return this.from.toISOString().split('T')[0];
    }

    public get toFormated() {
        return this.to.toISOString().split('T')[0];
    }
}
