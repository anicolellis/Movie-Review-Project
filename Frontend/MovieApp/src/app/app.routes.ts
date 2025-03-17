import { Routes } from '@angular/router';

import { MovieFeedComponent } from './movie-feed/movie-feed.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';

export const routes: Routes = [
    {
        path: '',
        component: MovieFeedComponent,
    },
    {
        path: 'details/:id',
        component: MovieDetailsComponent,
    },
];
