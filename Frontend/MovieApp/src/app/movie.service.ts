import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from './movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  url = 'http://localhost:8080/movies';
  
  public getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.url);
  }

  public getMovieById(id: number): Observable<Movie> {
    return this.http.get<Movie>(`${this.url}/${id}`);
  }

  constructor(private http: HttpClient) { }
}
