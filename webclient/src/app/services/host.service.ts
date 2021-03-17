import { Injectable } from '@angular/core';
import { Host } from '../models/host';
import { FilePath } from '../models/filepath';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { first, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HostService {

  private path :string;
  private hosts : Host[];

  constructor(private http: HttpClient) 
  {
    this.path = FilePath.getPath  + "Hosts"; 
  }

  public getHosts(): Promise<any| Error>{
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

  addHost(host:Host):Observable<Host>
  {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
       })
    }
    return this.http.post<Host>(this.path,host,httpOptions);
  }
}
