import { Injectable } from '@angular/core';
import { Pilot } from '../models/pilot';
import { FilePath } from '../models/filepath';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { first, catchError, map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class PilotService {

  private path :string;

  constructor(private http: HttpClient) 
  {
    this.path = FilePath.getPath + "Pilots"; 
  }

  public getPilots(): Promise<any| Error>{
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

  // getPilots():Observable<Pilot[]>
  // {
  //   return this.http.get<Pilot[]>(this.path);
  // }

  addPilot(pilot:Pilot):Observable<Pilot>
  {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
       })
    }
    return this.http.post<Pilot>(this.path,pilot,httpOptions);
  }

}
