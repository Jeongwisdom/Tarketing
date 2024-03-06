CREATE TABLE IF NOT EXISTS `member` (
                        id          BIGINT        AUTO_INCREMENT,
                        name        VARCHAR(10)   NOT NULL,
                        nickname    VARCHAR(10)   NOT NULL,
                        email       VARCHAR(50)   NOT NULL UNIQUE,
						address     VARCHAR(100)  NOT NULL,
                        birth       DATE          NOT NULL,
                        created_at  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
                        profile_img VARCHAR(500) NOT NULL DEFAULT "https://cdn-icons-png.flaticon.com/128/2815/2815428.png",
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `token` (
                        id        BIGINT        AUTO_INCREMENT,
                        member_id BIGINT        NOT NULL,
                        token     VARCHAR(1000) NOT NULL,
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `event` (
                        id        BIGINT        AUTO_INCREMENT,
						title     VARCHAR(50)   NOT NULL,
                        host      VARCHAR(20)   NOT NULL,
                        location  VARCHAR(50)   NOT NULL,
						age_limit  BIGINT,
                        event_img  VARCHAR(500) NOT NULL DEFAULT "https://cdn-icons-png.flaticon.com/128/1760/1760465.png",
                        created_at TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `event_date` (
                        id       BIGINT    AUTO_INCREMENT,
                        event_id BIGINT    NOT NULL,
                        date     TIMESTAMP NOT NULL,
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `ticket` (
                        id              BIGINT       AUTO_INCREMENT,
                        event_date_id   BIGINT       NOT NULL,
                        seat_name       VARCHAR(10)  NOT NULL,
                        price           BIGINT       NOT NULL,
                        remaining_seats BIGINT       NOT NULL,
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `ticketing` (
                        id       BIGINT    AUTO_INCREMENT,
                        event_id BIGINT    NOT NULL,
                        date     TIMESTAMP NOT NULL,
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `member_ticket` (
                        id         BIGINT  AUTO_INCREMENT,
                        member_id  BIGINT  NOT NULL,
                        ticket_id  BIGINT  NOT NULL,
						canceled   BOOLEAN NOT NULL DEFAULT 0,
                        PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS `member_ticketing` (
                        id           BIGINT  AUTO_INCREMENT,
                        member_id    BIGINT  NOT NULL,
                        ticketing_id BIGINT  NOT NULL,
						deleted      BOOLEAN NOT NULL DEFAULT 0,
                        PRIMARY KEY(id)
);
