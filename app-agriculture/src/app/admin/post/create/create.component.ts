import { Component, OnInit } from '@angular/core';
import { NbDialogRef, NbDialogService, NbWindowRef } from '@nebular/theme';
import { post } from '../post.dto';
import { PostService } from '../post.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {

  constructor(private service: PostService, protected dialogRef: NbDialogRef<any>) { }

  item :post


  save(item) {
    this.service.createPost(item);
    this.dismiss()
  }

  //closed form or redirect to main page
  dismiss() {
    this.dialogRef.close();
  }
}
