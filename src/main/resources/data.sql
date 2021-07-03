INSERT INTO grant (id, name) VALUES
  (1, 'ROLE_movie:write'),
  (2, 'ROLE_movie:read');

INSERT INTO user_party (id, user_id, party_id) VALUES
  (1, 1, 1),
  (2, 2, 2);

INSERT INTO party_grant (id, party_id, grant_id) VALUES
  (1, 1, 1),
  (2, 1, 2),
  (3, 2, 2);