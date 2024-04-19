CREATE TABLE IF NOT EXISTS Run
(
    id
    SERIAL
    PRIMARY
    KEY,
    title
    varchar
(
    255
) NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    distance float NOT NULL,
    location varchar
(
    32
) NOT NULL,
    version int
    );