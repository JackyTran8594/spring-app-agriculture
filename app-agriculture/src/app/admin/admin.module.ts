import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { NbIconModule, NbLayoutModule, NbMenuModule, NbSidebarModule, NbSidebarService, NbThemeModule, NbThemeService } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';


@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    NbIconModule,           
    NbLayoutModule,
    NbMenuModule,
    NbSidebarModule,
    NbEvaIconsModule
  ],
  providers: [NbThemeService, NbSidebarService]
})
export class AdminModule { }
