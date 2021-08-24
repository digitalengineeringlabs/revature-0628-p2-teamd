-- project2.ticket definition

-- Drop table

-- DROP TABLE project2.ticket;

CREATE TABLE project2.ticket (
	id serial NOT NULL,
	reason varchar NOT NULL,
	amount float8 NOT NULL,
	"time" date NOT NULL,
	user_id int4 NOT NULL,
	status varchar NOT NULL,
	CONSTRAINT ticket_pk PRIMARY KEY (id),
	CONSTRAINT ticket_un UNIQUE (id)
);