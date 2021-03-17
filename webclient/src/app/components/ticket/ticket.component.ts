import { Component, OnInit,DoCheck,AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Flight } from 'src/app/models/flight';
import { FlightService } from 'src/app/services/flight.service';
import { Seat } from 'src/app/models/seat';
import { Passenger } from 'src/app/models/passenger';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  flights:Flight[];
  seats : Seat[];
  flightId:number;
  chechCount :number;
  popupVisible = false;
  passenger:Passenger;
  genders = ["male","female"];

  public toolbarItemOptions = [];

  constructor(private route: ActivatedRoute, private flightService:FlightService) 
  {
    this.seats = [];
    this.flightId =0;
    this.chechCount = 0;
    this.passenger = new Passenger(null,null,null,null,null,null,null,null,null,null)
  }

  async ngOnInit() {
    this.flights = await this.flightService.getFlights();
    this.flightId = await this.route.snapshot.params.id;
    const length = await this.flights.length
    for(let i =0;i<length;i = i+1)
    {
      if(this.flights[i].id == this.flightId)
      {
        this.seats = this.flights[i].plane.seats
        console.log(this.seats);
      }
    }
  }

  async buyTicket(event)
  {
      if(event.data.status == true)
      {

        this.toolbarItemOptions = [
        {
          widget: 'dxButton',
          location: 'after',
          options: {
              text: 'Save',
          },
          toolbar: 'bottom',
          onClick: () => this.saveTicket(event)
        },
        {
          widget: 'dxButton',
          location: 'after',
          options: {
              text: 'Cancel',
          },
          toolbar: 'bottom',
          onClick: () => this.closePopup()
        }];
        this.popupVisible= true;
      }
      else{
        this.popupVisible = false
      }
    
    //event.component.editRow(event.rowIndex);

  }

  public saveTicket(event)
  {
   event.data.status = false;
   console.log(this.passenger)
   event.data.passenger=this.passenger;
   this.popupVisible = false;  
  }

  public closePopup()
  {
      this.popupVisible = false;
  }



}
