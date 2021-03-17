import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilePath } from '../models/filepath';
import { Flight } from '../models/flight';
import { Observable, of } from 'rxjs';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private path:string;
  
  constructor(private http: HttpClient)
  {
    this.path = FilePath.getPath + "Flight";
  }

  public getFlights(): Promise<any| Error>{
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

  addFlight(flight:Flight):Observable<Flight>
  {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    return this.http.post<Flight>(this.path,flight,httpOptions);
  }
}
