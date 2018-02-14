DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS users_roles;

CREATE TABLE  users
(user_id INT NOT NULL AUTO_INCREMENT,
 user_name VARCHAR(20) NOT NULL,
 user_password VARCHAR(20) NOT NULL ,
 PRIMARY KEY (user_id)
);

CREATE TABLE  roles
(role_id INT NOT NULL AUTO_INCREMENT,
 role VARCHAR(20) NOT NULL,
 PRIMARY KEY (role_id)
);

CREATE TABLE  users_roles
(user_id INT NOT NULL,
role_id INT NOT NULL,
PRIMARY KEY (user_id, role_id),
FOREIGN KEY (user_id) REFERENCES users (user_id) ,
FOREIGN KEY (role_id) REFERENCES roles (role_id));

DROP TABLE IF EXISTS persons;
CREATE TABLE persons
(person_id INT NOT NULL AUTO_INCREMENT,
person_name VARCHAR(20) NOT NULL,
 person_address VARCHAR (20) NOT NULL,
 PRIMARY KEY (person_id)
 );


COMMIT ;

/*SELECT Users.user_id, Users.user_name, Roles.role
                FROM users
                JOIN users_roles ON users.user_id = users_roles.user_id
                JOIN roles ON roles.role_id = users_roles.role_id
                ORDER BY users.user_id;

SELECT Users.user_id, users.user_name, roles.role
FROM users, roles, users_roles
WHERE users.user_id = users_roles.user_id AND
roles.role_id = users_roles.role_id
ORDER BY user_id;*/


