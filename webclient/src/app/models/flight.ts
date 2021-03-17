import { Airport } from './airport';
import { Date } from './date';
import { Plane } from './plane';
import { Pilot } from './pilot';
import { Host } from './host';
import { Passenger } from './passenger';
import { Seat } from './seat';

export class Flight
{
        id:number;
        source:Airport
        destination:Airport;
        departureTime:string;
        arrivalTime:string;
        plane:Plane;
        pilots:Pilot[];
        hosts:Host[];
        passengers:Passenger[];


}