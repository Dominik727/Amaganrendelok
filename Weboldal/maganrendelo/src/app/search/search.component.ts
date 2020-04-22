import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Surgery } from '../model/surgery';
import { SurgeryService } from '../service/surgery.service';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  surgeries$: Observable<Surgery[]>;
  private searchTerms = new Subject<string>();

  constructor(private surgeryService: SurgeryService) { }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.surgeries$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.surgeryService.searchSurgeries(term)),
    );
  }

}
