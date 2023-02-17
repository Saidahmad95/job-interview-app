INSERT INTO template (name) VALUES ('Template a');
INSERT INTO template (name) VALUES ('Template b');

INSERT INTO region (name) VALUES ('Tashkent');
INSERT INTO region (name) VALUES ('Bukhara');

INSERT INTO district (name,region_id) VALUES ('Chilonzor',1);
INSERT INTO district (name,region_id) VALUES ('Kogon',2);

INSERT INTO location (street,district_id) VALUES ('Alisher Navoiy street 26',1);
INSERT INTO location (street,district_id) VALUES ('Mahmud Tarobiy street 11',2);

INSERT INTO interview_type (name) VALUES('TELEPHONIC');
INSERT INTO interview_type (name) VALUES('FACE_TO_FACE');
INSERT INTO interview_type (name) VALUES('HR');


INSERT INTO interview (interview_type_id,is_active,location_id,template_id) 
VALUES (1,true,1,1);

INSERT INTO interview (interview_type_id,is_active,location_id,template_id) 
VALUES (2,true,2,2);

INSERT INTO interviewer (email,firstname,lastname,interview_id) 
VALUES ('komil@mail.ru','Komil','Allamjonov',2);
INSERT INTO interviewer (email,firstname,lastname,interview_id) 
VALUES ('frank@mail.ru','Frank','Mir',2);

INSERT INTO interviewer (email,firstname,lastname,interview_id) 
VALUES ('johny@mail.ru','Johny','Depp',1);




