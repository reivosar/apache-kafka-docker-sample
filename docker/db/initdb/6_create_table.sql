CREATE TABLE IF NOT EXISTS my_postgres_schema.message (
  id varchar(128) NOT NULL,
  created_at timestamp  NOT NULL DEFAULT current_timestamp,
  content text NOT NULL,
  CONSTRAINT message_pk PRIMARY KEY(id)
);
create unique index IF NOT EXISTS message_index on my_postgres_schema.message (created_at, id);

CREATE TABLE IF NOT EXISTS my_postgres_schema.message_metadata (
  id varchar(128) NOT NULL,
  name varchar(256) NOT NULL,
  value text NOT NULL,
  CONSTRAINT message_metadata_pk PRIMARY KEY(id, name)
);