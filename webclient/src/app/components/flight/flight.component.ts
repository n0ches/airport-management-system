import { Component, OnInit, ViewChild } from '@angular/core';
import { DxDataGridComponent, DxPopupComponent, DxDropDownBoxComponent } from 'devextreme-angular';
import DataSource from 'devextreme/data/data_source';
import { FlightService } from 'src/app/services/flight.service';
import { Flight } from 'src/app/models/flight';
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from 'src/app/models/airport';
import { AirportService } from 'src/app/services/airport.service';
import { Plane } from 'src/app/models/plane';
import { PlaneService } from 'src/app/services/plane.service';

@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent implements OnInit {
  @ViewChild('dataGrid', { static: false }) dataGrid: DxDataGridComponent;
  @ViewChild('addingPopUp', {static: false}) addingPopUp: DxPopupComponent;
  @ViewChild('sourceAirportDropDownBox', {static: false}) sourceAirportDropDownBox: DxDropDownBoxComponent;
  @ViewChild('destinationAirportDropDownBox', {static: false}) destinationAirportDropDownBox: DxDropDownBoxComponent;


  flightDataSource:Flight[];
  airports :Airport[];
  planes:Plane[];

  constructor(private flightService:FlightService, private airportService:AirportService,
    private planeService:PlaneService, private router: Router) { }

  async ngOnInit() {
    this.flightDataSource = await this.flightService.getFlights();
    this.airports = await this.airportService.getAirports();
    this.planes = await this.planeService.getPlanes();
  }

  updateRow(event)
  {
    this.router.navigate(["flight",event.data.id])
  }

  onEditorPreparing(e) 
  {
    e.editorOptions.showClearButton = true;
  }

  showDeletePopup(event,data) {
    data.component.deleteRow(data.rowIndex);
    this.dataGrid.instance.cancelEditData();
  }

  /**
     * Seçim kutusuna seçilen değeri set eder
     * @param args
     * @param setValueMethod
     */
    public dropDownValueChanged(args, setValueMethod) {
      setValueMethod(args.value);
  }

  /**
     * DropDown değişimini tutar ve değişen değeri ilgili sahaya set eder
     * @param event
     * @param dropDownBoxInstance
     */
    public dropDownSelectionChanged(event, dropDownBoxInstance) {
      const keys = event.selectedRowKeys;
      dropDownBoxInstance.option('value', keys.length > 0 ? keys[0] : null);
      dropDownBoxInstance.close();
  }

  public displayExpr(item) {
    return item.name;
}
public displayExprPlane(item) {
  return item.code;
}

}
