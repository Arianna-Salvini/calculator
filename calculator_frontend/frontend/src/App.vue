<template>
  <div class="calculator">
    <!-- Display numeratore e denominatore -->
    <div class="display">
      <p>{{ numerator || "Enter your operation" }} {{ operation || "" }} {{ denominator || "" }}</p>
      <p>{{ result || "" }}</p>
    </div>

    <!-- Operazioni sopra i numeri -->
    <div class="operations">
      <button @click="setOperation('+')">+</button>
      <button @click="setOperation('-')">-</button>
      <button @click="setOperation('*')">*</button>
      <button @click="setOperation('/')">/</button>
    </div>

    <!-- Tastiera numerica e pulsante uguale -->
    <div class="main">
      <!-- Tastiera numerica -->
      <div class="buttons">
        <div class="row">
          <button @click="appendNumber(1)">1</button>
          <button @click="appendNumber(2)">2</button>
          <button @click="appendNumber(3)">3</button>
        </div>
        <div class="row">
          <button @click="appendNumber(4)">4</button>
          <button @click="appendNumber(5)">5</button>
          <button @click="appendNumber(6)">6</button>
        </div>
        <div class="row">
          <button @click="appendNumber(7)">7</button>
          <button @click="appendNumber(8)">8</button>
          <button @click="appendNumber(9)">9</button>
        </div>
        <div class="row">
          <button @click="appendNumber(0)">0</button>

          <!-- Clear button -->
          <button class="clear" @click="clearInput">C</button>
        </div>
      </div>

      <!-- Pulsante uguale -->
      <div class="equal">
        <button @click="calculateResult">=</button>
      </div>

    </div>
  </div>
</template>

<script>

</script>

<style scoped>
.calculator {
  background-color: orange;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 15px;

  padding: 20px;
  font-family: Arial, sans-serif;
}

.display {
  min-height: 60px;
  width: 100%;
  background-color: #ddd;
  color: #000;
  border-radius: 15px;
  text-align: center;
  margin-bottom: 20px;

  p {
    font-size: 20px;
  }
}



.operations {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.operations button {
  width: 55px;
  height: 55px;
  /* Tondo per le operazioni */
  border-radius: 50%;
  font-size: 25px;
  padding: 5px;
  margin: 0 5px;
  cursor: pointer;
  border: 1px solid #8e8e8e;
}

.main {
  display: flex;
}

.buttons {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.row {
  display: flex;
  justify-content: center;
}

button {
  font-size: 20px;
  padding: 15px 20px;
  margin: 5px;
  cursor: pointer;
  border-radius: 50%;
  /* Pulsanti numerici tondi */
  border: 1px solid #8e8e8e;
}

button:hover {
  background-color: #cccccc;
}

/* Pulsante Clear con bordi arrotondati, non tondo */
.clear {
  width: 120px;
  border-radius: 30px;
  /* Solo arrotondato */
}

/* Pulsante Uguale con bordi arrotondati, non tondo */
.equal {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.equal button {
  width: 60px;
  height: 245px;
  font-size: 30px;
  border-radius: 30px;
  /* Solo arrotondato */
}

p {
  font-size: 18px;
  font-weight: bold;
}
</style>
