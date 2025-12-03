INSERT INTO students (name, course) VALUES
('Oralbek', 1),
('Jauhar', 2),
('Aibek', 3);

INSERT INTO books (name, genre, student_id) VALUES
('Java', 'Programming', 1),
('Python', 'Programming', 1),
('Database', 'Database', 2),
('Ai', 'Programming', 3);

INSERT INTO groups (name, type) VALUES
('Best', 'Math'),
('Midle', 'Gum'),
('Low', 'Programming');

INSERT INTO student_groups (student_id, group_id) VALUES
(1, 1),
(1, 3),
(2, 2),
(3, 3);
