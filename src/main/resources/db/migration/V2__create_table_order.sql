CREATE SEQUENCE IF NOT EXISTS order_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE "order" (
	id bigint DEFAULT nextval('order_id_seq') NOT NULL,
	delivery_date timestamp NOT NULL,
	preparation_time timestamp NOT NULL,
	service_type varchar(10) NOT NULL,
	status varchar(10) NOT NULL,
	creation_date timestamp DEFAULT now() NULL,
	last_modification_date timestamp NULL,
	"version" int8 DEFAULT 0 NOT NULL,
	store_id bigint NULL,
	CONSTRAINT order_pk UNIQUE (id),
	CONSTRAINT order_store_fk FOREIGN KEY (store_id) REFERENCES store(id)
);