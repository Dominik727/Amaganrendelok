import { Component, OnInit } from '@angular/core';
import { Clinic } from 'src/model/clinic';

@Component({
  selector: 'app-clinic-list',
  templateUrl: './clinic-list.component.html',
  styleUrls: ['./clinic-list.component.css']
})
export class ClinicListComponent implements OnInit {

  clinics: Clinic[] = [];
  clinic: Clinic = new Clinic;

  constructor() { }

  ngOnInit(): void {

    this.clinic.name = "Szent Margit Rendelőintézet";
    this.clinic.opening = 'H-P: 06:00 - 20:00 \
                          Sz-V: 10:00 - 18:00';
    this.clinic.addr = "1037 Budapest III.ker Taksony utca 17."
    this.clinic.email = "valamilyen@egyikse.hu"
    this.clinic.tel = "+36305047819"
    this.clinic.info = "oijoiaef"

    for (let _ of Array(10).keys()){
      this.clinics.push(this.clinic);
    }
  }



}
