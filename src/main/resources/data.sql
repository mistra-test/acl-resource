CREATE TABLE IF NOT EXISTS grant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_party (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    party_id INT
);

CREATE TABLE IF NOT EXISTS party_grant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    party_id INT,
    grant_id INT
);

INSERT INTO grant (id, name) VALUES
  (1, 'movie_write'),
  (2, 'movie_read');

INSERT INTO user_party (id, user_id, party_id) VALUES
  (1, 1, 1),
  (2, 2, 2);

INSERT INTO party_grant (id, party_id, grant_id) VALUES
  (1, 1, 1),
  (2, 1, 2),
  (3, 2, 2);