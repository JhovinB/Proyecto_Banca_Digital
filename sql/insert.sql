INSERT INTO public.cliente(nombres, documento, fecha_nacimiento) VALUES ('Fernando', '12345678', '2000-09-07');
INSERT INTO public.cliente(nombres, documento, fecha_nacimiento) VALUES ('Kenia Valdes', '98765432', '1999-05-10');
INSERT INTO public.cliente(nombres, documento, fecha_nacimiento) VALUES ('Joao GR', '0011223344', '1999-03-16');
INSERT INTO public.cliente(nombres, documento, fecha_nacimiento) VALUES ('Ruben Perez', '99887766', '1993-10-05');
INSERT INTO public.cliente(nombres, documento, fecha_nacimiento) VALUES ('Jose Altamirano', '12349876', '1995-06-11');
INSERT INTO public.cliente(nombres, documento, fecha_nacimiento) VALUES ('Jhovin Bonifacio', '74036639', '1995-06-11');

INSERT INTO public.tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES (1, '1111-2222-3333-4444', '2020-12-20', 'ACTIVA');
INSERT INTO public.tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES (2, '1122-2222-3333-4444', '2021-06-27', 'BLOQUEADA');
INSERT INTO public.tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES (3, '1133-2222-3333-4444', '2022-04-10', 'ACTIVA');
INSERT INTO public.tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES (4, '1144-2222-3333-4444', '2023-10-15', 'INACTIVA');
INSERT INTO public.tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES (5, '1155-2222-3333-4444', '2024-04-04', 'ACTIVA');
INSERT INTO public.tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES (6, '1166-2222-3333-4444', '2024-04-04', 'ACTIVA');

INSERT INTO public.usuario(id_cliente, clave)VALUES (1,'$2a$10$wNKsq3dZi0ud3wRpzXk1Deao1VUTMp8QlwO/5X2Q/Xj6ESa9TtB2G');
INSERT INTO public.usuario(id_cliente, clave)VALUES (2,'$2a$10$wNKsq3dZi0ud3wRpzXk1Deao1VUTMp8QlwO/5X2Q/Xj6ESa9TtB2G');
INSERT INTO public.usuario(id_cliente, clave)VALUES (3,'$2a$10$wNKsq3dZi0ud3wRpzXk1Deao1VUTMp8QlwO/5X2Q/Xj6ESa9TtB2G');
INSERT INTO public.usuario(id_cliente, clave)VALUES (4,'$2a$10$wNKsq3dZi0ud3wRpzXk1Deao1VUTMp8QlwO/5X2Q/Xj6ESa9TtB2G');
INSERT INTO public.usuario(id_cliente, clave)VALUES (5,'$2a$10$wNKsq3dZi0ud3wRpzXk1Deao1VUTMp8QlwO/5X2Q/Xj6ESa9TtB2G');
INSERT INTO public.usuario(id_cliente, clave)VALUES (6,'$2a$10$wNKsq3dZi0ud3wRpzXk1Deao1VUTMp8QlwO/5X2Q/Xj6ESa9TtB2G');