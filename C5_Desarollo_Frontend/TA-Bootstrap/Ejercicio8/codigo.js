const expressionDisplay = document.getElementById("expression");
const resultDisplay = document.getElementById("result");
const buttons = document.querySelectorAll(".buttons button");
const operators = document.querySelectorAll(".operators button");
let displayValue = "";
let resultValue = "";

function updateDisplay() {
  expressionDisplay.textContent = displayValue;
  resultDisplay.textContent = resultValue || "0";
}

buttons.forEach((button) => {
  button.addEventListener("click", () => {
    if (button.textContent === "DEL") {
      displayValue = "";
      resultValue = "";
    } else if (button.textContent === "=") {
      try {
        resultValue = eval(displayValue.replace("X", "*"));
      } catch {
        resultValue = "Error";
      }
    } else {
      displayValue += button.textContent;
    }
    updateDisplay();
  });
});

operators.forEach((operator) => {
  operator.addEventListener("click", () => {
    if (operator.textContent === "DEL") {
      displayValue = "";
      resultValue = "";
    } else if (operator.textContent === "=") {
      try {
        resultValue = eval(displayValue.replace("X", "*"));
      } catch {
        resultValue = "Error";
      }
    } else {
      displayValue += operator.textContent;
    }
    updateDisplay();
  });
});
