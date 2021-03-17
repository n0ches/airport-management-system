import { Component, OnInit, ViewChild } from '@angular/core';
import { DxDataGridComponent, DxPopupComponent } from 'devextreme-angular';
import DataSource from 'devextreme/data/data_source';
import { Passenger } from 'src/app/models/passenger';
import { PassengerService } from 'src/app/services/passenger.service';

@Component({
  selector: 'app-passenger',
  templateUrl: './passenger.component.html',
  styleUrls: ['./passenger.component.css']
})
export class PassengerComponent implements OnInit {
  @ViewChild('dataGrid', { static: false }) dataGrid: DxDataGridComponent;
  @ViewChild('addingPopUp', {static: false}) addingPopUp: DxPopupComponent;

  passengerDataSource:Passenger[];
  genders = ["male","female"];

  constructor(private passengerService:PassengerService) { }

  async ngOnInit() {
    this.passengerDataSource = await this.passengerService.getPassengers();
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
