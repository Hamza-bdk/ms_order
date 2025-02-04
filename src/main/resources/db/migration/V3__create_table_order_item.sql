CREATE SEQUENCE IF NOT EXISTS item_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE item (
	id bigint DEFAULT nextval('item_id_seq') NOT NULL,
	name varchar(100) NOT NULL,
	image_uri varchar,
	barcode varchar(13) NOT NULL,
	quantity int4 NOT NULL,
	creation_date timestamp DEFAULT now() NULL,
	last_modification_date timestamp NULL,
	"version" int8 DEFAULT 0 NOT NULL,
	order_id bigint NULL,
	CONSTRAINT item_pk UNIQUE (id),
	CONSTRAINT item_order_fk FOREIGN KEY (id) REFERENCES "order"(id)
);