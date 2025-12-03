CREATE table students (
    id BIGINT primary key generated always as IDENTITY ,
    name VARCHAR(30),
    course INTEGER
);

Create table books (
    id Bigint primary key generated always as identity ,
    name VARCHAR(30),
    genre VARCHAR(30),
    student_id BIGINT,
    constraint  fk_books_student foreign key (student_id) references students(id) on delete cascade
);

Create TABLE groups (
    id Bigint primary key generated always as identity ,
    name VARCHAR(30),
    type VARCHAR(30)
);

CREATE table student_groups (
    student_id BIGINT not null ,
    group_id BIGINT not null ,
    PRIMARY KEY (student_id, group_id),
    FOREIGN KEY (student_id) REFERENCES students(id) on DELETE cascade,
    FOREIGN KEY (group_id) references groups(id) on delete cascade
);

