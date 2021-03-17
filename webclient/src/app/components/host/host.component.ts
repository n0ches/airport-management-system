import { Component, OnInit, ViewChild } from '@angular/core';
import { DxDataGridComponent, DxPopupComponent, DxDropDownBoxComponent } from 'devextreme-angular';
import DataSource from 'devextreme/data/data_source';
import { Host } from 'src/app/models/host';
import { HostService } from 'src/app/services/host.service';
import { FlightcompanyService } from 'src/app/services/flightcompany.service';
import { FlightCompany } from 'src/app/models/flightcompany';

@Component({
  selector: 'app-host',
  templateUrl: './host.component.html',
  styleUrls: ['./host.component.css']
})
export class HostComponent implements OnInit {
  @ViewChild('dataGrid', { static: false }) dataGrid: DxDataGridComponent;
  @ViewChild('addingPopUp', {static: false}) addingPopUp: DxPopupComponent;
  @ViewChild('flightCompanyDropDownBox', {static: false}) flightCompanyDropDownBox: DxDropDownBoxComponent;


  hostDataSource:Host[];
  flightCompanies: FlightCompany[];
  genders = ["male","female"];
  
  constructor(private hostService: HostService, private flightCompanyService:FlightcompanyService) { }

  async ngOnInit() {
    this.hostDataSource = await this.hostService.getHosts();
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
    data.component.deleteRow(data.rowIndex);
    console.log(data.data)
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
 

}
