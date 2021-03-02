import { NgModule } from '@angular/core';
import { PostComponent } from './post.component';
import { CreateComponent } from './create/create.component';
import { DetailComponent } from './detail/detail.component';
import { UpdateComponent } from './update/update.component';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';



const routes: Routes = [
  {
    path: '', component: PostComponent, children: [
      { path: '', redirectTo: 'create', pathMatch: 'full' },
      { path: 'index', component: IndexComponent, pathMatch: 'full' },
      { path: 'create', component: CreateComponent, pathMatch: 'full' },
      { path: 'update', component: UpdateComponent, pathMatch: 'full'},
      { path: 'detail', component: DetailComponent, pathMatch: 'full'}
    ]
  }
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule],
}
)
export class PostRoutingModule { }