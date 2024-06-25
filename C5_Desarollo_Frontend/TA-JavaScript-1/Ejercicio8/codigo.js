function parImpar(n) {
  if (n % 2 === 0) {
    return n + " es un número par.";
  } else {
    return n + "es un número impar.";
  }
}

let numero = 8;
let resultado = parImpar(numero);
document.getElementById("resultado").innerText = "El " + resultado;
