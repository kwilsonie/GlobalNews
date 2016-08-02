For MySQL 
---------
create a database called globalnews
import *.sql database dumps 
create a user called 'littlefish' with the password 'letmein' with root access
start mysql server

java
----
java -cp .:mysql-connector-java-5.1.39-bin.jar:GlobalNews.jar  com.globalnews.AuthorApplication 
