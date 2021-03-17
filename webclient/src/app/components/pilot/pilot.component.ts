import { Component, OnInit, ViewChild } from '@angular/core';
import { Pilot } from 'src/app/models/pilot';
import { Date } from 'src/app/models/date';
import DataSource from 'devextreme/data/data_source';
import { PilotService } from 'src/app/services/pilot.service';
import dxDataGrid from 'devextreme/ui/data_grid';
import { DxDataGridComponent, DxPopupComponent, DxDropDownBoxComponent } from 'devextreme-angular';
import { FlightCompany } from 'src/app/models/flightcompany';
import { FlightcompanyService } from 'src/app/services/flightcompany.service';


@Component({
  selector: 'app-pilot',
  templateUrl: './pilot.component.html',
  styleUrls: ['./pilot.component.css']
})
export class PilotComponent implements OnInit {
  @ViewChild('dataGrid', { static: false }) dataGrid: DxDataGridComponent;
  @ViewChild('addingPopUp', {static: false}) addingPopUp: DxPopupComponent;
  @ViewChild('flightCompanyDropDownBox', {static: false}) flightCompanyDropDownBox: DxDropDownBoxComponent;


  pilotDataSource:Pilot[];
  flightCompanies: FlightCompany[];
  private pilot :Pilot;
  ranks = ["first-pilot","co-pilot"];
  genders = ["male","female"];

  

  constructor(private pilotService: PilotService, private flightCompanyService:FlightcompanyService) { }

  async ngOnInit() {
    this.pilotDataSource = await this.pilotService.getPilots();
    this.flightCompanies = await this.flightCompanyService.getFlightCompanies();
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
    this.dataGrid.instance.cancelEditData();
    data.component.deleteRow(data.rowIndex);
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
 

}
