import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PostRoutingModule } from './post-routing.module';
import { PostComponent } from './post.component';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { DetailComponent } from './detail/detail.component';


@NgModule({
  declarations: [PostComponent, CreateComponent, UpdateComponent, DetailComponent],
  imports: [
    CommonModule,
    PostRoutingModule
  ]
})
export class PostModule { }
