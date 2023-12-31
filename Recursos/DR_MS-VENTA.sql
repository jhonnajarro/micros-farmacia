-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.detalle_venta
(
    id_detalle_venta bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    cantidad integer NOT NULL,
    id_producto bigint,
    sub_total double precision,
    id_venta bigint,
    CONSTRAINT detalle_venta_pkey PRIMARY KEY (id_detalle_venta)
);

CREATE TABLE IF NOT EXISTS public.venta
(
    id_venta bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    fecha_venta timestamp without time zone,
    id_cliente bigint,
    id_usuario bigint,
    total_venta double precision,
    CONSTRAINT venta_pkey PRIMARY KEY (id_venta)
);

ALTER TABLE IF EXISTS public.detalle_venta
    ADD CONSTRAINT fkoknpg31rxsqnjxrsu7iy47p1o FOREIGN KEY (id_venta)
    REFERENCES public.venta (id_venta) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;