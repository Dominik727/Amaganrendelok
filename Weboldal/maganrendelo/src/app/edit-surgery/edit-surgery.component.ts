import { Component, OnInit } from '@angular/core';
import { SurgeryService } from '../service/surgery.service';
import { ActivatedRoute } from '@angular/router';
import { Surgery } from '../model/surgery';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit-surgery',
  templateUrl: './edit-surgery.component.html',
  styleUrls: ['./edit-surgery.component.css']
})
export class EditSurgeryComponent implements OnInit {

  surgery: Surgery;

  constructor(private route: ActivatedRoute,
    private surgeryService: SurgeryService,    
    private location: Location) { }

    ngOnInit(): void {
      this.getSurgery();
    }
  
    getSurgery(): void {
      const id = +this.route.snapshot.paramMap.get('id');
      this.surgeryService.getSurgery(id)
        .subscribe(surgery => this.surgery = surgery);
    }
  
    goBack(): void {
      this.location.back();
    }

    save(): void {
      this.surgeryService.updateSurgery(this.surgery)
        .subscribe(() => this.goBack());
    }

}
