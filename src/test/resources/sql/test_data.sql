CREATE TABLE IF NOT EXISTS SPEECH(
	SPEECH_ID INTEGER NOT NULL AUTO_INCREMENT,
	CONTENT VARCHAR(1000) NOT NULL,
    	AUTHOR VARCHAR(50) NOT NULL,
    	SUBJECT VARCHAR(50) NOT NULL,
	CREATED_AT TIMESTAMP(0) WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (SPEECH_ID)
);

INSERT INTO SPEECH(CONTENT, AUTHOR, SUBJECT, CREATED_AT)
VALUES ('This is about Docker', 'Docker Guy', 'Docker 101', '2022-04-27 02:30');