import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';
import { PatientDto } from '../model/patientdto';

@Injectable()
export class PatientService {
 
  private patientsUrl: string;
  private regUrl: string;
 
  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://maganrendelo.herokuapp.com/admin/patients';
    this.regUrl = 'http://maganrendelo.herokuapp.com/registration'
  }
 
  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }
 
  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }

  public newPatient(patient: PatientDto) {
    return this.http.post<PatientDto>(this.regUrl, patient);
  }
}