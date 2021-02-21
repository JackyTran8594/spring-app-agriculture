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
import { RouterModule, Routes } from '@angular/router';



const routes: Routes = [
  { path: 'create', component: CreateComponent, pathMatch: 'full' },
  { path: 'edit', component: UpdateComponent, pathMatch: 'full' },
  { path: 'detail', component: UpdateComponent, pathMatch: 'full' }
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)

  ],
  providers: []
}
)
export class PostModule { }