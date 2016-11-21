import { RouterModule } from '@angular/Router';
import { CreateRecipePageComponent } from './create-recipe-page/create-recipe-page.component';
import { RecipesComponent } from './recipes-page/recipes.component';


export const APP_ROUTER_PROVIDER = RouterModule.forRoot([
    { path: '', redirectTo: '/recipe', pathMatch: 'full' },
    { path: 'recipe', component: CreateRecipePageComponent },
    { path: 'recipes', component : RecipesComponent }
]);