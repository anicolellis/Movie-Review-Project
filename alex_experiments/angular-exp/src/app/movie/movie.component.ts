import { Component,Input } from '@angular/core';
import { Movie } from '../movie';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-movie',
  imports: [CommonModule],
  templateUrl: './movie.component.html',
  styleUrl: './movie.component.css'
})
export class MovieComponent {
  @Input() movie!: Movie;
}
