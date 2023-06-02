import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersDashboardComponent } from './users-dashboard/users-dashboard.component';
import { UsersRoutingModule } from './users-routing.module';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    UsersDashboardComponent,
  
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    HttpClientModule,

  ]
})
export class UsersModule { }
