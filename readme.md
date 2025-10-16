# H3 
H3 is a database project created for learning purposes.

Apart from being your regular SQL engine, some unique features are also to be implemented, such as:  
No forced id column.  
Nulls can be passed as values.  
Parser is case (and space) agnostic for SQL keywords, so:  
"seLecT * fROm cars;"  
and   
"         select   * FROM cars;"
will be treated equally, however table name is case sensitive.  
Trying to add row for non existing column will fail.  
Upon adding value for column - java tries to box the value (that is '33123' can be casted
to string, but "skadjfk" can not be cast to integer). In fact boxing is defined by Java 
entirely.  
Table is created in current DataBase by default, or in one which connected now.  
Tables 'car' and 'Car' are deemed to be different.  
Table without any column definition data is not supported.

Final doc with all features will be released as project grows.

