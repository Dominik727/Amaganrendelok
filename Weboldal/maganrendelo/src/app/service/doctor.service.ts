import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from '../model/doctor';
import { LoginAttributes } from '../model/LoginAttributes';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
 
  private doctorsUrl: string;
  private doctorUrl: string;
 
  constructor(private http: HttpClient) {
    this.doctorsUrl = 'http://maganrendelo.herokuapp.com/admin/doctors';
    this.doctorUrl = 'http://maganrendelo.herokuapp.com/doctorlogin'
  }
 
  public findAll(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(this.doctorsUrl);
  }
 
  public save(doctor: Doctor) {
    return this.http.post<Doctor>(this.doctorsUrl, doctor);
  }

  public CheckMatch(loginAttr: LoginAttributes){
    return this.http.post<Doctor>(this.doctorUrl, loginAttr);
  }
}
