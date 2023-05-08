CREATE DATABASE ProjectMarketDB;


CREATE TABLE users
(
    user_id       serial  NOT NULL,
    user_name     text    NOT NULL,
    user_email    text    NOT NULL,
    user_password text    NOT NULL,
    position      text    NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE student_projects
(
    project_id          serial NOT NULL,
    student_id          serial NOT NULL,
    project_name        text   NOT NULL,
    project_description text   NOT NULL,
    PRIMARY KEY (project_id),
    CONSTRAINT student_projects_student_id_users_user_id_foreign FOREIGN KEY (student_id) REFERENCES users (user_id)
);

CREATE TABLE project_marks(
    mark_id      serial  NOT NULL,
    project_id   serial NOT NULL,
    teacher_id   serial NOT NULL,
    project_mark integer NOT NULL,
    PRIMARY KEY (mark_id),
    CONSTRAINT project_marks_project_id_student_projects_project_id_foreign FOREIGN KEY (project_id) REFERENCES student_projects (project_id),
    CONSTRAINT project_marks_teacher_id_users_user_id_foreign FOREIGN KEY (teacher_id) REFERENCES users (user_id)
);

INSERT INTO users (user_id, user_name, user_email, user_password, position) VALUES (1, 'STUDENT', 'STUDENT', '$2a$10$8rUHb8ztAY8oxK82B47w4O4/kKVdJX7uKI6HJp.KmL5IgtBlxShHq', 'STUDENT');
INSERT INTO users (user_id, user_name, user_email, user_password, position) VALUES (2, 'TEACHER', 'TEACHER', '$2a$10$nONyYCBFQK0p9CiR7GQzJejYsX9MxeaB9.8zOYJBXfo6v3ugL2iF2', 'TEACHER');
INSERT INTO users (user_id, user_name, user_email, user_password, position) VALUES (3, 'ADMIN', 'ADMIN', '$2a$10$IvlHQnq2ScnjiN4qKZieheE.l0HMPMLLdb78EdQHT4mABZeihXQDS', 'ADMIN');