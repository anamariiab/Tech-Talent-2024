use LaTiendaDeInformatica;

db.createCollection("fabricantes");

db.fabricantes.insertMany([
    { codigo: 1, nombre: "TechnoMágico Inc." },
    { codigo: 2, nombre: "ByteFiesta S.A." },
    { codigo: 3, nombre: "ElectroLúdico Ltda." },
    { codigo: 4, nombre: "ChipChirimbolo Corp." },
    { codigo: 5, nombre: "RoboRisas Enterprises" },
    { codigo: 6, nombre: "CódigoChispa GmbH" },
    { codigo: 7, nombre: "PixelPachanga & Co." },
    { codigo: 8, nombre: "InfoTravesura SRL" },
    { codigo: 9, nombre: "DataDiversión SL" },
    { codigo: 10, nombre: "GadgetGiggle Ltd." }
])

db.createCollection("articulos")

db.articulos.insertMany([
    { codigo: 1, nombre: "Portátil Mágico", precio: 999.99, fabricante: { codigo: 1, nombre: "TechnoMágico Inc." } },
    { codigo: 2, nombre: "Ratón Risueño", precio: 10.99, fabricante: { codigo: 1, nombre: "TechnoMágico Inc." } },
    { codigo: 3, nombre: "Teclado Invisible", precio: 20.50, fabricante: { codigo: 2, nombre: "ByteFiesta S.A." } },
    { codigo: 4, nombre: "Auriculares Alienígenas", precio: 15.75, fabricante: { codigo: 2, nombre: "ByteFiesta S.A." } },
    { codigo: 5, nombre: "Monitor Mágico", precio: 299.99, fabricante: { codigo: 3, nombre: "ElectroLúdico Ltda." } },
    { codigo: 6, nombre: "Disco Duro Dragón", precio: 99.99, fabricante: { codigo: 4, nombre: "ChipChirimbolo Corp." } },
    { codigo: 7, nombre: "Teclado Tornado Turbo", precio: 79.95, fabricante: { codigo: 5, nombre: "RoboRisas Enterprises" } },
    { codigo: 8, nombre: "Disco Diversión", precio: 89.99, fabricante: { codigo: 6, nombre: "CódigoChispa GmbH" } },
    { codigo: 9, nombre: "Altavoz Asombroso", precio: 29.99, fabricante: { codigo: 7, nombre: "PixelPachanga & Co." } },
    { codigo: 10, nombre: "Impresora Ilusión", precio: 249.99, fabricante: { codigo: 8, nombre: "InfoTravesura SRL" } }
])

db.getCollectionNames();
db.articulos.find({ precio: { $lt: 100 } });
db.fabricantes.updateOne({ codigo: 1 }, { $set: { nombre: "TechnoMágico Innovations" } });
db.articulos.deleteOne({ codigo: 3 });

