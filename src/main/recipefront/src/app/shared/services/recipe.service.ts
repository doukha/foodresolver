import { Http } from '@angular/http';
import { Recipe } from '../model'
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';


@Injectable()
export class RecipeService {

    constructor(private http: Http) {
    }

    save(recipe: Recipe): Observable<any> {
        return this.http.post("/api/recipe/save", recipe)
            .map(
            (res) => {
                // console.log(res.text());
                // console.log("JSON" + JSON.parse(res.text()));
                return res => JSON.parse(res.text())
            }
            )
    }


}