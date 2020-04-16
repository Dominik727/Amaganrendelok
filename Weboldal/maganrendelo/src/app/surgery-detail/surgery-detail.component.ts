import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SurgeryService } from '../service/surgery.service';
import { Surgery } from '../model/surgery';
import { Location } from '@angular/common';

@Component({
  selector: 'app-surgery-detail',
  templateUrl: './surgery-detail.component.html',
  styleUrls: ['./surgery-detail.component.css']
})
export class SurgeryDetailComponent implements OnInit {

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

}