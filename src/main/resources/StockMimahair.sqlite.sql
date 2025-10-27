BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "productos" (
	"id"	INTEGER NOT NULL UNIQUE,
	"nombre_prod"	TEXT NOT NULL,
	"marca_prod"	TEXT NOT NULL,
	"categoria_prod"	TEXT NOT NULL,
	"precio_prod"	REAL NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "clientes" (
	"id"	INTEGER NOT NULL UNIQUE,
	"nombre_cliente"	TEXT NOT NULL,
	"apellidos_cliente"	TEXT NOT NULL,
	"tlf_cliente"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "proveedores" (
	"id"	INTEGER NOT NULL UNIQUE,
	"nom_proveedor"	TEXT NOT NULL,
	"apellidos_proveedor"	TEXT NOT NULL,
	"localidad_proveedor"	TEXT NOT NULL,
	"tlf_proveedor"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "productos" VALUES (2,'Shampoo reparador','L’Oréal Professionnel','Cuidado capilar',18.5);
INSERT INTO "productos" VALUES (3,'Acondicionador hidratante','Pantene','Cuidado capilar',15.75);
INSERT INTO "productos" VALUES (4,'Tinte permanente rubio ceniza','Wella Koleston','Coloración',22.9);
INSERT INTO "productos" VALUES (5,'Cera para peinar','Schwarzkopf','Styling',12.3);
INSERT INTO "productos" VALUES (6,'Secador de cabello iónico','Remington','Herramientas eléctricas',59.99);
INSERT INTO "clientes" VALUES (1,'Laura','Martínez Gómez','611234567');
INSERT INTO "clientes" VALUES (2,'Carlos','Ruiz Fernández','622345678');
INSERT INTO "clientes" VALUES (3,'Marta','López García','633456789');
INSERT INTO "clientes" VALUES (4,'Javier','Sánchez Pérez','644567890');
INSERT INTO "clientes" VALUES (5,'Lucía','Navarro Torres','655678901');
INSERT INTO "proveedores" VALUES (1,'Sofía','Herrera Díaz','Madrid','911223344');
INSERT INTO "proveedores" VALUES (2,'Andrés','Moreno López','Barcelona','932112233');
INSERT INTO "proveedores" VALUES (3,'Raquel','Gómez Castro','Valencia','963445566');
INSERT INTO "proveedores" VALUES (4,'Pablo','Domínguez Ortiz','Sevilla','954778899');
INSERT INTO "proveedores" VALUES (5,'Elena','Jiménez Ramos','Bilbao','944556677');
COMMIT;
