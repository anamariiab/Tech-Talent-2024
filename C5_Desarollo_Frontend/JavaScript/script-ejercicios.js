// Ejercicio 1
var numero = 50;
document.getElementById("ejer1").innerText = numero;

// Ejercicio 2
var cMS = "WordPress";
document.getElementById("cms1").innerText = cMS;

//Ejercicio 3
var temperatura = "Frio";
document.getElementById("temp").innerText = temperatura;

//Ejercicio4
var x = 2;
var y = 3;
var suma = x + y;
document.getElementById("suma").innerText = suma;

//Ejercicio5
var x = 2;
var y = 3;
var z = 10;
var suma2 = x + y + z;
document.getElementById("suma2").innerText = suma2;

//Ejercicio6
var nombre = "Cristina",
  apellido = "García",
  edad = 39;
document.getElementById("persona").innerHTML =
  nombre + " " + apellido + " tiene " + edad + " años";

//Ejercicio7
var x = 1;
var y = 6; //habia comillas en 6
var suma = x + y;
document.getElementById("suma3").innerText = suma;

//Ejercicio8
var x = 60;
var resultado = x / 3;
document.getElementById("division").innerText = resultado;

//Ejercicio9
var x = 6;
var y = 9; //habia comillas en 6
var mult = x * y;
document.getElementById("multiplicacion").innerText = mult;

//Ejercicio11
function saluda() {
  document.getElementById("demo").innerHTML = "Hola Mundo";
}
document.getElementById("miBoton").onclick = saluda;

//Ejercicio12
