use Empleados;

db.createCollection("departamentos")

db.departamentos.insertMany([
    { codigo: 1, nombre: "Management", presupuesto: 50000 },
    { codigo: 2, nombre: "Marketing", presupuesto: 60000 },
    { codigo: 3, nombre: "Producción", presupuesto: 80000 },
    { codigo: 4, nombre: "Recursos Humanos", presupuesto: 45000 },
    { codigo: 5, nombre: "Finanzas", presupuesto: 70000 },
    { codigo: 6, nombre: "Operaciones", presupuesto: 55000 },
    { codigo: 7, nombre: "Servicio al Cliente", presupuesto: 60000 },
    { codigo: 8, nombre: "Ventas", presupuesto: 55000 },
    { codigo: 9, nombre: "Logística", presupuesto: 65000 },
    { codigo: 10, nombre: "Legal", presupuesto: 90000 }
])

db.createCollection("empleados")

db.empleados.insertMany([
    { DNI: "X23456789", nombre: "Juan", apellidos: "García Pérez", departamento: 3 },
    { DNI: "Z87654321", nombre: "María", apellidos: "López Martínez", departamento: 7 },
    { DNI: "X56123789", nombre: "Carlos", apellidos: "González Sánchez", departamento: 1 },
    { DNI: "Z89123456", nombre: "Laura", apellidos: "Rodríguez Fernández", departamento: 5 },
    { DNI: "X21654987", nombre: "Pedro", apellidos: "Martín Gómez", departamento: 2 },
    { DNI: "Z54987321", nombre: "Ana", apellidos: "Díaz Ruiz", departamento: 8 },
    { DNI: "X47258369", nombre: "David", apellidos: "Hernández López", departamento: 8 },
    { DNI: "Z58369147", nombre: "Sara", apellidos: "Pérez García", departamento: 8 },
    { DNI: "X69147258", nombre: "Pablo", apellidos: "Fernández Rodríguez", departamento: 9 },
    { DNI: "Z87123654", nombre: "Elena", apellidos: "Sánchez Martínez", departamento: 10 }
])

db.getCollectionNames();
db.empleados.find({ departamento: 8 })
db.departamentos.update({ codigo: 1 }, { $set: { presupuesto: 55000 } })
db.empleados.deleteOne({ DNI: "X23456789" })




