CREATE TABLE book
(
    id          INTEGER GENERATED ALWAYS AS IDENTITY,
    ISBN        VARCHAR(100) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    genre       VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    author      VARCHAR(100) NOT NULL
);