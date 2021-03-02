import { Component, Input, OnInit } from '@angular/core';
import { post } from '../post.dto';
import { PostService } from '../post.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private service: PostService) { }

  @Input() id: string; // decorate the property with @Input()

  item: post


  save(item) {
    this.service.updatePost(item);
    this.close()
  }

  //closed form or redirect to main page
  close() {


  }

  ngOnInit() {
    this.service.detailPost(this.id).subscribe(
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
