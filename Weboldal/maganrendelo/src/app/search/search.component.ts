import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Surgery } from '../model/surgery';
import { SurgeryService } from '../service/surgery.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  surgeries: Surgery[];
  searched: Surgery[];

  constructor(private route: ActivatedRoute,
    private surgeryService: SurgeryService) {
  }

  ngOnInit(): void {
    let searchText = this.route.snapshot.paramMap.get('searchText');
    this.surgeryService.findAll().subscribe(data => {
      this.surgeries = data;
    });
    for(let i = 0; i < this.surgeries.length; i++){
      if(this.surgeries[i].name.includes(searchText)){
        this.searched.push(this.surgeries[i]);
      }
    }
  }

}
