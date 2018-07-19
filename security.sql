DROP TABLE IF EXISTS um_user;
CREATE TABLE um_user (
		userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR(20) NOT NULL,
		password VARCHAR(64) NOT NULL,
		enable CHAR(1) NOT NULL DEFAULT 'Y',
		createBy VARCHAR(20) NOT NULL,
		createDate TIMESTAMP NOT NULL,
		updateBy VARCHAR(20) NOT NULL,
		updateDate TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS um_role;
CREATE TABLE um_role (
		roleId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		roleName VARCHAR(20) NOT NULL,
		enable CHAR(1) NOT NULL DEFAULT 'Y',
		createBy VARCHAR(20) NOT NULL,
		createDate TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS um_resource;
CREATE TABLE um_resource (
		resId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		resName VARCHAR(20) NOT NULL,
		resPath VARCHAR(50) NOT NULL,
		enable CHAR(1) NOT NULL DEFAULT 'Y',
		createBy VARCHAR(20) NOT NULL,
		createDate TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS um_login;
CREATE TABLE um_login (
		id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		username VARCHAR(20) NOT NULL,
		ip VARCHAR(50) NOT NULL,
		createDate TIMESTAMP NOT NULL
);