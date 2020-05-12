import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from '../service/doctor.service';
import { LoginAttributes } from '../model/LoginAttributes';

@Component({
  selector: 'app-doctor-login',
  templateUrl: './doctor-login.component.html',
  styleUrls: ['./doctor-login.component.css']
})
export class DoctorLoginComponent implements OnInit {

  logattr: LoginAttributes;

  constructor(private route: ActivatedRoute, private router: Router, private doctorService: DoctorService) {
    this.logattr = new LoginAttributes;
  }

  onSubmit() {
    this.doctorService.CheckMatch(this.logattr).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/home']);
  }
  ngOnInit(): void {
  }

}
