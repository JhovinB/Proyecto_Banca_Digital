CREATE DATABASE banca_digital
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
CREATE TABLE public.cliente
(
    id integer NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
    nombres character varying(100) COLLATE pg_catalog."default" NOT NULL,
    documento character varying(15) COLLATE pg_catalog."default" NOT NULL,
    fecha_nacimiento date NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id),
    CONSTRAINT cliente_uc_documento UNIQUE (documento)
)

TABLESPACE pg_default;

ALTER TABLE public.cliente
    OWNER to postgres;    
CREATE TABLE public.tarjeta
	(
	    id serial,
	    id_cliente integer NOT NULL,
	    numero_tarjeta character varying(20) COLLATE pg_catalog."default" NOT NULL,
	    fecha_vencimiento date NOT NULL,
	    estado character varying COLLATE pg_catalog."default" NOT NULL,
	    CONSTRAINT tarjeta_pgkey PRIMARY KEY (id),
	    CONSTRAINT tarjeta_cliente_fkey FOREIGN KEY (id_cliente)
	        REFERENCES public.cliente (id) MATCH SIMPLE
	        ON UPDATE CASCADE
	        ON DELETE CASCADE
	)	

TABLESPACE pg_default;

ALTER TABLE public.tarjeta
    OWNER to postgres;
    
 CREATE TABLE public.usuario
(
    id serial,
    id_cliente integer NOT NULL,
    clave character varying(30) NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_cliente_fkey FOREIGN KEY (id_cliente)
        REFERENCES public.cliente (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
TABLESPACE pg_default;
    