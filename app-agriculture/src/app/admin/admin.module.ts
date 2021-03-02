import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { PostModule } from './post/post.module';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
// import { MaterialModule } from './material.module';



@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    PostModule,
    MDBBootstrapModule
    // MaterialModule
  ],
  providers: [],
  bootstrap: [AdminComponent]
})
export class AdminModule { }
