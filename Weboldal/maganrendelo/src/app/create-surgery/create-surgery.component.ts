import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Surgery } from '../model/surgery';
import { SurgeryService } from '../service/surgery.service';

@Component({
  selector: 'app-create-surgery',
  templateUrl: './create-surgery.component.html',
  styleUrls: ['./create-surgery.component.css']
})
export class CreateSurgeryComponent implements OnInit {

  surgery: Surgery;

  constructor(private route: ActivatedRoute, private router: Router, private surgeryService: SurgeryService) {
    this.surgery = new Surgery();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.surgeryService.save(this.surgery).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/home']);
  }

}
