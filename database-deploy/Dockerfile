FROM postgres:latest

COPY ./sql/01-schema.sql /docker-entrypoint-initdb.d/01-schema.sql
COPY ./sql/02-data.sql /docker-entrypoint-initdb.d/02-data.sql