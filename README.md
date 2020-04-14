# Service Counter
> A simple rest service that counts the number of endpoint entries

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
A simple rest service that counts the number of endpoint entries. 

## Screenshots
![Example screenshot](./img/screenshot.png)

## Technologies
* Java
* Spring Framework
* H2 Database

## Setup
mvn clean install
in the absence of maven tools, you can use the version built into IntelliJ IDEA.
After the construction process is completed, the target folder will appear with the file product-service-0.0.1-SNAPSHOT.jar.
The application can be started by:
java -jar product-service-0.0.1-SNAPSHOT.jar
The application does not need an external application server to operate (the server is built into the project).
By default, the application runs on port 8080, to change the port, enter the port value in the application.properties file.

To-do list:
* To display the product after id you must send a GET request http://localhost:8080/products?id={n}. 

## Status
Project is: _in progress_ .

## Inspiration
The project was created to practice working with spring framework

## Contact
Created by [walczuk135@gmail.com](walczuk135@gmail.com) - feel free to contact me!
