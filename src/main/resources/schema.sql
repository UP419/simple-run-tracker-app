CREATE TABLE IF NOT EXISTS Run
(
    id
    INT
    NOT
    NULL,
    title
    nvarchar
(
    255
) NOT NULL,
    startDate timestamp NOT NULL,
    endDate timestamp NOT NULL,
    distance float NOT NULL,
    location nvarchar
(
    32
) NOT NULL,
    PRIMARY KEY
(
    id
)
    );