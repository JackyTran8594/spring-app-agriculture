import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { LocalDataSource } from 'ng2-smart-table';
import { POST } from '../post.dto';
import { POSTS } from '../../utils/post'
import { PostService } from '../post.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[] = ['Id', 'PostId', 'Title', 'Author','Action'];

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  dataSource = new MatTableDataSource<POST>(POSTS);




  constructor(private service: PostService) {
    // this.source = new LocalDataSource(POSTS)
  }

  ngOnInit() {
    // this.service.getAll().subscribe(
    //   data => {
    //     this.source = new LocalDataSource(data);
    //     console.log('done data!!!')
    //   },
    //   error => {
    //     console.error(error)
    //   },
    //   () => console.log('done!!!')
    // );

  }

  onSearch(query: string = '') {
   
  }

}
