import { Injectable } from '@angular/core';
import { Airport } from '../models/airport';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { FilePath } from '../models/filepath';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private path: string;

  constructor(private http: HttpClient) 
  {
    this.path = FilePath.getPath + "Airport";
  }

  public getAirports(): Promise<any| Error>{
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

  addAirport(airport:Airport):Observable<Airport>
  {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    return this.http.post<Airport>(this.path,airport,httpOptions);
  }

}
