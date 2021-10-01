create table Role
(
    role_id int unsigned auto_increment
        primary key,
    role    varchar(50) not null
);

create table faculty
(
    faculty_id int unsigned auto_increment
        primary key,
    faculty    varchar(100) not null
);

create table status
(
    status_id int unsigned auto_increment
        primary key,
    status    varchar(50) not null
);

create table study
(
    study_id int unsigned auto_increment
        primary key,
    study    varchar(100) not null,
    faculty  int unsigned not null comment 'FK',
    constraint FK_FACULTY_TO_STUDY
        foreign key (faculty) references faculty (faculty_id)
);

create table administratie
(
    admin_id      int unsigned auto_increment
        primary key,
    admin_name    varchar(50)  not null,
    admin_surname varchar(50)  not null,
    status        int unsigned not null comment 'FK',
    study         int unsigned not null comment 'FK',
    constraint FK_STATUS_TO_ADMINISTRATIE
        foreign key (status) references status (status_id),
    constraint FK_STUDY_TO_ADMINISTRATIE
        foreign key (study) references study (study_id)
);

create table orientatie
(
    orientatie_id int unsigned auto_increment
        primary key,
    orientatie    varchar(100) not null,
    study         int unsigned not null comment 'FK',
    constraint FK_STUDY_TO_ORIENTATIE
        foreign key (study) references study (study_id)
);

create table student
(
    student_id      bigint unsigned auto_increment
        primary key,
    student_name    varchar(50)  not null,
    student_surname varchar(50)  not null,
    status          int unsigned not null comment 'FK',
    study           int unsigned not null comment 'FK',
    orientatie      int unsigned not null comment 'FK',
    geslacht        varchar(10)  not null,
    cohort          int          not null,
    constraint FK_ORIENTATIE_TO_STUDENT
        foreign key (orientatie) references orientatie (orientatie_id),
    constraint FK_STATUS_TO_STUDENT
        foreign key (status) references status (status_id),
    constraint FK_STUDY_TO_STUDENT
        foreign key (study) references study (study_id)
);

create table studcie
(
    studcie_id int unsigned auto_increment
        primary key,
    student    bigint unsigned not null comment 'FK',
    role       int unsigned    not null comment 'FK',
    constraint FK_ROLE_TO_STUDCIE
        foreign key (role) references Role (role_id),
    constraint FK_STUDENT_TO_STUDCIE
        foreign key (student) references student (student_id)
);

create table wetenschapper
(
    wetenschapper_id      bigint unsigned auto_increment
        primary key,
    wetenschapper_naam    varchar(50)  not null,
    wetenschapper_surname varchar(500) not null,
    status                int unsigned not null comment 'FK',
    study                 int unsigned not null comment 'FK',
    constraint FK_STATUS_TO_WETENSCHAPPER
        foreign key (status) references status (status_id),
    constraint FK_STUDY_TO_WETENSCHAPPER
        foreign key (study) references study (study_id)
);

create table faculty_bestuur
(
    faculty_bestuur_id int unsigned auto_increment
        primary key,
    faculty            int unsigned    not null comment 'FK',
    wetenschapper      bigint unsigned not null comment 'FK',
    Role               int unsigned    not null comment 'FK',
    constraint FK_FACULTY_TO_FACULTY_BESTUUR
        foreign key (faculty) references faculty (faculty_id),
    constraint FK_ROLE_TO_FACULTY_BESTUUR
        foreign key (Role) references Role (role_id),
    constraint FK_WETENSCHAPPER_TO_FACULTY_BESTUUR
        foreign key (wetenschapper) references wetenschapper (wetenschapper_id)
);

create table subject
(
    subject_id    bigint unsigned auto_increment
        primary key,
    subject       varchar(100)    not null,
    wetenschapper bigint unsigned not null comment 'FK',
    studiepunten  float           not null,
    constraint FK_WETENSCHAPPER_TO_SUBJECT
        foreign key (wetenschapper) references wetenschapper (wetenschapper_id)
);

create table grade
(
    grade_id   bigint unsigned auto_increment
        primary key,
    subject    bigint unsigned not null comment 'FK',
    student    bigint unsigned not null comment 'FK',
    examinator bigint unsigned not null comment 'FK_wetenschapper',
    exam_date  date            not null,
    grade      float           not null,
    constraint FK_STUDENT_TO_GRADE
        foreign key (student) references student (student_id),
    constraint FK_SUBJECT_TO_GRADE
        foreign key (subject) references subject (subject_id),
    constraint FK_WETENSCHAPPER_TO_GRADE
        foreign key (examinator) references wetenschapper (wetenschapper_id)
);
