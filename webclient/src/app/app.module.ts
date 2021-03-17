import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app/app.component';
import { PilotService } from './services/pilot.service';
import { PilotComponent } from './components/pilot/pilot.component';
import { HostComponent } from './components/host/host.component';
import { PassengerComponent } from './components/passenger/passenger.component';
import { FlightCompanyComponent } from './components/flight-company/flight-company.component';
import { FlightComponent } from './components/flight/flight.component';
import { DevExtremeModule } from 'devextreme-angular';
import { TicketComponent } from './components/ticket/ticket.component';

@NgModule({
  declarations: [
    AppComponent,
    PilotComponent,
    HostComponent,
    PassengerComponent,
    FlightCompanyComponent,
    FlightComponent,
    TicketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    DevExtremeModule
  ],
  providers: [PilotService],
  bootstrap: [AppComponent]
})
export class AppModule { }
