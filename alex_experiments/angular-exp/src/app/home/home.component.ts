import {Component, inject, ViewChild} from '@angular/core';
import {CommonModule} from '@angular/common';
//import {HousingLocationComponent} from '../housing-location/housing-location.component';
import {Movie} from '../movie';
import { MovieComponent } from '../movie/movie.component';
//import {HousingService} from '../housing.service';
import { MovieService } from '../movie.service';
import { MovieFormComponent } from '../movie-form/movie-form.component';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [CommonModule, MovieComponent, MovieFormComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})

export class HomeComponent {
  movieList: Movie[] = [];
  movieService: MovieService = inject(MovieService);
  filteredMovieList: Movie[] = [];
  @ViewChild(MovieFormComponent) child!:MovieFormComponent;

  constructor() {
    this.movieService.getAllMovies().then((movieList: Movie[]) => {
      this.movieList = movieList;
      this.filteredMovieList = movieList;
    });
  }

  filterResults(text: string) {
    if(!text) {
      this.filteredMovieList = this.movieList;
      return;
    }

    this.filteredMovieList = this.movieList.filter((movie) => 
      movie?.title.toLowerCase().includes(text.toLowerCase())
    );
  }
  submitMovie() {
    this.movieService.submitMovie(
      this.child.mForm.value.title ?? '',
      this.child.mForm.value.director ?? '',
    );
    this.movieService.getAllMovies().then((movieList: Movie[]) => {
      this.movieList = movieList;
      this.filteredMovieList = movieList;
    });
  }
}