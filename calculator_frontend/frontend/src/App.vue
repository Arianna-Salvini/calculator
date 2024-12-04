<template>
  <div class="calculator">
    <!-- Display for numerator and denominator and result -->
    <p>{{ numerator || "Enter your operation" }} {{ operator || "" }} {{ denominator || "" }}</p>
    <p>{{ result || "" }}</p>
  </div>

  <!-- If you click on a numeric operator move from numeratore to denominator -->

  <div class="operators">
    <button @="setOperation('+')">+</button>
    <button @="setOperation('-')">-</button>
    <button @="setOperation('*')">*</button>
    <button @="setOperation('/')">/</button>
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
      </div>ù
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

      <!-- Equal button-->
      <div class="equal">
        <button @click="calculateResult">=</button>
      </div>

    </div>

  </div>

</template>

<script>

</script>

<style scoped>
/* Calculator */
.calculator {
  background-color: orange;
  border-radius: 15px;
  padding: 20px;
  font-family: Arial, Helvetica, sans-serif;

  display: flex;
  flex-direction: column;
  align-items: center;
}

.display {
  width: 100%;
  min-height: 60px;
  background-color: #ddd;
  color: #000;
  text-align: center;
  border-radius: 15px;
  margin-bottom: 20px;

  p {
    font-size: 20px;
  }
}

/* buttons */

.operators {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

buttons .operators {
  width: 55px;
  height: 55px;
  font-size: 25px;
  border: 1px solid #8e8e8e;
  border-radius: 50%;
  padding: 5px;
  margin: 5px;
  cursor: pointer;
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
    cursor: pointer;
  }

  button:hover {
    background-color: #cccccc;
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
