import { Component, OnInit } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { CreateComponent } from './create/create.component';
import { PostService } from './post.service';


@Component({
  selector: 'app-post',
  template: `
  <router-outlet></router-outlet>
  `
})
export class PostComponent {


}
