CREATE TABLE TRANSFERS
(
    ID                  BIGSERIAL           PRIMARY KEY,
    SOURCE_ID           BIGSERIAL           NOT NULL,
    TARGET_ID           BIGSERIAL           NOT NULL,
    AMOUNT              DECIMAL(10, 2)      NOT NULL,
    TRANSFER_TIME       TIMESTAMP           NOT NULL,

    CONSTRAINT          FK_SOURCE_ACCOUNT   FOREIGN KEY (SOURCE_ID) REFERENCES ACCOUNTS (ID),
    CONSTRAINT          FK_TARGET_ACCOUNT   FOREIGN KEY (TARGET_ID) REFERENCES ACCOUNTS (ID)
);