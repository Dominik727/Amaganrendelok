import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Surgery } from '../model/surgery';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SurgeryService {
 
  private surgeriesUrl: string;
  private surgeryUrl: string;
 
  constructor(private http: HttpClient) {
    this.surgeriesUrl = 'http://maganrendelo.herokuapp.com/admin/surgeries';
    this.surgeryUrl = 'http://maganrendelo.herokuapp.com/surgery';
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
 
  public findAll(): Observable<Surgery[]> {
    return this.http.get<Surgery[]>(this.surgeriesUrl);
  }
 
  public save(surgery: Surgery) {
    return this.http.post<Surgery>(this.surgeriesUrl, surgery);
  }

  getSurgery(id: number): Observable<Surgery> {
    const url = `${this.surgeryUrl}/${id}`;
    return this.http.get<Surgery>(url).pipe(
      catchError(this.handleError<Surgery>(`getSurgery id=${id}`))
    );
  }

  updateSurgery (surgery: Surgery): Observable<any> {
    return this.http.put(this.surgeriesUrl, surgery, this.httpOptions).pipe(
      catchError(this.handleError<any>('updatePainting'))
    );
  }

  deleteSurgery (surgery: Surgery | number): Observable<Surgery> {
    const id = typeof surgery === 'number' ? surgery : surgery.id;
    const url = `${this.surgeriesUrl}/${id}`;
  
    return this.http.delete<Surgery>(url, this.httpOptions).pipe(
      catchError(this.handleError<Surgery>('deleteSurgery'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };
  }


  
}
