@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  decimalNumber: number;
  binaryArray: number[] = [0, 0, 0, 0, 0, 0, 0, 0];

  constructor() {
    this.decimalNumber = 0;
  }

  updateBinaryArray() {
    this.binaryArray = this.decimalNumber
      .toString(2)
      .padStart(8, '0')
      .split('')
      .map(char => +char);
  }

  updateDecimalNumber() {
    this.decimalNumber = parseInt(this.binaryArray.join(''), 2);
  }
}
import { Component } from '@angular/core';
