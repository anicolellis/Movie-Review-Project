import { TestBed } from '@angular/core/testing';

import { MovieService } from './movie.service';
import { HttpClient } from '@angular/common/http';
import { Movie } from './movie';

/*
* Expected responses: 200, if the request has a body, returns a copy of the body, otherwise empty body
* Movie: title, release year, runtime, genre, rating, director, description
*/
describe('MovieService', () => {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let service: MovieService;

  beforeEach(() => {
    //TestBed.configureTestingModule({providers: [MovieService]});
    //service = TestBed.inject(MovieService);
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['getAllMovies']);
    service = new MovieService(httpClientSpy);
  });

  it('should return movies when getAllMovies() is called', (done: DoneFn) => {
    const expectedMovies: Movie[] = [
      {title: "Test 1", release_year: 2024, runtime: 90, genre: "Comedy", rating: 91, director: "John Smith", description: "Test Movie #1"},
      {title: "Test 2", release_year: 2025, runtime: 120, genre: "Action", rating: 85, director: "David Jones", description: "Test Movie #2"},
    ];

    httpClientSpy.get.and.returnValue(asyncData(expectedMovies));

    service.getAllMovies().subscribe({
      next: (movies) => {
        expect(movies).withContext('expected movies').toEqual(expectedMovies);
        done();
      },
      error: done.fail,
    });
    expect(httpClientSpy.get.calls.count()).withContext('one call').toBe(1);
  });
});
