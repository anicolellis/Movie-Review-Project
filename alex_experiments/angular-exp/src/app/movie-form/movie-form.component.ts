import { Component, inject} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms'
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movie-form',
  imports: [ReactiveFormsModule],
  templateUrl: './movie-form.component.html',
  styleUrl: './movie-form.component.css'
})
export class MovieFormComponent {
  movieService = inject(MovieService);
  mForm = new FormGroup({
    title: new FormControl(''),
    director: new FormControl('')
  });

  submitMovie() {
    this.movieService.submitMovie(
      this.mForm.value.title ?? '',
      this.mForm.value.director ?? '',
    );
  }
}
