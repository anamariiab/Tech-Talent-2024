use LosAlmacenes;

db.createCollection("almacenes")

db.almacenes.insertMany([
    { codigo: 1, nombre: "Almacén A", lugar: "Reus", capacidad: 2 },
    { codigo: 2, nombre: "Almacén B", lugar: "Tarragona", capacidad: 5 },
    { codigo: 3, nombre: "Almacén C", lugar: "Salou", capacidad: 3 },
    { codigo: 4, nombre: "Almacén D", lugar: "Cambrils", capacidad: 10 },
    { codigo: 5, nombre: "Almacén E", lugar: "La Selva Del Camp", capacidad: 15 },
    { codigo: 6, nombre: "Almacén F", lugar: "Riudoms", capacidad: 17 },
    { codigo: 7, nombre: "Almacén G", lugar: "Valls", capacidad: 20 },
    { codigo: 8, nombre: "Almacén H", lugar: "Siurana", capacidad: 30 },
    { codigo: 9, nombre: "Almacén I", lugar: "Lleida", capacidad: 6 },
    { codigo: 10, nombre: "Almacén J", lugar: "Sitges", capacidad: 7 }
])

db.createCollection("cajas")

db.cajas.insertMany([
    { num_ref: "CA001", contenido: "Libros", valor: 50.50, almacen: 1 },
    { num_ref: "CA002", contenido: "Electrodomésticos", valor: 980, almacen: 1 },
    { num_ref: "CA003", contenido: "Ropa", valor: 110.70, almacen: 3 },
    { num_ref: "CA004", contenido: "Herramientas", valor: 120, almacen: 4 },
    { num_ref: "CA005", contenido: "Juguetes", valor: 40.70, almacen: 5 },
    { num_ref: "CA006", contenido: "Joyería", valor: 1250, almacen: 1 },
    { num_ref: "CA007", contenido: "Material de jardinería", valor: 330, almacen: 7 },
    { num_ref: "CA008", contenido: "Equipos de deporte", valor: 110, almacen: 8 },
    { num_ref: "CA009", contenido: "Material de oficina", valor: 60, almacen: 9 },
    { num_ref: "CA010", contenido: "Instrumentos musicales", valor: 150, almacen: 10 }
])

db.getCollectionNames();
db.almacenes.find({ lugar: "Reus" })
db.almacenes.update({ codigo: 1 }, { $set: { capacidad: 3 } })
db.cajas.deleteOne({ num_ref: "CA001" }) 