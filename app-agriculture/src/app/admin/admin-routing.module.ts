import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';

const routes: Routes = [
  // { path: '', component: AdminComponent, pathMatch: 'full' },
  {path:'admin/post', loadChildren: () => import('./post/post.module').then(m=>m.PostModule)}
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminRoutingModule { }
