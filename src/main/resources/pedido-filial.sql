--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.16
-- Dumped by pg_dump version 9.3.16
-- Started on 2018-01-29 08:11:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 8 (class 2615 OID 32974)
-- Name: db; Type: SCHEMA; Schema: -; Owner: teste
--

CREATE SCHEMA db;


ALTER SCHEMA db OWNER TO teste;

SET search_path = db, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 178 (class 1259 OID 33000)
-- Name: cliente; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE cliente (
    id integer NOT NULL,
    id_pessoa integer NOT NULL,
    situacao character varying(3),
    id_filial integer
);


ALTER TABLE db.cliente OWNER TO teste;

--
-- TOC entry 187 (class 1259 OID 49372)
-- Name: cliente_contato; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE cliente_contato (
    id_cliente integer NOT NULL,
    id_contato integer NOT NULL
);


ALTER TABLE db.cliente_contato OWNER TO teste;

--
-- TOC entry 173 (class 1259 OID 32977)
-- Name: endereco; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE endereco (
    id integer NOT NULL,
    logradouro character varying(60),
    numero character varying(10),
    bairro character varying(60),
    cidade character varying(40),
    uf character varying(2)
);


ALTER TABLE db.endereco OWNER TO teste;

--
-- TOC entry 180 (class 1259 OID 41167)
-- Name: filial; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE filial (
    id integer NOT NULL,
    sigla character varying(10),
    id_pessoa_juridica integer
);


ALTER TABLE db.filial OWNER TO teste;

--
-- TOC entry 185 (class 1259 OID 41193)
-- Name: item_pedido; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE item_pedido (
    numero integer NOT NULL,
    valor numeric(6,2),
    id_produto integer NOT NULL,
    quantidade numeric(6,2),
    id_pedido integer
);


ALTER TABLE db.item_pedido OWNER TO teste;

--
-- TOC entry 186 (class 1259 OID 49359)
-- Name: pedido; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE pedido (
    id integer NOT NULL,
    data_hora timestamp without time zone,
    id_situacao character varying(2),
    id_cliente integer,
    numero integer,
    valor_total numeric(6,2),
    id_filial integer
);


ALTER TABLE db.pedido OWNER TO teste;

--
-- TOC entry 177 (class 1259 OID 32995)
-- Name: pessoa; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE pessoa (
    id integer NOT NULL,
    nome character varying(60),
    id_endereco integer,
    id_telefone integer,
    cnpj character varying(15),
    razao_social character varying(60),
    tipo character varying(2),
    inscricao_estadual character varying(20),
    cpf character varying(11)[],
    rg character varying(10)[],
    data_nascimento time without time zone
);


ALTER TABLE db.pessoa OWNER TO teste;

--
-- TOC entry 182 (class 1259 OID 41184)
-- Name: produto; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE produto (
    id integer NOT NULL,
    descricao character varying(50),
    marca character varying(30),
    modelo character varying(30),
    preco numeric(6,2)
);


ALTER TABLE db.produto OWNER TO teste;

--
-- TOC entry 188 (class 1259 OID 49377)
-- Name: seq_id_cliente; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_cliente
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_cliente OWNER TO teste;

--
-- TOC entry 172 (class 1259 OID 32975)
-- Name: seq_id_endereco; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_endereco
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_endereco OWNER TO teste;

--
-- TOC entry 179 (class 1259 OID 41165)
-- Name: seq_id_filial; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_filial
    START WITH 11
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_filial OWNER TO teste;

--
-- TOC entry 183 (class 1259 OID 41189)
-- Name: seq_id_item_pedido; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_item_pedido
    START WITH 11
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_item_pedido OWNER TO teste;

--
-- TOC entry 184 (class 1259 OID 41191)
-- Name: seq_id_pedido; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_pedido
    START WITH 11
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_pedido OWNER TO teste;

--
-- TOC entry 175 (class 1259 OID 32988)
-- Name: seq_id_pessoa; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_pessoa
    START WITH 11
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_pessoa OWNER TO teste;

--
-- TOC entry 181 (class 1259 OID 41182)
-- Name: seq_id_produto; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_produto
    START WITH 14
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_produto OWNER TO teste;

--
-- TOC entry 174 (class 1259 OID 32986)
-- Name: seq_id_telefone; Type: SEQUENCE; Schema: db; Owner: teste
--

CREATE SEQUENCE seq_id_telefone
    START WITH 11
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE db.seq_id_telefone OWNER TO teste;

--
-- TOC entry 176 (class 1259 OID 32990)
-- Name: telefone; Type: TABLE; Schema: db; Owner: teste; Tablespace: 
--

CREATE TABLE telefone (
    id integer NOT NULL,
    ddd integer,
    numero integer
);


ALTER TABLE db.telefone OWNER TO teste;

--
-- TOC entry 2008 (class 0 OID 33000)
-- Dependencies: 178
-- Data for Name: cliente; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY cliente (id, id_pessoa, situacao, id_filial) FROM stdin;
1	11	\N	\N
\.


--
-- TOC entry 2017 (class 0 OID 49372)
-- Dependencies: 187
-- Data for Name: cliente_contato; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY cliente_contato (id_cliente, id_contato) FROM stdin;
\.


--
-- TOC entry 2003 (class 0 OID 32977)
-- Dependencies: 173
-- Data for Name: endereco; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY endereco (id, logradouro, numero, bairro, cidade, uf) FROM stdin;
9	Logradouro 1	numero 1	bairro 1	cidade 1	AP
10	Logradouro 2	numero 2	bairro 2	cidade 2	AP
11	Logradouro 3	numero 3	bairro 3	cidade 3	PA
12	Ceilandia Norte			Ceilandia	AC
13	Ceilandia Sul			Ceilandia	DF
14	Tag. Norte			Taguatinga Norte	DF
\.


--
-- TOC entry 2010 (class 0 OID 41167)
-- Dependencies: 180
-- Data for Name: filial; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY filial (id, sigla, id_pessoa_juridica) FROM stdin;
11	CEI_NOR_DF	11
12	CEI_SUL_DF	12
13	TAG_NOR_DF	13
\.


--
-- TOC entry 2015 (class 0 OID 41193)
-- Dependencies: 185
-- Data for Name: item_pedido; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY item_pedido (numero, valor, id_produto, quantidade, id_pedido) FROM stdin;
1	\N	14	\N	34
\.


--
-- TOC entry 2016 (class 0 OID 49359)
-- Dependencies: 186
-- Data for Name: pedido; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY pedido (id, data_hora, id_situacao, id_cliente, numero, valor_total, id_filial) FROM stdin;
34	2018-01-23 08:11:04.406	AB	1	\N	\N	11
\.


--
-- TOC entry 2007 (class 0 OID 32995)
-- Dependencies: 177
-- Data for Name: pessoa; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY pessoa (id, nome, id_endereco, id_telefone, cnpj, razao_social, tipo, inscricao_estadual, cpf, rg, data_nascimento) FROM stdin;
11	Filial Ceilandia Norte	12	\N		\N	J		\N	\N	\N
12	Filial Ceilandia Sul	13	\N	cnpj 1	\N	J	inscr. estad. 2	\N	\N	\N
13	Taguatinga Norte	14	\N		\N	J		\N	\N	\N
\.


--
-- TOC entry 2012 (class 0 OID 41184)
-- Dependencies: 182
-- Data for Name: produto; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY produto (id, descricao, marca, modelo, preco) FROM stdin;
14	Produto 1	Marca 1	Modelo 1	10.00
\.


--
-- TOC entry 2023 (class 0 OID 0)
-- Dependencies: 188
-- Name: seq_id_cliente; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_cliente', 1, true);


--
-- TOC entry 2024 (class 0 OID 0)
-- Dependencies: 172
-- Name: seq_id_endereco; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_endereco', 14, true);


--
-- TOC entry 2025 (class 0 OID 0)
-- Dependencies: 179
-- Name: seq_id_filial; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_filial', 13, true);


--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 183
-- Name: seq_id_item_pedido; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_item_pedido', 11, false);


--
-- TOC entry 2027 (class 0 OID 0)
-- Dependencies: 184
-- Name: seq_id_pedido; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_pedido', 34, true);


--
-- TOC entry 2028 (class 0 OID 0)
-- Dependencies: 175
-- Name: seq_id_pessoa; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_pessoa', 13, true);


--
-- TOC entry 2029 (class 0 OID 0)
-- Dependencies: 181
-- Name: seq_id_produto; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_produto', 14, true);


--
-- TOC entry 2030 (class 0 OID 0)
-- Dependencies: 174
-- Name: seq_id_telefone; Type: SEQUENCE SET; Schema: db; Owner: teste
--

SELECT pg_catalog.setval('seq_id_telefone', 11, false);


--
-- TOC entry 2006 (class 0 OID 32990)
-- Dependencies: 176
-- Data for Name: telefone; Type: TABLE DATA; Schema: db; Owner: teste
--

COPY telefone (id, ddd, numero) FROM stdin;
\.


-- Completed on 2018-01-29 08:11:31

--
-- PostgreSQL database dump complete
--

