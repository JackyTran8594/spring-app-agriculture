import { Component, Input, OnInit } from '@angular/core';
import { post } from '../post.dto';
import { PostService } from '../post.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  constructor(private service: PostService) { }

  @Input() postId: string;

  item: post

  //closed form or redirect to main page
  close() {

  }


  ngOnInit() {
    this.service.detailPost(this.postId).subscribe(
      (data: any) => {
        this.item = data;
        console.log('done data!!!')
      },
      error => {
        console.error(error)
      },
      () => console.log('done!!!')
    );
  }



}
