import { Observable } from 'rxjs/Rx';


var source1 = Observable.interval(100)
    .map(function (i) { return 'First: ' + i; });

var source2 = Observable.interval(150)
    .map(function (i) { return 'Second: ' + i; });

// Combine latest of source1 and source2 whenever either gives a value
var source = source1.startWith(
        "source2","ff"
       
    ).take(9);           

var subscription = source.subscribe(
    function (x) {
        console.log('Next: ' + x.toString());
    },
    function (err) {
        console.log('Error: ' + err);
    },
    function () {
        console.log('Completed');
    });
