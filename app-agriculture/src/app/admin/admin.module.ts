import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { PostModule } from './post/post.module';
<<<<<<< HEAD
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
=======
import { MDBBootstrapModule } from 'angular-bootstrap-md';
// import { MaterialModule } from './material.module';
>>>>>>> 0afc44ebef75dcc34de471c478a97e9885dc6323

import { MatSidenavModule } from '@angular/material/sidenav';


@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    PostModule,
<<<<<<< HEAD
    MatSidenavModule
=======
    MDBBootstrapModule
    // MaterialModule
>>>>>>> 0afc44ebef75dcc34de471c478a97e9885dc6323
  ],
  providers: []
})
export class AdminModule { }
