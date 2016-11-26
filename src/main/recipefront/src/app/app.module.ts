import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { APP_ROUTER_PROVIDER } from './app.routes';

import { AppComponent } from './app.component';
import { CreateRecipePageComponent, RecipesComponent } from 'components';
import { RecipeService } from 'shared';



@NgModule({
  declarations: [
    AppComponent,
    CreateRecipePageComponent,
    RecipesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    APP_ROUTER_PROVIDER
  ],
  providers: [RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
