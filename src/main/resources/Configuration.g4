grammar Configuration;

properties: property+;
property: ID '=' stringvalue
        | ID '=' intvalue;
stringvalue: STRING;
intvalue: INT;

ID : [a-zA-Z]+ ;
STRING : '"' .*? '"';
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip;
