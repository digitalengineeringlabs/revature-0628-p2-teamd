-- Drop table

-- DROP TABLE "project2_DB".user_table;

CREATE TABLE "project2_DB".user_table (
	uid serial NOT NULL, -- Serial table id of user, pk
	first_name varchar NOT NULL, -- User firstname
	last_name varchar NOT NULL, -- User last name
	phone_number int4 NULL, -- User phone number
	email varchar NULL, -- User email, pk2
	employee_type varchar NULL, -- level of access, employee or manager
	user_name varchar NOT NULL, -- username for application
	"password" varchar NOT NULL, -- password for application
	CONSTRAINT newtable_pk PRIMARY KEY (uid)
);
CREATE INDEX newtable_uid_idx ON "project2_DB".user_table USING btree (uid);

-- Column comments

COMMENT ON COLUMN "project2_DB".user_table.uid IS 'Serial table id of user, pk';
COMMENT ON COLUMN "project2_DB".user_table.first_name IS 'User firstname';
COMMENT ON COLUMN "project2_DB".user_table.last_name IS 'User last name';
COMMENT ON COLUMN "project2_DB".user_table.phone_number IS 'User phone number';
COMMENT ON COLUMN "project2_DB".user_table.email IS 'User email, pk2';
COMMENT ON COLUMN "project2_DB".user_table.employee_type IS 'level of access, employee or manager';
COMMENT ON COLUMN "project2_DB".user_table.user_name IS 'username for application';
COMMENT ON COLUMN "project2_DB".user_table."password" IS 'password for application';

-- Table rows

-- Auto-generated SQL script #202108191845
INSERT INTO "project2_DB".user_table (first_name,last_name,phone_number,email,employee_type,user_name,"password")
	VALUES ('test','employee',15555551234,'test@test.com','employee','test','1234');
INSERT INTO "project2_DB".user_table (first_name,last_name,phone_number,email,employee_type,user_name,"password")
	VALUES ('admin','test',1234567891,'admin@test.com','manager','admin','1234');
