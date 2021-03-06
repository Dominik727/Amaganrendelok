import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Surgery } from '../model/surgery';
import { SurgeryService } from '../service/surgery.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-create-surgery',
  templateUrl: './create-surgery.component.html',
  styleUrls: ['./create-surgery.component.css']
})
export class CreateSurgeryComponent implements OnInit {

  surgery: Surgery;
  url: any;

  constructor(private route: ActivatedRoute, private router: Router,
    private surgeryService: SurgeryService, private location: Location) {
    this.surgery = new Surgery();
  }

  ngOnInit(): void {
    this.url = "./assets/placeholder.webp";
  }

  onSubmit() {
    this.surgeryService.save(this.surgery).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/home']);
  }

  goBack(): void {
    this.location.back();
  }

  
  onSelectFile(event) {
    console.log(event);
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        this.url = event.target.result;
      }
    }
  }

}
