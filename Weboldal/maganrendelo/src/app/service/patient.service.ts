import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';
import { PatientDto } from '../model/patientdto';

@Injectable()
export class PatientService {
 
  private patientsUrl: string;
  private regUrl: string;
  private doctorPatientsUrl: string;
 
  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://maganrendelo.herokuapp.com/admin/patients';
    this.regUrl = 'http://maganrendelo.herokuapp.com/registration';
    this.doctorPatientsUrl = 'http://maganrendelo.herokuapp.com/doctor/{id}/patient';
  }
 
  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }
 
  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }


  public DoctorPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.doctorPatientsUrl)
  }

  public newPatient(patient: PatientDto) {
    return this.http.post<PatientDto>(this.regUrl, patient);
  }
}