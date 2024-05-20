use Biblioteca;

db.createCollection('libros')

db.libros.insertOne({
    "ASIN": "8416310270",
    "Título": "La trena",
    "Fecha de lanzamiento": 2018,
    "Autor": "Laetitia Colombani",
    "Categoría": "Ficció",
    "Editorial": "Salamandra",
    "Idioma": "Català",
    "Páginas": 208,
    "Descripción": "Les històries de tres dones que, nascudes en continents diferents, comparteixen unes idees i uns sentiments que les uneixen en un poderós anhel de llibertat.",
    "Portada": "https://www.ejemplo.com/portadaLaTrena.jpg"
});