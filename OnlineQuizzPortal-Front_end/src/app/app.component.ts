import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'QuizzPortal';
  count=45;
  test={
    id:11,
    title:"test1",
    description:"predac test1",
    questions:10,
    marks:40
  };
  public onClick(){
    this.test.title="Button is pressed";
  }
}
