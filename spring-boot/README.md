# spring-boot-jsp-route

### 💎 Database schema

```postgres-psql
create table if not exists city
(
	id smallint NOT NULL GENERATED ALWAYS AS IDENTITY primary key,
	name text
);

create table if not exists city_neighbours
(
	city_id smallint,
	neighbour_id smallint
);

ALTER TABLE city_neighbours
ADD FOREIGN KEY (city_id) REFERENCES city(id);

ALTER TABLE city_neighbours
ADD FOREIGN KEY (neighbour_id) REFERENCES city(id);
```

```postgres-psql
insert into city(name) values ('Targoviste'),('Pitesti'),('Ploiesti');
insert into city(name) values ('Botosani'),('Suceava'),('Piatra Neamt'),('Iasi');
insert into city(name) values ('Bacau'),('Vaslui'),('Miercurea Ciuc'),('Sfantu Gheorghe'),('Focsani');
insert into city(name) values ('Galati'),('Braila'),('Tulcea'),('Slobozia'),('Calarasi'),('Constanta');
insert into city(name) values ('Buzau'),('Bucuresti'),('Giurgiu'),('Alexandria'),('Brasov'),('Ramnicu Valcea');
insert into city(name) values ('Slatina'),('Craiova'),('Targu Jiu'),('Drobeta-Turnu Severin');
insert into city(name) values ('Sibiu'),('Targu Mures'),('Bistrita'),('Resita'),('Deva'),('Alba Iulia');
insert into city(name) values ('Cluj Napoca'),('Timisoara'),('Arad'),('Oradea'),('Satu Mare'),('Zalau'),('Baia Mare');



insert into city_neighbours(city_id,neighbour_id) values (1,2),(1,3),(1,20),(1,21),(1,22);
insert into city_neighbours(city_id,neighbour_id) values (2,1),(2,24),(2,25),(2,22),(2,23);
insert into city_neighbours(city_id,neighbour_id) values (3,1),(3,20),(3,16),(3,19),(3,11),(3,23);
insert into city_neighbours(city_id,neighbour_id) values (4,5),(4,6),(4,7);
insert into city_neighbours(city_id,neighbour_id) values (5,4),(5,6),(5,7),(5,31);
insert into city_neighbours(city_id,neighbour_id) values (6,4),(6,5),(6,7),(6,8),(6,10);
insert into city_neighbours(city_id,neighbour_id) values (7,5),(7,5),(7,6),(7,8),(7,9);
insert into city_neighbours(city_id,neighbour_id) values (8,6),(8,7),(8,9),(8,10),(8,11),(8,12);
insert into city_neighbours(city_id,neighbour_id) values (9,6),(9,7),(9,8),(9,13);
insert into city_neighbours(city_id,neighbour_id) values (10,6),(10,8),(10,11),(10,30),(10,23);
insert into city_neighbours(city_id,neighbour_id) values (11,8),(11,12),(11,19),(11,10),(11,23);
insert into city_neighbours(city_id,neighbour_id) values (12,13),(12,14),(12,19),(12,11),(12,8);
insert into city_neighbours(city_id,neighbour_id) values (13,9),(13,12),(13,14),(13,15);
insert into city_neighbours(city_id,neighbour_id) values (14,15),(14,18),(14,16),(14,19),(14,13);
insert into city_neighbours(city_id,neighbour_id) values (15,13),(15,14),(15,18);
insert into city_neighbours(city_id,neighbour_id) values (16,17),(16,18),(16,20),(16,3),(16,19),(16,14),(16,15);
insert into city_neighbours(city_id,neighbour_id) values (17,16),(17,18),(17,20),(17,21);
insert into city_neighbours(city_id,neighbour_id) values (18,14),(18,16),(18,17),(18,15);
insert into city_neighbours(city_id,neighbour_id) values (19,14),(19,16),(19,11),(19,12),(19,3);
insert into city_neighbours(city_id,neighbour_id) values (20,16),(20,17),(20,1),(20,3),(20,21);
insert into city_neighbours(city_id,neighbour_id) values (21,17),(21,20),(21,22);
insert into city_neighbours(city_id,neighbour_id) values (22,21),(22,25);
insert into city_neighbours(city_id,neighbour_id) values (23,10),(23,11),(23,19),(23,1),(23,3),(23,2),(23,29),(23,30);
insert into city_neighbours(city_id,neighbour_id) values (24,2),(24,25),(24,26),(24,27),(24,29);
insert into city_neighbours(city_id,neighbour_id) values (25,22),(25,2),(25,24),(25,26);
insert into city_neighbours(city_id,neighbour_id) values (26,24),(26,25),(26,27),(26,28);
insert into city_neighbours(city_id,neighbour_id) values (27,26),(27,28),(27,24),(27,33),(27,32);
insert into city_neighbours(city_id,neighbour_id) values (28,26),(28,27),(28,32);
insert into city_neighbours(city_id,neighbour_id) values (29,24),(29,2),(29,23),(29,30),(29,31);
insert into city_neighbours(city_id,neighbour_id) values (30,29),(30,23),(30,10),(30,31),(30,34),(30,35);
insert into city_neighbours(city_id,neighbour_id) values (31,30),(31,5),(31,35),(31,29);
insert into city_neighbours(city_id,neighbour_id) values (32,27),(32,28),(32,33),(32,36);
insert into city_neighbours(city_id,neighbour_id) values (33,27),(33,32),(33,34),(33,36),(33,37);
insert into city_neighbours(city_id,neighbour_id) values (34,29),(34,33),(34,30),(34,35);
insert into city_neighbours(city_id,neighbour_id) values (35,30),(35,34),(35,31),(35,40),(35,41),(35,38);
insert into city_neighbours(city_id,neighbour_id) values (36,32),(36,33),(36,37);
insert into city_neighbours(city_id,neighbour_id) values (37,33),(37,36),(37,38);
insert into city_neighbours(city_id,neighbour_id) values (38,35),(38,37),(38,40),(38,39);
insert into city_neighbours(city_id,neighbour_id) values (39,38),(39,40),(39,41);
insert into city_neighbours(city_id,neighbour_id) values (40,35),(40,41),(40,38),(40,39);
insert into city_neighbours(city_id,neighbour_id) values (41,39),(41,40),(41,31);

```