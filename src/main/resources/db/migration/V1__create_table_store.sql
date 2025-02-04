CREATE SEQUENCE IF NOT EXISTS store_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE IF NOT EXISTS store (
	id bigint DEFAULT nextval('store_id_seq') NOT NULL,
	"name" varchar NOT NULL,
	zipcode varchar(10) NOT NULL,
	street varchar NOT NULL,
	city varchar NOT NULL,
	creation_date timestamp DEFAULT now() NULL,
    last_modification_date timestamp NULL,
    "version" int8 DEFAULT 0 NOT NULL,
	CONSTRAINT store_pk UNIQUE (id)
);
