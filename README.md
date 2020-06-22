Technologies Used
Java JDK 1.8.0
Spring 2.0.2 Release
Maven 4.0.0
MonogoDB 3.6.4
Tomcat 8.5.3

Database
database=TargetRetail
collecitons=product
mongodb host=localhost
mongodb port=27017

Steps to run app :
run jar, run as spring boot app
run db instance
Use http://localhost:8090/ for Application
http://localhost:27017/ for DB

URLs : 
http://localhost:8090/getAllProducts/ - shows all products
http://localhost:8090/products/5eef6c14606313744ccd6861
http://localhost:8090/products/5eef6c14606313744ccd6861- PUT - Updates Price By ID
