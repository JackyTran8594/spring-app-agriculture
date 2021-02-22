import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { CreateComponent } from './post/create/create.component';
import { DetailComponent } from './post/detail/detail.component';
import { PostComponent } from './post/post.component'
import { UpdateComponent } from './post/update/update.component';

const routes: Routes = [
  {
    path: '', component: AdminComponent,
    children: [
      { path: 'post', loadChildren:() => import('./post/post.module').then(m=>m.PostModule) },

    ]
  },
 
  // {
  //   path: 'post', loadChildren: () => import('./post/post.module').then(m => m.PostModule)  
  // } 
 // => lazy load module
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})

export class AdminRoutingModule { }
