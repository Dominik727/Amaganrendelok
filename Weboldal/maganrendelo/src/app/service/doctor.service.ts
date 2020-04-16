import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from '../model/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
 
  private surgeriesUrl: string;
 
  constructor(private http: HttpClient) {
    this.surgeriesUrl = 'http://maganrendelo.herokuapp.com/admin/doctors';
  }
 
  public findAll(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(this.surgeriesUrl);
  }
 
  public save(surgery: Doctor) {
    return this.http.post<Doctor>(this.surgeriesUrl, surgery);
  }
}
