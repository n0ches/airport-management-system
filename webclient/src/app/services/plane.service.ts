import { Injectable } from '@angular/core';
import { Plane } from '../models/plane';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilePath } from '../models/filepath';
import { Observable, of } from 'rxjs';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PlaneService {

  private path: string;
  private planes: Plane[];
  
  constructor(private http:HttpClient) 
  {
      this.path=FilePath.getPath + "Plane";
  }

  public getPlanes(): Promise<any| Error>{
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

  addPlane(plane:Plane):Observable<Plane>
  {
      const httpOptions = {
        headers: new HttpHeaders({
        'Content-Type': 'application/json'
       })
    }
    return this.http.post<Plane>(this.path,plane,httpOptions);
  }
}
