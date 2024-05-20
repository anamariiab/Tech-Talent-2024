use LosCientifificos;

db.createCollection("cientificos")

db.cientificos.insertMany([
    { DNI: 'X12345678', nom_apels: 'Johnny Bravo' },
    { DNI: 'Y23456789', nom_apels: 'Sherlock Holmes' },
    { DNI: 'X34567890', nom_apels: 'Daenerys Targaryen' },
    { DNI: 'Y45678901', nom_apels: 'Indiana Jones' },
    { DNI: 'X56789012', nom_apels: 'Walter White' },
    { DNI: 'Y67890123', nom_apels: 'Lara Croft' },
    { DNI: 'X78901234', nom_apels: 'Harry Potter' },
    { DNI: 'Y89012345', nom_apels: 'Ron Weasley' },
    { DNI: 'X90123456', nom_apels: 'Peter Parker' },
    { DNI: 'Y01234567', nom_apels: 'Jason Bourne' }
]);

db.createCollection("proyectos")

db.proyectos.insertMany([
    { ID: 'PR01', nombre: 'TechTalent', horas: 600 },
    { ID: 'PR02', nombre: 'Los Detectives de Depuración', horas: 200 },
    { ID: 'PR03', nombre: 'Los Desenredadores de Código Espagueti', horas: 150 },
    { ID: 'PR04', nombre: 'El Snob de la Sintaxis', horas: 320 },
    { ID: 'PR05', nombre: 'La Búsqueda y Destrucción de Bugs', horas: 100 },
    { ID: 'PR06', nombre: 'El Wifi Gratis de Mordor', horas: 400 },
    { ID: 'PR07', nombre: 'El Doctor Doom del Spam', horas: 700 },
    { ID: 'PR08', nombre: 'La Clínica de Computadoras Enfermas', horas: 600 },
    { ID: 'PR09', nombre: 'La Fábrica de Aplicaciones Mágicas', horas: 500 },
    { ID: 'PR10', nombre: 'Los Maestros del Código Ninja', horas: 700 }
]);

db.createCollection("asignado_a")

db.asignado_a.insertMany([
    { cientifico: 'X12345678', proyecto: 'PR01' },
    { cientifico: 'Y23456789', proyecto: 'PR02' },
    { cientifico: 'X34567890', proyecto: 'PR03' },
    { cientifico: 'Y45678901', proyecto: 'PR04' },
    { cientifico: 'X56789012', proyecto: 'PR05' },
    { cientifico: 'Y67890123', proyecto: 'PR06' },
    { cientifico: 'X78901234', proyecto: 'PR07' },
    { cientifico: 'Y89012345', proyecto: 'PR08' },
    { cientifico: 'X90123456', proyecto: 'PR09' },
    { cientifico: 'Y01234567', proyecto: 'PR10' }
]);

db.getCollectionNames();
db.proyectos.find({});
db.proyectos.updateOne({ ID: 'PR02' }, { $inc: { horas: 50 } });
db.cientificos.deleteOne({ DNI: 'X12345678' });