use PeliculasYSalas;

db.createCollection("peliculas")
db.peliculas.insertMany([
    { codigo: 100, nombre: "Pobres Criaturas", calificacion_edad: 12 },
    { codigo: 101, nombre: "Oppenheimer", calificacion_edad: 12 },
    { codigo: 102, nombre: "Dune: Parte Dos", calificacion_edad: 5 },
    { codigo: 103, nombre: "Guardiana de Dragones", calificacion_edad: 8 },
    { codigo: 104, nombre: "Kung Fu Panda 4", calificacion_edad: 5 },
    { codigo: 105, nombre: "Civil War", calificacion_edad: 16 },
    { codigo: 106, nombre: "Abigail", calificacion_edad: 16 },
    { codigo: 107, nombre: "Garfield", calificacion_edad: 5 },
    { codigo: 108, nombre: "Amigos Imaginarios", calificacion_edad: 12 },
    { codigo: 109, nombre: "El Reino del Planeta de los Simios", calificacion_edad: 12 }
])

db.createCollection("salas")
db.salas.insertMany([
    { codigo: 1, nombre: "Sala 1", pelicula: 100 },
    { codigo: 2, nombre: "Sala 2", pelicula: 101 },
    { codigo: 3, nombre: "Sala 3", pelicula: 102 },
    { codigo: 4, nombre: "Sala 4", pelicula: 103 },
    { codigo: 5, nombre: "Sala 5", pelicula: 104 },
    { codigo: 6, nombre: "Sala 6", pelicula: 105 },
    { codigo: 7, nombre: "Sala 7", pelicula: 106 },
    { codigo: 8, nombre: "Sala 8", pelicula: 107 },
    { codigo: 9, nombre: "Sala 9", pelicula: 108 },
    { codigo: 10, nombre: "Sala 10", pelicula: 109 }
])

db.getCollectionNames();
db.peliculas.find({ calificacion_edad: 12 })
db.salas.update({ codigo: 1 }, { $set: { nombre: "Sala VIP" } })
db.peliculas.deleteOne({ codigo: 100 }) 
