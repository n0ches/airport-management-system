import { Flight } from './flight';
import { FlightCompany } from './flightcompany';
import { Seat } from './seat';

export class Plane
{
    code:string;
    baggageCapacity:number;
    seatNumber:number;
    flightHistory:Flight[];
    nextFlights:Flight[];
    flightCompany:FlightCompany;
    seats:Seat[];



}