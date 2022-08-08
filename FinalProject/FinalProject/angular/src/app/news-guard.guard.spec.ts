import { TestBed } from '@angular/core/testing';

import { NewsGuardGuard } from './news-guard.guard';

describe('NewsGuardGuard', () => {
  let guard: NewsGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(NewsGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
