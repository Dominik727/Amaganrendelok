import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  comments: Array<any>;

  constructor() { }

  ngOnInit(): void {
    this.comments = [
      {
        author: 'Ambrus',
        content: 'Ez igen'
      },
      {
        author: 'Dominik',
        content: 'Hajrá hajrá'
      },
      {
        author: 'Dávid',
        content: 'Na végre'
      },
      {
        author: 'Patrik',
        content: 'ez működik'
      }
    ];
  }

}
