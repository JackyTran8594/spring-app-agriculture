import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { PostModule } from './post/post.module';
import { MaterialModule } from './material.module';



@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    PostModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AdminComponent]
})
export class AdminModule { }
