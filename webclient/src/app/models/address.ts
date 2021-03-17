export class Address
{
    private country:string;
    private city:string;
    private town:string;

    public constructor(country:string,city:string,town:string)
    {
        this.country = country;
        this.city = city;
        this.town = town;
    }

    
    public get getCountry(): string {
        return this.country;
    }

    public set setCountry(value: string) {
        this.country = value;
    }

    public get getCity(): string {
        return this.city;
    }
    
    public set setCity(value: string) {
        this.city = value;
    }

    public get getTown(): string {
        return this.town;
    }
    
    public set setT123123123own(value: string) {
        this.town = value;
    }
}


