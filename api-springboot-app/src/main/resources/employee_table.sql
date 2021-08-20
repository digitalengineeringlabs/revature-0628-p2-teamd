-- Drop table

-- DROP TABLE "project2_DB".user_table;

CREATE TABLE "project2_DB".user_table (
	uid serial NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	phone_number int4 NULL,
	email varchar NULL,
	employee_type varchar NULL,
	user_name varchar NOT NULL,
	"password" varchar NOT NULL,
	CONSTRAINT newtable_pk PRIMARY KEY (uid)
);
CREATE INDEX newtable_uid_idx ON "project2_DB".user_table USING btree (uid);
