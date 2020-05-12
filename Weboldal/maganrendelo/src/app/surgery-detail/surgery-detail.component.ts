import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SurgeryService } from '../service/surgery.service';
import { Surgery } from '../model/surgery';
import { Location } from '@angular/common';
import { DomSanitizer } from '@angular/platform-browser';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { Doctor } from '../model/doctor';
import { MyComment } from '../model/Comment';

@Component({
  selector: 'app-surgery-detail',
  templateUrl: './surgery-detail.component.html',
  styleUrls: ['./surgery-detail.component.css']
})
export class SurgeryDetailComponent implements OnInit {

  // Ezt kitörölni és helyette a surgery.doctors listát használni, és a getSurgery osztályból is törölni a statikus részt
  doctors: Doctor[];
  
  @Input() surgery: Surgery;
  closeResult: string;
  modal: any;
  comments: any[];
  comment: MyComment = new MyComment;

  model: NgbDateStruct;
  date: {year: number, month: number};
  time = {hour: 13, minute: 30};
  minuteStep = 30;

  

  constructor(private route: ActivatedRoute,
    private surgeryService: SurgeryService,
    private location: Location,
    private sanitizer: DomSanitizer,
    private modalService: NgbModal,
    private calendar: NgbCalendar) { }

  ngOnInit(): void {
    this.getSurgery();
  }

  getSurgery(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.surgeryService.getSurgery(id)
      .subscribe(surgery => this.surgery = surgery);

    this.surgeryService.getComments(id)
      .subscribe(comments => this.comments = comments);

      
      this.doctors = new Array<Doctor>();
      let d = new Doctor();
      d.lastname = "test";
      d.firstname = "elek";
      d.category = "testeset";

      let d2 = new Doctor();
      d2.lastname = "test2";
      d2.firstname = "elek2";
      d2.category = "testeset2";

      this.doctors.push(d);
      this.doctors[1] = d2;
  }

  goBack(): void {
    this.location.back();
  }

  mapUrl() {
    return this.sanitizer.bypassSecurityTrustResourceUrl(this.surgery.map);
  }

  delete(surgery: Surgery): void {
    this.surgeryService.deleteSurgery(surgery).subscribe(() => this.goBack());
    this.modal.close();
  }

  open(content) {
    this.modal = this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  selectToday() {
    this.model = this.calendar.getToday();
  }

  postComment(){
    this.comment.author = 'Ambrus';
    this.surgeryService.postComment(parseInt(this.surgery.id), this.comment).subscribe(() => location.reload());

  }

  

}
