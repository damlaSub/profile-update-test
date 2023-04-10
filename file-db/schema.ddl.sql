	
DROP TABLE IF EXISTS profile_file;

CREATE TABLE profile_file(
	id SERIAL PRIMARY KEY,
	avatar VARCHAR(300),
	file VARCHAR(300),
	description VARCHAR(1000)
)