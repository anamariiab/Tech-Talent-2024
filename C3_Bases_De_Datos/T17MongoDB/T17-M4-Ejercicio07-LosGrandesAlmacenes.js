use LosGrandesAlmacenes;

db.createCollection("cajeros")

db.cajeros.insertMany([
    { "codigo": 101, "nom_apels": "Pedro Picapiedra" },
    { "codigo": 102, "nom_apels": "Wilma Flinstone" },
    { "codigo": 103, "nom_apels": "Fred Flintstone" },
    { "codigo": 104, "nom_apels": "Barney Rubble" },
    { "codigo": 105, "nom_apels": "Betty Rubble" },
    { "codigo": 106, "nom_apels": "Popeye el Marino" },
    { "codigo": 107, "nom_apels": "Olivia Oyl" },
    { "codigo": 108, "nom_apels": "Bluto" },
    { "codigo": 109, "nom_apels": "Wimpy" },
    { "codigo": 110, "nom_apels": "Swee Pea" }
])

db.createCollection("productos")

db.productos.insertMany([
    { "codigo": 201, "nombre": "Camiseta de Goku Super Saiyajin", "precio": 19.99 },
    { "codigo": 202, "nombre": "Pantalones Cortos de Bart Simpson", "precio": 24.95 },
    { "codigo": 203, "nombre": "Zapatillas Luminosas", "precio": 29.99 },
    { "codigo": 204, "nombre": "Chaqueta de Vaquero con Hombreras", "precio": 39.99 },
    { "codigo": 205, "nombre": "Mochila 4D de Doraemon", "precio": 49.99 },
    { "codigo": 206, "nombre": "Libro de Instrucciones para la Vida (Edición Humorística)", "precio": 14.95 },
    { "codigo": 207, "nombre": "Película de Terror con Final Inesperado (o no)", "precio": 9.99 },
    { "codigo": 208, "nombre": "CD de Música Retro para Bailar sin Parar", "precio": 4.99 },
    { "codigo": 209, "nombre": "Juego de Mesa Monopoly Edición Springfield", "precio": 19.99 },
    { "codigo": 210, "nombre": "Muñeca Poseída (Edición Limitada)", "precio": 14.99 }
])

db.createCollection("maquinas_registradoras")

db.maquinas_registradoras.insertMany([
    { "codigo": 301, "piso": 1 },
    { "codigo": 302, "piso": 2 },
    { "codigo": 303, "piso": 3 },
    { "codigo": 304, "piso": 4 },
    { "codigo": 305, "piso": 5 },
    { "codigo": 306, "piso": 6 },
    { "codigo": 307, "piso": 7 },
    { "codigo": 308, "piso": 8 },
    { "codigo": 309, "piso": 9 },
    { "codigo": 310, "piso": 10 }
])

db.createCollection("venta")

db.venta.insertMany([
    { "cajero": 101, "maquina": 301, "producto": 201 },
    { "cajero": 102, "maquina": 302, "producto": 202 },
    { "cajero": 103, "maquina": 303, "producto": 203 },
    { "cajero": 104, "maquina": 304, "producto": 204 },
    { "cajero": 105, "maquina": 305, "producto": 205 },
    { "cajero": 106, "maquina": 306, "producto": 206 },
    { "cajero": 107, "maquina": 307, "producto": 207 },
    { "cajero": 108, "maquina": 308, "producto": 208 },
    { "cajero": 109, "maquina": 309, "producto": 209 },
    { "cajero": 110, "maquina": 310, "producto": 210 }
])

db.getCollectionNames();
db.maquinas_registradoras.find({ piso: 1 })
db.cajeros.update({ codigo: 101 }, { $set: { nom_apels: "Pedro Picapiedra López" } })
db.productos.deleteOne({ codigo: 201 })



