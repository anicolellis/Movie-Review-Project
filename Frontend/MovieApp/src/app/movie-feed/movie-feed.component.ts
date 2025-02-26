import { Component, inject } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movie-feed',
  imports: [],
  templateUrl: './movie-feed.component.html',
  styleUrl: './movie-feed.component.css'
})
export class MovieFeedComponent {
  movieList: Movie[] = [];
  movieService: MovieService = inject(MovieService);
  
  constructor() {
    this.movieService.getAllMovies() // TODO
  }
}
