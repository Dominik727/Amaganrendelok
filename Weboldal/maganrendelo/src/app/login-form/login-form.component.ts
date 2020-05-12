import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../service/patient.service';
import { LoginAttributes } from '../model/LoginAttributes';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  logattr: LoginAttributes;

  constructor(private route: ActivatedRoute, private router: Router, private patientService: PatientService) {
    this.logattr = new LoginAttributes;
  }

  onSubmit() {    
    this.patientService.CheckMatch(this.logattr).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/home']);
  }
  ngOnInit(): void {
  }

}
