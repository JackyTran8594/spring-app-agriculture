import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './post.component';
import { CreateComponent } from './create/create.component';
import { DetailComponent } from './detail/detail.component';
import { UpdateComponent } from './update/update.component';
import { NbAccordionModule, NbButtonModule, NbCardModule, NbIconModule, NbListModule, NbRouteTabsetModule, NbStepperModule, NbTabsetModule, NbTreeGridModule, NbUserModule } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';





@NgModule({
  declarations: [PostComponent, CreateComponent, DetailComponent, UpdateComponent ],
  imports: [
    CommonModule,
    NbCardModule,
    NbButtonModule,
    NbListModule,
    Ng2SmartTableModule,
    NbIconModule,
  ]
})
export class PostModule { }
