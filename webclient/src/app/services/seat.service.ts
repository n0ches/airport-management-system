import { Injectable } from '@angular/core';
import { Seat } from '../models/seat';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilePath } from '../models/filepath';
import { Observable, of } from 'rxjs';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  private path: string;
  private seats: Seat[];
  
  constructor(private http:HttpClient) 
  {
      this.path=FilePath.getPath + "Seat";
  }

  public getSeats(): Promise<any| Error>{
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

  addSeat(seat:Seat):Observable<Seat>
  {
      const httpOptions = {
        headers: new HttpHeaders({
        'Content-Type': 'application/json'
       })
    }
    return this.http.post<Seat>(this.path,seat,httpOptions);
  }
}
