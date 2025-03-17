import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MovieFeedComponent } from './movie-feed/movie-feed.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MovieFeedComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'MovieApp';
}
