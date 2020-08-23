# Pointofinterest
Use the Here Maps Places Search API’s to find Parking spots, Charging Stations and Restaurants near the user provided location.

### How to Run the Appliation 
Clone the application using git command 
```
C> git clone https://github.com/lokesh60/pointofinterest.git 
```

##### Run the below command to build the appplication 
> As it is a maven project build with mvn commad : it will take some time as it will try to download the all dependencies 
```mvn clean install ```

##### Run Application 
C> go to the target folder and run below command 
```java -jar pointofinterest-0.0.1-SNAPSHOT.jar```
The application run in 8080 port 

> Now open the below URL in the browser 
```http://localhost:8080/pointofinterest?location=51.5083,-0.1256```,
> Please use the different geocordinate for validating 

######Assumptions 
- location currently taking as geo-cordinates 
- only 3 category are showing 3 closest POIs
