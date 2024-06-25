function mostrar() {
  let cadena = document.getElementById("inputText").value;
  let resultado = document.getElementById("resultado");

  if (cadena === cadena.toUpperCase()) {
    resultado.textContent = "La cadena solo tiene mayúsculas.";
  } else if (cadena === cadena.toLowerCase()) {
    resultado.textContent = "La cadena solo tiene minúsculas.";
  } else {
    resultado.textContent =
      "La cadena está formada por una mezcla de mayúsculas y minúsculas.";
  }
}
