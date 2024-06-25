// 1
let valores = [true, 5, false, "hola", "adios", 2];
let textoMayor = valores[3] > valores[4] ? valores[3] : valores[4];
document.getElementById("1").innerText = textoMayor;

// 2
let trueR = valores[0] || valores[2];
let falseR = valores[0] && valores[2];

document.getElementById("2.1").innerText = trueR;
document.getElementById("2.2").innerText = falseR;

// 3
let num1 = valores[1];
let num2 = valores[5];

let suma = num1 + num2;
let resta = num1 - num2;
let multiplicacion = num1 * num2;
let division = num1 / num2;
let modulo = num1 % num2;

let resultados = [
  "Suma: " + suma,
  "Resta: " + resta,
  "Multiplicación: " + multiplicacion,
  "División: " + division,
  "Módulo: " + modulo,
];
document.getElementById("3").innerText = resultados;
