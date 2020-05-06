import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../service/patient.service';
import { PatientDto } from '../model/patientdto';
import { FormGroup, FormBuilder, Validators, FormControl, NgForm } from '@angular/forms';


@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent {

  patient: PatientDto;
  registrationForm: FormGroup;  
  isSubmitted: boolean = false;  

  form = new FormGroup({
    lastname: new FormControl('', [Validators.required, Validators.pattern('[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$')]),
    firstname: new FormControl('', [Validators.required, Validators.pattern('[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    tel: new FormControl('', [Validators.required, Validators.pattern('^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$'), Validators.minLength(11), Validators.maxLength(12)]),
    taj: new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$'), Validators.minLength(9), Validators.maxLength(9)]),
    pass: new FormControl('', [Validators.required, Validators.minLength(6)]),
  })



  constructor(private route: ActivatedRoute, private router: Router, private patientService: PatientService) {

    this.patient = new PatientDto();
  }

  onSubmit() {
    this.isSubmitted = true; 
    if(this.registrationForm.valid){        
      this.patientService.newPatient(this.patient).subscribe(result => this.gotoUserList()); 
    }
  }

  gotoUserList() {
    this.router.navigate(['/home']);
  }

}
