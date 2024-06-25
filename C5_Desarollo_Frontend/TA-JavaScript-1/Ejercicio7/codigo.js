let factorial = 1;

function calcularFactorial(n) {
  let factorial = 1;
  for (let i = 1; i <= n; i++) {
    factorial *= i;
  }
  return factorial;
}

let numero = 5;
let resultado = calcularFactorial(numero);
document.getElementById("resultado").innerText =
  "El factorial de " + numero + " es " + resultado;
