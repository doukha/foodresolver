import { Http } from '@angular/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import { Recipe, RecipeService } from '../shared';
import { FormGroup, FormControl } from '@angular/forms';



@Component({
  selector: 'app-create-recipe-page',
  templateUrl: './create-recipe-page.component.html',
  styleUrls: ['./create-recipe-page.component.css']
})
export class CreateRecipePageComponent implements OnInit {

  title: string;
  cookingTime: number;
  preparationTime: number;
  description: string;
  note: string;

  constructor(private http: Http, private recipeService: RecipeService) { }

  ngOnInit() {
  }

  public submit() {
    let o = {
      "title": this.title, "cookingle": this.cookingTime, "preparation": this.preparationTime,
      "description": this.description, "note": this.note
    }

    let oo = {
      "title": "fffff", "description": "mlmlm", "note": "genre note"
    }
    //send form wit http channel
    debugger;
    this.broo(oo).subscribe((s) => {

      debugger;
      console.log("status" + s)

    });

    //clean
    // 1 ) fill model
    // 2 ) call service to persist data

    let recipe:Recipe;
    this.recipeService.save(recipe);

  }

  private broo(oo): Observable<any> {
    return this.http.post("/api/recipe/save", oo).map((res) => res.json())
  }

}
