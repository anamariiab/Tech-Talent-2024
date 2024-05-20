use LosInvestigadores;

db.createCollection("facultades")

db.facultades.insertMany([
    { codigo: 1, nombre: "Facultad de Informática" },
    { codigo: 2, nombre: "Facultad de Ingeniería" },
    { codigo: 3, nombre: "Facultad de Ciencias de la Salud" },
    { codigo: 4, nombre: "Facultad de Ciencias Sociales y Humanas" },
    { codigo: 5, nombre: "Facultad de Educación" },
    { codigo: 6, nombre: "Facultad de Derecho" },
    { codigo: 7, nombre: "Facultad de Economía y Empresa" },
    { codigo: 8, nombre: "Facultad de Bellas Artes" },
    { codigo: 9, nombre: "Facultad de Ciencias del Deporte" },
    { codigo: 10, nombre: "Facultad de Ciencias Políticas" }
])


db.createCollection("investigadores")

db.investigadores.insertMany([
    { DNI: "Z12345678", nom_apels: "Juan Pérez López", facultad: 10 },
    { DNI: "X87654321", nom_apels: "María Gómez García", facultad: 9 },
    { DNI: "Z38765432", nom_apels: "Pedro Sánchez Rodríguez", facultad: 8 },
    { DNI: "X43210987", nom_apels: "Ana Martínez Fernández", facultad: 7 },
    { DNI: "Z54321098", nom_apels: "José González Díaz", facultad: 6 },
    { DNI: "X65432109", nom_apels: "Isabel López Ruiz", facultad: 5 },
    { DNI: "Z76543210", nom_apels: "David García Martínez", facultad: 4 },
    { DNI: "X87654323", nom_apels: "Laura Fernández González", facultad: 3 },
    { DNI: "Z98765433", nom_apels: "Carlos Díaz López", facultad: 2 },
    { DNI: "X10987654", nom_apels: "Cristina Ruiz García", facultad: 1 }
])


db.createCollection("equipos")

db.equipos.insertMany([
    { num_serie: "1001", nombre: "Equipo 1", facultad: 1 },
    { num_serie: "1002", nombre: "Equipo 2", facultad: 2 },
    { num_serie: "1003", nombre: "Equipo 3", facultad: 3 },
    { num_serie: "1004", nombre: "Equipo 4", facultad: 4 },
    { num_serie: "1005", nombre: "Equipo 5", facultad: 5 },
    { num_serie: "1006", nombre: "Equipo 6", facultad: 6 },
    { num_serie: "1007", nombre: "Equipo 7", facultad: 7 },
    { num_serie: "1008", nombre: "Equipo 8", facultad: 8 },
    { num_serie: "1009", nombre: "Equipo 9", facultad: 9 },
    { num_serie: "1010", nombre: "Equipo 10", facultad: 10 }
])

db.createCollection("reservas")

db.reservas.insertMany([
    { "DNI": "Z12345678", "num_serie": "1001", "comienzo": new Date("2024-04-17"), "fin": new Date("2024-04-20") },
    { "DNI": "X87654321", "num_serie": "1002", "comienzo": new Date("2024-04-18"), "fin": new Date("2024-04-21") },
    { "DNI": "Z38765432", "num_serie": "1003", "comienzo": new Date("2024-04-19"), "fin": new Date("2024-04-22") },
    { "DNI": "X43210987", "num_serie": "1004", "comienzo": new Date("2024-04-20"), "fin": new Date("2024-04-23") },
    { "DNI": "Z54321098", "num_serie": "1005", "comienzo": new Date("2024-04-21"), "fin": new Date("2024-04-24") },
    { "DNI": "X65432109", "num_serie": "1006", "comienzo": new Date("2024-04-22"), "fin": new Date("2024-04-25") },
    { "DNI": "Z76543210", "num_serie": "1007", "comienzo": new Date("2024-04-23"), "fin": new Date("2024-04-26") },
    { "DNI": "X87654323", "num_serie": "1008", "comienzo": new Date("2024-04-24"), "fin": new Date("2024-04-27") },
    { "DNI": "Z98765433", "num_serie": "1009", "comienzo": new Date("2024-04-25"), "fin": new Date("2024-04-28") },
    { "DNI": "X10987654", "num_serie": "1010", "comienzo": new Date("2024-04-26"), "fin": new Date("2024-04-29") }
])

db.getCollectionNames();
db.investigadores.find({ facultad: 1 })
db.investigadores.updateOne({ DNI: "Z12345678" }, { $set: { nom_apels: "Otro Nombre" } })
db.equipos.deleteOne({ num_serie: '1001' }); 
