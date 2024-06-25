function esPalindromo(texto) {
  texto = texto.toLowerCase().replaceAll(" ", "").replaceAll("ó", "o");

  for (let i = 0, j = texto.length - 1; i < j; i++, j--) {
    if (texto[i] !== texto[j]) {
      return false;
    }
  }

  return true;
}

let frase = "La ruta nos aportó otro paso natural";
let resultado = esPalindromo(frase);
document.getElementById("resultado").innerText = resultado
  ? "La cadena es un palíndromo."
  : "La cadena no es un palíndromo.";
