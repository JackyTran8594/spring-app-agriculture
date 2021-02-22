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
import { IndexComponent } from './index/index.component';



const routes: Routes = [
  {
    path: '', component: PostComponent, children: [
      { path: '', redirectTo: 'index', pathMatch: 'full' },
      { path: 'index', component: IndexComponent, pathMatch: 'full' },
      { path: 'create', component: CreateComponent, pathMatch: 'full' },
      { path: 'update', component: UpdateComponent, pathMatch: 'full' },
      { path: 'detail', component: DetailComponent, pathMatch: 'full' }
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)

  ],
  exports: [RouterModule],
  providers: []
}
)
export class PostRoutingModule { }