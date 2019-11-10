import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { ChildComponent } from './child/child.component';
import { UserService } from './Services/user.service';
import { LoginformComponent } from './loginform/loginform.component';
import { FilerPipe } from './filer.pipe';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    ChildComponent,
    LoginformComponent,
    FilerPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([])
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
