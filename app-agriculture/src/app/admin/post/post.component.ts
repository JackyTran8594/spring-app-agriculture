import { Component, OnInit } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { PostService } from './post.service';
import { post } from './post.dto';
import { error } from '@angular/compiler/src/util';
import { POSTS } from '../utils/post';


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
    // add: {
    //   addButtonContent: '<i class="nb-plus"></i>',
    //   createButtonContent: '<i class="nb-checkmark"></i>',
    //   cancelButtonContent: '<i class="nb-close"></i>',
    // },
    // edit: {
    //   editButtonContent: '<i class="nb-edit"></i>',
    //   saveButtonContent: '<i class="nb-checkmark"></i>',
    //   cancelButtonContent: '<i class="nb-close"></i>',
    // },
    // delete: {
    //   deleteButtonContent: '<i class="nb-trash"></i>',
    //   confirmDelete: true,
    // },
    columns: {
      id: {
        title: 'ID',
        type: 'string',
        // filter: true,
      },
      postId: {
        title: 'Post ID',
        type: 'string',
      },
      content: {
        title: 'Content',
        type: 'string',
      },
      title: {
        title: 'Title',
        type: 'string',
      },
      note: {
        title: 'Note',
        type: 'string',
      },
      author: {
        title: 'Author',
        type: 'string',
      },
    },
  }

  source: LocalDataSource;


  constructor(private service: PostService) {
    this.source = new LocalDataSource(POSTS)
  }

  // onDeleteConfirm(event) :void {
  //   if(window.confirm('Are you sure you want to delete?'))
  //   {
  //     event.confirm.resolve();
  //   } else {
  //     event.confirm.reject();
  //   }
  // }

  ngOnInit(): void {
    // this.service.getAll().subscribe(
    //   data => {
    //     this.posts = data;
    //   },
    //   error => {
    //     console.error(error)
    //   },
    //   () => console.log('done!!!')
    // );

  }
}
