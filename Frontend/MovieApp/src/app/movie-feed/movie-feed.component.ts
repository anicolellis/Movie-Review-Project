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
  styleUrls: ['./movie-feed.component.css', './movie.component.css']
})
export class MovieFeedComponent {
  movieList$!: Observable<Movie[]>;
  movieService: MovieService = inject(MovieService);
  
  constructor() { this.movieList$ = this.movieService.getAllMovies(); }
  
  ngOnInit(): void {
    
  }
}
