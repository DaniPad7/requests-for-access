INSERT INTO app_user VALUES(1, '123 4th St Washington', '209-355-4641', 'dpad@gmail.com', 'Daniel', 'Padilla');
INSERT INTO app_user VALUES(2, '123 4th St Washington', '435-784-7011', 'bk@gmail.com', 'Brian', 'Kelly');
INSERT INTO app_user VALUES(3, '123 4th St Washington', '621-673-0435', 'ph@gmail.com', 'Billy', 'Huyhn');

INSERT INTO justification_option VALUES(1, 'Promotion');
INSERT INTO justification_option VALUES(2, 'Security Clearance');
INSERT INTO justification_option VALUES(3, 'Other');

INSERT INTO status_option VALUES(1, 'PENDING');
INSERT INTO status_option VALUES(2, 'APPROVED');
INSERT INTO status_option VALUES(3, 'REJECTED');

INSERT INTO role VALUES(1, 'ROLE_ASSOCIATE');
INSERT INTO role VALUES(2, 'ROLE_ADMIN');
INSERT INTO role VALUES(3, 'ROLE_EXECUTIVE');

INSERT INTO request_ticket VALUES(98, CURRENT_DATE, 2, 1, 3, 1);
INSERT INTO request_ticket VALUES(99, CURRENT_DATE, 1, 1, 3, 1);
INSERT INTO request_ticket VALUES(100, CURRENT_DATE, 2, 2, 3, 1);

INSERT INTO user_authentication VALUES(1, '$2a$10$xfL2VcG1XKILIoe9JO91MeOUJL3KSoAINvaBou0jikBimkJlsmNVq', 'DanPad', 1);
INSERT INTO user_authentication VALUES(2, '$2a$12$Z2bXe0urWhN1FvA/akEj6uDFq8nDZY.1DTlImUG4N5Gw2JifpJ1MS', 'BKelly', 2);
INSERT INTO user_authentication VALUES(3, '$2a$12$DWIwlWP1EMtNWy.Oi00osucoy1n5qRd9i9tuBlTn9vcmNBNKvcjZy', 'BillyP', 3);

INSERT INTO user_authentication_roles VALUES(1, 1);
INSERT INTO user_authentication_roles VALUES(2, 2);
INSERT INTO user_authentication_roles VALUES(3, 3);