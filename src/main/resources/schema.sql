CREATE TABLE Cursos (
id_curso int auto_increment,
nombre_curso VARCHAR(30),
tipo_curso VARCHAR(30),
nombre_profesor VARCHAR(30),
numero_alumnos INT,
numero_lecciones INT,
primary key (id_curso));

INSERT INTO CURSOS (nombre_curso,tipo_curso,nombre_profesor,numero_alumnos,numero_lecciones) VALUES ('Spring MVC','Tecnología','Kevin',10,1);
INSERT INTO CURSOS (nombre_curso,tipo_curso,nombre_profesor,numero_alumnos,numero_lecciones) VALUES ('Spring JPA','Tecnología','Humberto',20,2);
INSERT INTO CURSOS (nombre_curso,tipo_curso,nombre_profesor,numero_alumnos,numero_lecciones) VALUES ('Spring H2','Tecnología','Luis',30,3);
INSERT INTO CURSOS (nombre_curso,tipo_curso,nombre_profesor,numero_alumnos,numero_lecciones) VALUES ('Spring WEB','Tecnología','Josue',40,4);
INSERT INTO CURSOS (nombre_curso,tipo_curso,nombre_profesor,numero_alumnos,numero_lecciones) VALUES ('Spring Thymeleaf','Tecnología','Misael',50,5);