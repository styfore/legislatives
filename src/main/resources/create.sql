 public.test;

CREATE TABLE public.desistement (
	id_candidat varchar NULL,
	nom varchar NULL,
    CONSTRAINT candidat_pkey PRIMARY KEY (id_candidat)
);

CREATE TABLE IF NOT EXISTS public.candidat
(
    id_candidat character varying COLLATE pg_catalog."default" NOT NULL,
    candidat integer,
    code_circo character varying COLLATE pg_catalog."default",
    inscrits integer,
    abstentions integer,
    votants integer,
    blancs integer,
    nuls integer,
    exprimes integer,
    nom character varying COLLATE pg_catalog."default",
    bloc character varying COLLATE pg_catalog."default",
    nb_voix integer,
    elu character varying COLLATE pg_catalog."default",
    CONSTRAINT candidat_pkey PRIMARY KEY (id_candidat)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.candidat
    OWNER to postgres;

ALTER TABLE IF EXISTS public.desistement
    OWNER to postgres;
