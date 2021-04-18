create table if not exists table_disciplines
(
	id int not null primary key auto_increment,
    dname varchar(100) not null,
    credits int not null
);

create table if not exists table_student
(
	id int not null primary key auto_increment,
    fio varchar(100) not null,
    course int not null
);

create table if not exists table_enrollment
(
	id int not null primary key auto_increment,
    id_discipline int not null,
    id_student int not null,
    grade double not null,
    constraint id_discipline
        foreign key (id_discipline) references table_disciplines (id),
    constraint id_student
        foreign key (id_student) references table_student (id)
);

insert into table_student (fio, course)
VALUES ('Григоренко Василь Болеславович', 4),
       ('Мигуля Надія Карпівна', 3),
       ('Верещак Ада Симонівна', 1),
       ('Цегинька Стефанія Русланівна', 2),
       ('Нечуй Захар Яремович', 4);

insert into table_disciplines (dname, credits)
VALUES ('Web-technologies', 3),
       ('Java', 4),
       ('DataBase', 4),
       ('Blockchain', 3),
       ('OOP', 4);

insert into table_enrollment(id_discipline, id_student, grade)
values ((select id from table_disciplines where table_disciplines.dname = 'Web-technologies'),
        (select id from table_student where table_student.fio = 'Григоренко Василь Болеславович'), 91),
       ((select id from table_disciplines where table_disciplines.dname = 'Java'),
        (select id from table_student where table_student.fio = 'Григоренко Василь Болеславович'), 85),
       ((select id from table_disciplines where table_disciplines.dname = 'DataBase'),
        (select id from table_student where table_student.fio = 'Григоренко Василь Болеславович'), 96),
       ((select id from table_disciplines where table_disciplines.dname = 'Web-technologies'),
        (select id from table_student where table_student.fio = 'Мигуля Надія Карпівна'), 91),
       ((select id from table_disciplines where table_disciplines.dname = 'Java'),
        (select id from table_student where table_student.fio = 'Мигуля Надія Карпівна'), 85),
       ((select id from table_disciplines where table_disciplines.dname = 'DataBase'),
        (select id from table_student where table_student.fio = 'Верещак Ада Симонівна'), 96),
       ((select id from table_disciplines where table_disciplines.dname = 'Blockchain'),
        (select id from table_student where table_student.fio = 'Верещак Ада Симонівна'), 85),
       ((select id from table_disciplines where table_disciplines.dname = 'OOP'),
        (select id from table_student where table_student.fio = 'Верещак Ада Симонівна'), 96),
       ((select id from table_disciplines where table_disciplines.dname = 'DataBase'),
        (select id from table_student where table_student.fio = 'Цегинька Стефанія Русланівна'), 85),
       ((select id from table_disciplines where table_disciplines.dname = 'Blockchain'),
        (select id from table_student where table_student.fio = 'Цегинька Стефанія Русланівна'), 96),
       ((select id from table_disciplines where table_disciplines.dname = 'Java'),
        (select id from table_student where table_student.fio = 'Нечуй Захар Яремович'), 85);