USE cursor_hw2

/*Виводить назву моделі літака, їх кількість в БД
та кількість місць в літаку даного типу*/
SELECT DISTINCT p.model,
                r.number_of_planes,
                p.seats
FROM   planes p
       INNER JOIN (SELECT model,
                          Count(*) AS Number_of_planes
                   FROM   planes
                   GROUP  BY model) r
               ON p.model LIKE r.model;

/*Виводить перших 10 записів, якими літаками можenm керувати пілоти
і ім'я пілота Bill або Roman*/
SELECT DISTINCT TOP 10 NAME,
                       age,
                       model,
                       serialnumber,
                       seats
FROM   pilots
       INNER JOIN planes
               ON models LIKE Concat('%', planes.model, '%')
WHERE  NAME LIKE 'Bill'
        OR NAME LIKE 'Roman' ;
