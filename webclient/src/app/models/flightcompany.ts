import { Address } from './address';
import { Plane } from './plane';
import { Pilot } from './pilot';
import { Host } from './host';

export class FlightCompany
{
    private id:number;
    private name:string;
    private address:Address;
    private phone:number;
    private planes:Plane[];
    private pilots:Pilot[];
    private hosts:Host[];

    public constructor(id:number,name:string,address:Address,phone:number){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phone=phone;
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

    public get getAddress(): Address {
        return this.address;
    }
    
    public set setAddress(value: Address) {
        this.address = value;
    }

    public get getPhone(): number {
        return this.phone;
    }
    
    public set setPhone(value: number) {
        this.phone = value;
    }

    public get getPlanes(): Plane[] {
        return this.planes;
    }
    
    public get getPilots(): Pilot[] {
        return this.pilots;
    }
    
    public get getHosts(): Host[] {
        return this.hosts;
    }
    
}