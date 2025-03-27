import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-movie-details',
  imports: [CommonModule],
  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  movie$!: Observable<Movie>;
  movieService = inject(MovieService);

  constructor() {
    const movieId = Number(this.route.snapshot.params['id']);
    this.movie$ = this.movieService.getMovieById(movieId);
  }
}
