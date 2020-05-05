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