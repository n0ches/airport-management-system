import { Address } from './address';
export class Airport
{
     id:number;
     name:string;
     address:Address;

    public constructor(id:number,name:string,address:Address)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }


}