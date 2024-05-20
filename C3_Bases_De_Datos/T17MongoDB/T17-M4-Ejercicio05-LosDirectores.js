use LosDirectores;

db.createCollection("despachos")

db.despachos.insertMany([
  { numero: 1, capacidad: 11 },
  { numero: 2, capacidad: 8 },
  { numero: 3, capacidad: 3 },
  { numero: 4, capacidad: 5 },
  { numero: 5, capacidad: 14 },
  { numero: 6, capacidad: 22 },
  { numero: 7, capacidad: 21 },
  { numero: 8, capacidad: 5 },
  { numero: 9, capacidad: 19 },
  { numero: 10, capacidad: 23 }
])

db.createCollection("directores")

db.directores.insertMany([
  { DNI: "12345678", nom_apels: "Juan Pérez López", DNI_jefe: null, despacho: 1 },
  { DNI: "87654321", nom_apels: "María Gómez Rodríguez", DNI_jefe: null, despacho: 2 },
  { DNI: "98765432", nom_apels: "Pedro Sánchez Martínez", DNI_jefe: null, despacho: 3 },
  { DNI: "43210987", nom_apels: "Ana Martín García", DNI_jefe: "12345678", despacho: 4 },
  { DNI: "56789012", nom_apels: "José López Fernández", DNI_jefe: "87654321", despacho: 5 },
  { DNI: "21098765", nom_apels: "Isabel González Pérez", DNI_jefe: "98765432", despacho: 6 },
  { DNI: "32109876", nom_apels: "David García Martínez", DNI_jefe: "43210987", despacho: 7 },
  { DNI: "43215678", nom_apels: "Laura Fernández Gómez", DNI_jefe: "56789012", despacho: 8 },
  { DNI: "54326789", nom_apels: "Carlos Pérez López", DNI_jefe: "21098765", despacho: 9 },
  { DNI: "65437890", nom_apels: "Marta González Rodríguez", DNI_jefe: "32109876", despacho: 10 }
])

db.getCollectionNames();
db.directores.find({ DNI_jefe: { $ne: null } })
db.directores.update({ DNI: "12345678" }, { $set: { nom_apels: "Juan Pérez García" } })
db.despachos.deleteOne({ numero: 1 })


