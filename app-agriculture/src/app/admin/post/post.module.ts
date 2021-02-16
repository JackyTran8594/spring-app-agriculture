import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './post.component';
import { CreateComponent } from './create/create.component';
import { DetailComponent } from './detail/detail.component';
import { UpdateComponent } from './update/update.component';
import { NbAccordionModule, NbButtonModule, NbCardModule, NbCheckboxModule, NbIconModule, NbListModule, NbRouteTabsetModule, NbStepperModule, NbTabsetModule, NbTreeGridModule, NbUserModule, NbWindowModule, NbWindowRef } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from './post.service';
import { FormsModule } from '@angular/forms';





@NgModule({
  declarations: [PostComponent, CreateComponent, DetailComponent, UpdateComponent],
  imports: [
    CommonModule,
    NbCardModule,
    NbButtonModule,
    NbListModule,
    Ng2SmartTableModule,
    NbIconModule,
    HttpClientModule,
    NbCheckboxModule,
    FormsModule,
  ],
  providers: [PostService]
}
)
export class PostModule { }