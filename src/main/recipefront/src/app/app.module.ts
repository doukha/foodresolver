import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { APP_ROUTER_PROVIDER } from './app.routes';

import { AppComponent } from './app.component';
import { CreateRecipePageComponent } from './create-recipe-page/create-recipe-page.component';
import { RecipesComponent } from './recipes-page/recipes.component';


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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
