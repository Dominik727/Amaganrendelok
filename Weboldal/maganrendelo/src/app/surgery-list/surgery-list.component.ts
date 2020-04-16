import { Component, OnInit } from '@angular/core';
import { Surgery } from '../model/surgery';
import { SurgeryService } from '../service/surgery.service';

@Component({
  selector: 'app-surgery-list',
  templateUrl: './surgery-list.component.html',
  styleUrls: ['./surgery-list.component.css']
})
export class SurgeryListComponent implements OnInit {

  surgeries: Surgery[];

  constructor(private surgeryService: SurgeryService) { }

  ngOnInit(): void {
    this.surgeryService.findAll().subscribe(data => {
      this.surgeries = data;
    });
  }
}
