import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateExpenseTicketComponent } from './create-expense-ticket.component';

describe('CreateExpenseTicketComponent', () => {
  let component: CreateExpenseTicketComponent;
  let fixture: ComponentFixture<CreateExpenseTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateExpenseTicketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateExpenseTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
