import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { PostModule } from './post/post.module';
import { MaterialModule } from '../admin/material.module'
import { MatSidenavModule } from '@angular/material/sidenav';


@NgModule({ 
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    PostModule,
    MatSidenavModule,
    MaterialModule
  ],
  providers: []
})
export class AdminModule { }
