import { Http } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import { Recipe, RecipeService } from 'shared';
import { FormGroup, FormControl } from '@angular/forms';



@Component({
  selector: 'app-create-recipe-page',
  templateUrl: './create-recipe-page.component.html',
  styleUrls: ['./create-recipe-page.component.css']
})
export class CreateRecipePageComponent implements OnInit {

  // registerForm: FormGroup;
  title: string;
  cookingTime: number;
  preparationTime: number;
  description: string;
  note: string;

  recipe: Recipe;

  constructor(private http: Http, private recipeService: RecipeService) {
    this.recipe = new Recipe();
  }

  ngOnInit() {
  }

  public submit() {
    debugger;
    this.recipeService.save(this.recipe).subscribe();
  }

}
