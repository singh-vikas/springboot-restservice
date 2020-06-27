# Restfull web service using spring boot
Author - Vikas K Singh  

This has the basic REST operation using springboot framework and gradle as a build tool.

Git checkout and run the application
**./gradlew bootrun**

**URL** - http://localhost:8080/employees  
**Request Method**  - GET  
**Description**  - Print all the employees. 

[$ curl -v localhost:8080/employees]
``````
curl -v localhost:8080/employees
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /employees HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.64.1
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 180
< Date: Sat, 27 Jun 2020 21:15:47 GMT
< 
* Connection #0 to host localhost left intact
[Employee{id=4, name='Dom', role='gardener'}, Employee{id=3, name='Dom', role='gardener'}, Employee{id=2, name='Dom', role='gardener'}, Employee{id=1, name='Dom', role='gardener'}]* Closing connection 0
``````
**URL** - http://localhost:8080/employees/{id}  
**Request Method**  - GET  
**Description**  - Get one employee. 

[ $ curl -v localhost:8080/employees/4]
``````
curl -v localhost:8080/employees/4
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /employees/4 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.64.1
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 60
< Date: Sat, 27 Jun 2020 21:16:58 GMT
< 
* Connection #0 to host localhost left intact
Employee exists :Employee{id=4, name='Dom', role='gardener'}* Closing connection 0
``````


**URL** - http://localhost:8080/employees  
**Request Method**  - POST  
**Description**   - Add a new employee.  

[$ curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Tom", "role": "gardener", "salary":"$2500"}']
``````
Employee added :Employee{id=5, name='Tom', role='gardener'}
``````

**URL** - http://localhost:8080/employees/{id}  
**Request Method**  - DELETE  
**Description**  - Delete employee. 

[ $ curl -X DELETE localhost:8080/employees/5]
``````
Employee doesn't exists. Id : 5
``````



