-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.compra
(
    id_compra bigint NOT NULL DEFAULT nextval('compra_id_compra_seq'::regclass),
    estado integer NOT NULL,
    fecha_compra timestamp without time zone,
    fecha_mod timestamp without time zone,
    total_compra double precision,
    id_proveedor bigint NOT NULL,
    CONSTRAINT compra_pkey PRIMARY KEY (id_compra)
);

CREATE TABLE IF NOT EXISTS public.detalle_compra
(
    id_detalle_compra bigint NOT NULL DEFAULT nextval('detalle_compra_id_detalle_compra_seq'::regclass),
    cantidad double precision,
    precio_compra double precision,
    producto bigint,
    sub_total double precision,
    id_compra bigint,
    CONSTRAINT detalle_compra_pkey PRIMARY KEY (id_detalle_compra)
);

CREATE TABLE IF NOT EXISTS public.proveedor
(
    id_proveedor bigint NOT NULL DEFAULT nextval('proveedor_id_proveedor_seq'::regclass),
    celular character varying(9) COLLATE pg_catalog."default",
    correo character varying(255) COLLATE pg_catalog."default",
    direccion character varying(255) COLLATE pg_catalog."default",
    estado integer NOT NULL,
    fecha_crea timestamp without time zone,
    fecha_mod timestamp without time zone,
    razon_social character varying(255) COLLATE pg_catalog."default",
    ruc character varying(11) COLLATE pg_catalog."default",
    CONSTRAINT proveedor_pkey PRIMARY KEY (id_proveedor)
);

ALTER TABLE IF EXISTS public.compra
    ADD CONSTRAINT fk_compra_proveedor FOREIGN KEY (id_proveedor)
    REFERENCES public.proveedor (id_proveedor) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.detalle_compra
    ADD CONSTRAINT fk_detallecompra_compra FOREIGN KEY (id_compra)
    REFERENCES public.compra (id_compra) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;