import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PilotComponent } from './components/pilot/pilot.component';
import { HostComponent } from './components/host/host.component';
import { PassengerComponent } from './components/passenger/passenger.component';
import { FlightComponent } from './components/flight/flight.component';
import { FlightCompanyComponent } from './components/flight-company/flight-company.component';
import { TicketComponent } from './components/ticket/ticket.component';


const routes: Routes = [
  {path:'pilot',component:PilotComponent},
  {path:'host',component:HostComponent},
  {path:'passenger',component:PassengerComponent},
  {path:'flight',component:FlightComponent},
  {path:'flight/:id',component:TicketComponent},
  {path:'flight-company',component:FlightCompanyComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
