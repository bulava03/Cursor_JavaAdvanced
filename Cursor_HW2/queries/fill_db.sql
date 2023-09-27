USE cursor_hw2;

CREATE TABLE planes
  (
     plane_id     INT IDENTITY PRIMARY KEY,
     model        VARCHAR(30),
     serialnumber VARCHAR(30) UNIQUE,
     seats        INT
  );

INSERT INTO planes
            (model,
             serialnumber,
             seats)
VALUES      ('Boeing 747',
             'B-FTL94',
             467),
            ('Airbus A320',
             'TC-DMF7',
             186),
            ('Airbus A320',
             'VP-BJX3',
             186),
            ('Airbus A320',
             'HB-JCD9',
             186),
            ('Boeing 747',
             'N345AN',
             467),
            ('Airbus A320',
             'G-CIVU6',
             186),
            ('Airbus A320',
             'VT-IVD8',
             186);

CREATE TABLE pilots
  (
     pilot_id INT IDENTITY PRIMARY KEY,
     NAME     VARCHAR(50),
     age      INT,
     models   VARCHAR(max)
  );

INSERT INTO pilots
            (NAME,
             age,
             models)
VALUES      ('Bill',
             40,
             'Boeing 747, Airbus A320'),
            ('John',
             35,
             'Boeing 747'),
            ('Alex',
             24,
             'Airbus A320'),
            ('Victoria',
             44,
             'Airbus A320'),
            ('Roman',
             41,
             'Airbus A320'),
            ('Max',
             26,
             'Boeing 747, Airbus A320'),
            ('Barbara',
             31,
             'Airbus A320'),
            ('Steve',
             36,
             'Airbus A320');
