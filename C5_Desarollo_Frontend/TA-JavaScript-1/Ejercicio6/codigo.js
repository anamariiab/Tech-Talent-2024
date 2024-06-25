const letras = [
  "T",
  "R",
  "W",
  "A",
  "G",
  "M",
  "Y",
  "F",
  "P",
  "D",
  "X",
  "B",
  "N",
  "J",
  "Z",
  "S",
  "Q",
  "V",
  "H",
  "L",
  "C",
  "K",
  "E",
  "T",
];

function validarDNI() {
  const numeroDNI = parseInt(document.getElementById("dniNumero").value);
  const letraProporcionada = document
    .getElementById("dniLetra")
    .value.toUpperCase();

  if (numeroDNI < 0 || numeroDNI > 99999999) {
    document.getElementById("resultado").innerText = "El número no es válido";
    return;
  }

  const resto = numeroDNI % 23;
  const letraCalculada = letras[resto];

  if (letraCalculada === letraProporcionada) {
    document.getElementById("resultado").innerText =
      "El número y la letra del DNI son correctos.";
  } else {
    document.getElementById("resultado").innerText = "La letra no es válida.";
  }
}
