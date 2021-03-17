import { Flight } from './flight';

export class Passenger
{
     id:number;
     name: string;
     surname: string;
     phone: number;
     birthday:Date;
     gender: string;
     weight: number;
     height: number;
     flightHistory: Flight[];
     bagId: number;
     bagWeight:number;


    public constructor(id:number,name:string,surname:string,phone:number,birthday:Date,gender:string,weight:number,
                        height:number,bagId:number,bagWeight:number)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bagId = bagId;
        this.bagWeight = bagWeight;
    }

}