import { Component, inject } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-movie-feed',
  imports: [AsyncPipe],
  templateUrl: './movie-feed.component.html',
  styleUrl: './movie-feed.component.css'
})
export class MovieFeedComponent {
  movieList$!: Observable<Movie[]>;
  movieService: MovieService = inject(MovieService);
  
  constructor() {}
  
  ngOnInit(): void {
    this.movieList$ = this.movieService.getAllMovies();
  }
}
