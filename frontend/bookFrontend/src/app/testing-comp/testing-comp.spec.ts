import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestingComp } from './testing-comp';

describe('TestingComp', () => {
  let component: TestingComp;
  let fixture: ComponentFixture<TestingComp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TestingComp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TestingComp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
