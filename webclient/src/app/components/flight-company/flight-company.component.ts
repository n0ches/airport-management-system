import { Component, OnInit, ViewChild } from '@angular/core';
import { DxDataGridComponent, DxPopupComponent } from 'devextreme-angular';
import DataSource from 'devextreme/data/data_source';
import { FlightcompanyService } from 'src/app/services/flightcompany.service';
import { FlightCompany } from 'src/app/models/flightcompany';

@Component({
  selector: 'app-flight-company',
  templateUrl: './flight-company.component.html',
  styleUrls: ['./flight-company.component.css']
})
export class FlightCompanyComponent implements OnInit {
  @ViewChild('dataGrid', { static: false }) dataGrid: DxDataGridComponent;
  @ViewChild('addingPopUp', {static: false}) addingPopUp: DxPopupComponent;

  flightCompanies: FlightCompany[];
  

  constructor(private flightCompanyService:FlightcompanyService) { }

  async ngOnInit() {
    this.flightCompanies = await this.flightCompanyService.getFlightCompanies();
    console.log(this.flightCompanies)
  }

  updateRow(event)
  {
    event.component.editRow(event.rowIndex);
  }

  onEditorPreparing(e) 
  {
    e.editorOptions.showClearButton = true;
  }

  showDeletePopup(event,data) {
    data.component.deleteRow(data.rowIndex);
    console.log(data.data)
        this.dataGrid.instance.cancelEditData();
  }

}
