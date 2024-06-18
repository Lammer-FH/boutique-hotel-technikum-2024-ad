export class Reservation {
    constructor(
        public id: number | null = null,
        public firstName: string = '',
        public lastName: string = '',
        public eMail: string = '',
        public doBreakfast: boolean = false,
        public from: Date = new Date(),
        public to: Date = new Date()
    ) {}

    public fromFormated(): string {
        return this.from.toISOString().split('T')[0];
    }

    public toFormated(): string {
        return this.to.toISOString().split('T')[0];
    }
}
