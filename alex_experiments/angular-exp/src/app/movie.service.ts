import { Injectable } from '@angular/core';
import { Movie } from './movie';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  //url = 'http://localhost:3000/movies';
  url = 'http://localhost:8080/movies/';
  
  async getAllMovies(): Promise<Movie[]> {
    const data = await fetch(`${this.url}all`);
    return (await data.json());
    //return this.http.get<Movie[]>(`${this.url}all`);
  }
  /*
  async getMovieById(id: number): Promise<Movie | undefined> {
    const data = await fetch(`${this.url}/${id}`);
    return (await data.json()) ?? {};
  }
  */
  async submitMovie(title: string, director: string): Promise<string> {
    //console.log(`New movie data: ${title} by ${director}.`);
    
    const data = await fetch(this.url, {method: 'POST',
      headers: new Headers({'content-type': 'application/json'}),
      body: JSON.stringify({"title": title, "director": director})
    });
    return (await data.json());
  }
  constructor() { }
}
