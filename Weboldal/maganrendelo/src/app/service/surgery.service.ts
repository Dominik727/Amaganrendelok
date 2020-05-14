import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Surgery } from '../model/surgery';
import { catchError, map, tap } from 'rxjs/operators';
import { MyComment } from '../model/Comment';

@Injectable({
  providedIn: 'root'
})
export class SurgeryService {

  private surgeriesUrl: string;
  private surgeryUrl: string;
  private adminsurgeryUrl: string;

  constructor(private http: HttpClient) {
    this.surgeriesUrl = 'http://maganrendelo.herokuapp.com/admin/surgeries';
    this.surgeryUrl = 'http://maganrendelo.herokuapp.com/surgery';
    this.adminsurgeryUrl = 'http://maganrendelo.herokuapp.com/admin/surgery';
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

  updateSurgery(surgery: Surgery): Observable<any> {
    const url = `${this.adminsurgeryUrl}/${surgery.id}/edit`;
    return this.http.post(url, surgery, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateSurgery'))
    );
  }

  deleteSurgery(surgery: Surgery | number): Observable<Surgery> {
    const id = typeof surgery === 'number' ? surgery : surgery.id;
    const url = `${this.adminsurgeryUrl}/${id}`;

    return this.http.delete<Surgery>(url, this.httpOptions).pipe(
      catchError(this.handleError<Surgery>('deleteSurgery'))
    );
  }

  getComments(id: number): Observable<Comment[]> {
    const url = `${this.surgeryUrl}/${id}/comments`;
    return this.http.get<Comment[]>(url).pipe(
      catchError(this.handleError<Comment[]>(`getSurgeryComments id=${id}`))
    );
  }

  postComment(id: number, comment: MyComment): Observable<any> {
    const url = `${this.surgeryUrl}/${id}/comments`;
    return this.http.post(url, comment, this.httpOptions).pipe(
      catchError(this.handleError<any>('updateSurgeryComment'))
    );
  }

  searchSurgeries(term: string): Observable<Surgery[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<Surgery[]>(`${this.surgeriesUrl}/?name=${term}`)
    .pipe(
      catchError(this.handleError<Surgery[]>('searchSurgeries', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };
  }



}
