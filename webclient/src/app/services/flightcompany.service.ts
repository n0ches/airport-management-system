import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilePath } from '../models/filepath';
import { Observable, of } from 'rxjs';
import { FlightCompany } from '../models/flightcompany';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FlightcompanyService {

  private path: string;

  constructor(private http: HttpClient) 
  {
    this.path = FilePath.getPath + "FlightCompany";
  }


  public getFlightCompanies(): Promise<any| Error>{
    const url = this.path;
    return this.http.get(url).pipe(
      first(),
      catchError((error:any) => of(error)),
      map((response : any) => {
        if (response) {
          return response;
        }
      })
    ).toPromise();
  }

  

  addFlightCompany(flightcompany:FlightCompany):Observable<FlightCompany>
  {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    return this.http.post<FlightCompany>(this.path,flightcompany,httpOptions);
  }
}
