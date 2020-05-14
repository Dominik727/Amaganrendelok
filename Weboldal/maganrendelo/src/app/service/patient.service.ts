import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { LoginAttributes } from '../model/LoginAttributes';

@Injectable()
export class PatientService {
 
  private patientsUrl: string;
  private regUrl: string;
  private doctorPatientsUrl: string;
  private basicUrl: string;
 
  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://maganrendelo.herokuapp.com/admin/patients';
    this.regUrl = 'http://maganrendelo.herokuapp.com/registration';
    this.doctorPatientsUrl = 'http://maganrendelo.herokuapp.com/doctor/{id}/patient';
    this.basicUrl = 'http://maganrendelo.herokuapp.com';
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
 
  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }
 
  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }


  public DoctorPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.doctorPatientsUrl)
  }

  public newPatient(patient: Patient) {
    return this.http.post<Patient>(this.regUrl, patient);
  }

  getPatient(id: number): Observable<Patient> {
    const url = `${this.basicUrl}/patient/${id}`;
    return this.http.get<Patient>(url).pipe(
      catchError(this.handleError<Patient>(`getPatient id=${id}`))
    );
  }

  updatePatient(patient: Patient): Observable<any> {
    const url = `${this.basicUrl}/patient/${patient.id}/edit`;
    return this.http.post(url, patient, this.httpOptions).pipe(
      catchError(this.handleError<any>('updatePatient'))
    );
  }

  deletePatient(patient: Patient | number): Observable<Patient> {
    const id = typeof patient === 'number' ? patient : patient.id;
    const url = `${this.basicUrl}/patient/${id}`;

    return this.http.delete<Patient>(url, this.httpOptions).pipe(
      catchError(this.handleError<Patient>('deleteSurgery'))
    );
  }

  public CheckMatch(loginAttr: LoginAttributes){
    const url = `${this.basicUrl}/patientlogin`;
    return this.http.post<Patient>(url, loginAttr);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };
  }
}