import { Component, OnInit } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';
import { CreateComponent } from './create/create.component';
import { PostService } from './post.service';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html'

})
export class PostComponent {

  public posts;

  settings = {
    mode: 'external',
    hideSubHeader: true,
    actions: {
      add: false,
      edit: false,
      delete: false,
      position: 'right',
    },

    columns: {
      id: {
        title: 'ID',
        type: 'string',
        filter: false,
      },
      postId: {
        title: 'Post ID',
        type: 'string',
        filter: false,
      },
      content: {
        title: 'Content',
        type: 'string',
        filter: false,
      },
      title: {
        title: 'Title',
        type: 'string',
        filter: false,

      },
      note: {
        title: 'Note',
        type: 'string',
        filter: false,

      },
      author: {
        title: 'Author',
        type: 'string',
        filter: false,
      },
    },
  }

  source: LocalDataSource;


  constructor(private service: PostService, private dialogService: NbDialogService) {
    // this.source = new LocalDataSource(POSTS)
  }

  ngOnInit() {
    this.service.getAll().subscribe(
      data => {
        this.source = new LocalDataSource(data);
        console.log('done data!!!')
      },
      error => {
        console.error(error)
      },
      () => console.log('done!!!')
    );

  }

  onSearch(query: string = '') {
    this.source.setFilter([
      // fields we want to include in the search
      {
        field: 'id',
        search: query
      },
      {
        field: 'postId',
        search: query
      },
      {
        field: 'title',
        search: query
      },
      {
        field: 'author',
        search: query
      }
    ], false);
    // second parameter specifying whether to perform 'AND' or 'OR' search 
    // (meaning all columns should contain search query or at least one)
    // 'AND' by default, so changing to 'OR' by setting false here
  }


  openCreatForm() {
    this.dialogService.open(CreateComponent, {hasBackdrop: true, closeOnBackdropClick: false})
  }
}
