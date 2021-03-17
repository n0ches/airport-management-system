export class Date
{
    private year:number;
    private month:number;
    private day:number;
    private hour:number;
    private minute:number;

    public constructor(year:number,month:number,day:number,hour?:number,minute?:number)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    };

    public get getYear(): number {
        return this.year;
    }

    public set setYear(value: number) {
        this.year = value;
    }

    public get getMonth(): number {
        return this.month;
    }

    public set setMonth(value: number) {
        this.month = value;
    }

    public get getDay(): number {
        return this.day;
    }

    public set setDay(value: number) {
        this.day = value;
    }

    public get getHour(): number {
        return this.hour;
    }

    public set setHour(value: number) {
        this.hour = value;
    }

    public get getMinute(): number {
        return this.minute;
    }
    public set setMinute(value: number) {
        this.minute = value;
    }
}