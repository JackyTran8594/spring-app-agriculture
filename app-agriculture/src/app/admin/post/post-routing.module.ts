import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { PostComponent } from './post.component';
import { UpdateComponent } from './update/update.component';
import { DetailComponent } from './detail/detail.component';


const routes: Routes = [
  {
    path:'',
    component:PostComponent,
    children :
    [
      {
        path:'create',
        component: CreateComponent
      },
      {
        path:'update',
        component: UpdateComponent
      },
      {
        path:'detail',
        component: DetailComponent
      }
      // {
      //   path:'delete',
      //   component: 
      // }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PostRoutingModule { }
