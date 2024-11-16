CREATE TABLE IF NOT EXISTS public.users
(
    id serial NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (email)
);
