<template>
  <div class="calculator">
    <!-- Display for numerator and denominator and result -->
    <!-- TEMPORANEAMENTE METTO CAMPI STATICI -->
    <div class="display">
      <!-- <p>Numerator + Denominator</p>
      <p>Result</p> -->
      <p>{{ numerator || "Enter your operation" }} {{ operator || "" }} {{ denominator || "" }}</p>
      <p>{{ result || "" }}</p>
    </div>

    <!-- If you click on a numeric operator move from numeratore to denominator -->

    <div class="operator">
      <button @click="setOperation('+')">+</button>
      <button @click="setOperation('-')">-</button>
      <button @click="setOperation('*')">*</button>
      <button @click="setOperation('/')">/</button>
    </div>

    <!-- Numeric keybord and equal button -->
    <div class="numeric_keybord">
      <!-- Numeric keybord -->
      <div class="button">

        <!-- Numbers 1 to 3 -->
        <div class="row">
          <button @click="appendNumber(1)">1</button>
          <button @click="appendNumber(2)">2</button>
          <button @click="appendNumber(3)">3</button>
        </div>

        <!-- Numbers 4 to 6 -->
        <div class="row">
          <button @click="appendNumber(4)">4</button>
          <button @click="appendNumber(5)">5</button>
          <button @click="appendNumber(6)">6</button>
        </div>
        <!-- Numbers 7 to 9 -->
        <div class="row">
          <button @click="appendNumber(7)">7</button>
          <button @click="appendNumber(8)">8</button>
          <button @click="appendNumber(9)">9</button>
        </div>

        <!-- Numbers 0 and clear button -->
        <div class="row">
          <button @click="appendNumber(0)">0</button>

          <!-- C clear button -->
          <button class="clear" @click="clearInput">C</button>
        </div>

      </div>

      <!-- Equal button-->
      <div class="equal">
        <button @click="calculateResult">=</button>
      </div>

    </div>

  </div>

</template>

<script>

import axios from 'axios';

export default {
  data() {
    return {
      numerator: "",
      denominator: "",
      operator: "",
      result: null,

      // Define active field 
      currentField: "numerator"
    };
  },

  methods: {
    // Add number to current field
    appendNumber(number) {
      if (this.currentField === "numerator") {
        this.numerator += number;
      } else {
        this.denominator += number;
      }
    },

    //  Set selected operator for operation
    setOperation(operator) {
      this.operator = operator;

      // Pass to next field (denominator)
      this.currentField = "denominator";
    },

    //Set clear button; reset all field and restart

    clearInput() {
      this.numerator = "";
      this.operator = "";
      this.denominator = "";
      this.result = null;
      this.currentField = "numerator"
    },

    //Calculating result RESULT; url built and axios call

    calculateResult() {

      let urlBase = "http://localhost:8080/api/calculator/";
      let url = "";
      // define operation to do to coombine the correct url

      switch (this.operator) {
        case "+":
          url = `${urlBase}sum?a=${this.numerator}&b=${this.denominator}`;
          break;
        case "-":
          url = `${urlBase}sub?a=${this.numerator}&b=${this.denominator}`;
          break;
        case "*":
          url = `${urlBase}multiply?a=${this.numerator}&b=${this.denominator}`;
          break;
        case "/":
          url = `${urlBase}div?a=${this.numerator}&b=${this.denominator}`;
          break;
        default:
          return;
      }
      console.log(url);

      axios.get(url)
        .then((response) => {
          this.result = response.data;
          console.log(this.result);
        })
        .catch((error) => {
          console.error("Error", error.message);
        });

    }
  }
}
</script>

<style scoped>
/* Calculator */
.calculator {
  background-color: orange;
  border-radius: 15px;
  padding: 20px;
  font-family: Arial, Helvetica, sans-serif;
  box-shadow: 10px 15px 12px #000;

  display: flex;
  flex-direction: column;
}

.display {
  width: 100%;
  min-height: 120px;
  background-color: #ddd;
  color: #000;
  text-align: center;
  border-radius: 15px;
  margin-bottom: 20px;
  box-shadow: 3px 3px 5px inset #8e8e8e;

  p {
    font-size: 18px;
  }
}

/* buttons */

.operator {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;

  >button {
    width: 55px;
    height: 55px;
    font-size: 25px;
    border: 1px solid #8e8e8e;
    border-radius: 50%;
    padding: 5px;
    margin: 5px;
    box-shadow: 1px 2px 3px;
    cursor: pointer;

  }
}

.operator button:hover {
  background-color: #cccccc;
  box-shadow: 1px 2px 3px inset #000;
}

/* numeric_keybord */

.numeric_keybord {
  display: flex;

  .buttons {
    display: flex;
    flex-direction: column;
    align-items: center;

    .row {
      display: flex;
      align-items: center;
    }
  }

  button {
    font-size: 20px;
    padding: 15px 20px;
    margin: 5px;
    border: 1px solid #8e8e8e;
    border-radius: 50%;
    box-shadow: 1px 2px 3px;

    cursor: pointer;
  }

  button:hover {
    background-color: #cccccc;
    box-shadow: 1px 2px 3px inset #000;
  }

  /* ClearButton */

  .clear {
    width: 120px;
    border-radius: 30px;
  }

  /* Equals Button */
  .equal {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    >button {
      width: 60px;
      height: 245px;
      font-size: 30px;
      border-radius: 30px;

      p {
        font-size: 18px;
        font-weight: bold;
      }
    }
  }

}
</style>
