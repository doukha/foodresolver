import { Http } from '@angular/http';
import { Recipe } from '../model'
import { Observable } from 'rxjs/Rx';


export class RecipeService {

    constructor(private http: Http) {
    }

    save(recipe: Recipe): Observable<any> {
        return this.http.post("/api/recipe/save", recipe).map((res) => res.json())
    }


}