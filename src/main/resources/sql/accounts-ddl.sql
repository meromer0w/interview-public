CREATE TABLE ACCOUNTS
(
    ID          BIGSERIAL       PRIMARY KEY,
    FIRST_NAME  VARCHAR(36)     NOT NULL,
    LAST_NAME   VARCHAR(36)     NOT NULL,
    BALANCE     DECIMAL(10,2)   NOT NULL
);