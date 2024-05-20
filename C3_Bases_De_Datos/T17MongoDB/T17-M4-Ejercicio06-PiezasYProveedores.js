use PiezasYProveedores;

db.createCollection("piezas")

db.piezas.insertMany([
    { codigo: 1, nombre: "Tornillo" },
    { codigo: 2, nombre: "Arandela" },
    { codigo: 3, nombre: "Tuerca" },
    { codigo: 4, nombre: "Martillo" },
    { codigo: 5, nombre: "Destornillador" },
    { codigo: 6, nombre: "Llave inglesa" },
    { codigo: 7, nombre: "Sierra" },
    { codigo: 8, nombre: "Taladro" },
    { codigo: 9, nombre: "Amoladora" },
    { codigo: 10, nombre: "Lijadora" }
])

db.createCollection("proveedores")

db.proveedores.insertMany([
    { ID: "PR01", nombre: "Llaves Maestras" },
    { ID: "PR02", nombre: "Manitas Express" },
    { ID: "PR03", nombre: "El Clavo" },
    { ID: "PR04", nombre: "Hierros y Herramientas" },
    { ID: "PR05", nombre: "Star Wars: Ferretería Espacial" },
    { ID: "PR06", nombre: "Harry Potter y la Tienda de Magia y Herramientas" },
    { ID: "PR07", nombre: "El Señor de los Tornillos" },
    { ID: "PR08", nombre: "El Rincón del Bricolaje" },
    { ID: "PR09", nombre: "Destornilladores Sonrientes" },
    { ID: "PR10", nombre: "Herramientas para Dummies" }
])

db.createCollection("suministra")

db.suministra.insertMany([
    { "codigo_pieza": 1, "ID_proveedor": "PR01", "precio": 0.50 },
    { "codigo_pieza": 2, "ID_proveedor": "PR02", "precio": 0.90 },
    { "codigo_pieza": 3, "ID_proveedor": "PR03", "precio": 1.30 },
    { "codigo_pieza": 4, "ID_proveedor": "PR04", "precio": 10.00 },
    { "codigo_pieza": 5, "ID_proveedor": "PR05", "precio": 5.00 },
    { "codigo_pieza": 6, "ID_proveedor": "PR06", "precio": 15.75 },
    { "codigo_pieza": 7, "ID_proveedor": "PR07", "precio": 20.00 },
    { "codigo_pieza": 8, "ID_proveedor": "PR08", "precio": 33.25 },
    { "codigo_pieza": 9, "ID_proveedor": "PR09", "precio": 41.15 },
    { "codigo_pieza": 10, "ID_proveedor": "PR10", "precio": 53.25 }
])

db.getCollectionNames();
db.piezas.findOne({ codigo: 1 })
db.piezas.update({ codigo: 1 }, { $set: { nombre: "Tornillo hexagonal" } })
db.proveedores.deleteOne({ ID: "PR01" })


