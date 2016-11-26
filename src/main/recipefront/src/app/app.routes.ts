import { RouterModule } from '@angular/Router';
import { CreateRecipePageComponent, RecipesComponent }  from 'components';


export const APP_ROUTER_PROVIDER = RouterModule.forRoot([
    { path: '', redirectTo: '/recipe', pathMatch: 'full' },
    { path: 'recipe', component: CreateRecipePageComponent },
    { path: 'recipes', component : RecipesComponent }
]);