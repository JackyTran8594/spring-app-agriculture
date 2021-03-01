import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './post.component';
import { CreateComponent } from './create/create.component';
import { DetailComponent } from './detail/detail.component';
import { UpdateComponent } from './update/update.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { HttpClientModule } from '@angular/common/http';
import { PostService } from './post.service';
import { FormsModule } from '@angular/forms';
import { PostRoutingModule } from '../post/post-routing.module';
import { IndexComponent } from './index/index.component';

// import { MatCardModule } from '@angular/material/card';
// import { MatPaginatorModule } from '@angular/material/paginator';
// import { MatTableModule } from '@angular/material/table';
// import { MatButtonModule } from '@angular/material/button';




@NgModule({
  declarations: [PostComponent, CreateComponent, DetailComponent, UpdateComponent, IndexComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    PostRoutingModule,
    // MatCardModule,
    // MatPaginatorModule,
    // MatTableModule,
    // MatButtonModule
  ],
  providers: [PostService]
}
)
export class PostModule { }