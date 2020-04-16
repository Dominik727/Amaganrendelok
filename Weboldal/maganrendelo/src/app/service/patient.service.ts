import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';

@Injectable()
export class PatientService {
 
  private patientsUrl: string;
 
  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://maganrendelo.herokuapp.com/admin/patients';
  }
 
  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }
 
  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }
}