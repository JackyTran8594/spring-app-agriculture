import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './post.component';
import { CreateComponent } from './create/create.component';
import { DetailComponent } from './detail/detail.component';
import { UpdateComponent } from './update/update.component';
import { NbAccordionModule, NbButtonModule, NbCardModule, NbCheckboxModule, NbIconModule, NbLayoutModule, NbListModule, NbMenuModule, NbRouteTabsetModule, NbSidebarModule, NbStepperModule, NbTabsetModule, NbTreeGridModule, NbUserModule, NbWindowModule, NbWindowRef } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from './post.service';
import { FormsModule } from '@angular/forms';
import { PostRoutingModule } from '../post/post-routing.module';
import { IndexComponent } from './index/index.component';
import { NbEvaIconsModule } from '@nebular/eva-icons';



@NgModule({
  declarations: [PostComponent, CreateComponent, DetailComponent, UpdateComponent, IndexComponent],
  imports: [
    CommonModule,
    NbCardModule,
    NbButtonModule,
    Ng2SmartTableModule,
    NbIconModule,
    HttpClientModule,
    FormsModule,
    // NbMenuModule,
    // NbSidebarModule,
    NbEvaIconsModule,
    PostRoutingModule
  ],
  providers: [PostService]
}
)
export class PostModule { }