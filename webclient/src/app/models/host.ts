import { Flight } from './flight';
import { FlightCompany } from './flightcompany';

export class Host
{
    private id:number;
    private name: string;
    private surname: string;
    private phone: number;
    private birthday:Date;
    private gender: string;
    private weight: number;
    private height: number;
    private flightHistory: Flight[];
    private flightCompany:FlightCompany;
    private workExperience: number;
    private salary: number;
    private nextFlights: Flight[];

    public constructor(id:number,name:string,surname:string,phone:number,birthday:Date,gender:string,weight:number,
                        height:number,flightCompany:FlightCompany,workExperience:number,salary:number)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.flightCompany = flightCompany;
        this.workExperience = workExperience;
        this. salary = salary;
    }

    public addFligtToFlightHistory(flight:Flight)
    {
        this.flightHistory.push(flight);
    }

    public addFlightToNextFlight(flight:Flight)
    {
        this.nextFlights.push(flight);
    }

    public get getId(): number {
        return this.id;
    }

    public set setId(value: number) {
        this.id = value;
    }

    public get getName(): string {
        return this.name;
    }

    public set setName(value: string) {
        this.name = value;
    }

    public get getSurname(): string {
        return this.surname;
    }

    public set setSurname(value: string) {
        this.surname = value;
    }
    public get getPhone(): number {
        return this.phone;
    }
    
    public set setPhone(value: number) {
        this.phone = value;
    }

    public get getBirthday(): Date {
        return this.birthday;
    }

    public set setBirthday(value: Date) {
        this.birthday = value;
    }

    public get getGender(): string {
        return this.gender;
    }

    public set setGender(value: string) {
        this.gender = value;
    }

    public get getWeight(): number {
        return this.weight;
    }

    public set setWeight(value: number) {
        this.weight = value;
    }

    public get getHeight(): number {
        return this.height;
    }

    public set setHeight(value: number) {
        this.height = value;
    }

    public get getFlightHistory(): Flight[] {
        return this.flightHistory;
    }

    public get getFlightCompany(): FlightCompany {
        return this.flightCompany;
    }

    public set setFlightCompany(value: FlightCompany) {
        this.flightCompany = value;
    }

    public get getWorkExperience(): number {
        return this.workExperience;
    }

    public set setWorkExperience(value: number) {
        this.workExperience = value;
    }

    public get getSalary(): number {
        return this.salary;
    }

    public set setSalary(value: number) {
        this.salary = value;
    }

    public get getNextFlights(): Flight[] {
        return this.nextFlights;
    }
}