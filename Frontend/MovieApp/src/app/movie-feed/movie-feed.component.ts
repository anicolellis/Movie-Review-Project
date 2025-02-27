import { Component, inject } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { Observable } from 'rxjs';
import { AsyncPipe, CommonModule } from '@angular/common';
import { MovieComponent } from '../movie/movie.component';

@Component({
  selector: 'app-movie-feed',
  imports: [AsyncPipe, MovieComponent, CommonModule],
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
