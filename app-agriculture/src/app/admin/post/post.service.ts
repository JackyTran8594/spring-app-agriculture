import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, tap } from 'rxjs/operators';
import { HttpService } from '../../share/api.url';
import { post } from './post.dto';
import { MessageService } from '../../share/message.service'
import { of } from 'rxjs';
import { HandleErrorService } from '../../share/handleError.service';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const BACKEND_URL = HttpService.serverApiURL + '/post';

@Injectable()

export class PostService {

  constructor(private http: HttpClient, private handleErrorService: HandleErrorService) {

  }

  getAll(): Observable<post[]> {
    return this.http.get<post[]>(BACKEND_URL + '/getAll')
      .pipe(catchError(
        this.handleErrorService.handleError<post[]>('getHeroes', [])
      ))
  }

  createPost(item: post): Observable<post> {
    let body = JSON.stringify(item);
    return this.http.post<post>(BACKEND_URL + '/post', body, httpOptions);
  }

  updatePost(item: post) {
    let body = JSON.stringify(item);
    return this.http.put(BACKEND_URL + '/update' + item.id, body, httpOptions);
  }

  deletePost(id) {
    return this.http.delete(BACKEND_URL + '/delete' + id, httpOptions);
  }

 

}
