import { Injectable } from '@angular/core';
import { Passenger } from '../models/passenger';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilePath } from '../models/filepath';
import { Observable, of } from 'rxjs';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  
  private path: string;
  private passengers: Passenger[];
  
  constructor(private http:HttpClient) 
  {
      this.path=FilePath.getPath + "Passenger";
  }

  public getPassengers(): Promise<any| Error>{
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

  addPassenger(passenger:Passenger):Observable<Passenger>
  {
      const httpOptions = {
        headers: new HttpHeaders({
        'Content-Type': 'application/json'
       })
    }
    return this.http.post<Passenger>(this.path,passenger,httpOptions);
  }
}
