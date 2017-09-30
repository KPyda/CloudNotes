import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.css']
})
export class TopNavComponent implements OnInit {
  imagePath: string;

  constructor() {
    this.imagePath = '/assets/cloud_image.jpg';
  }


  ngOnInit() {
  }


}
