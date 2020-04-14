# Service Counter
> A simple rest service that counts the number of endpoint entries

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
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

## Features
List of features ready and TODOs for future development
* Awesome feature 1
* Awesome feature 2
* Awesome feature 3

To-do list:
* Wow improvement to be done 1
* Wow improvement to be done 2

## Status
Project is: _in progress_, _finished_, _no longer continue_ and why?

## Inspiration
Add here credits. Project inspired by..., based on...

## Contact
Created by [@flynerdpl](https://www.flynerd.pl/) - feel free to contact me!




# Zadnie rekrutacyjne
# Budowanie programu
Proces budowy rozpoczynamy wpisując komende w folderze głównym:
mvn clean install
w przybadku braku narzędzia maven można skorzystać z wersji wbudowanej w IntelliJ IDEA.

# Startowanie Aplikacji
Po zakończeniu procesu budowy pojawi się folder target, a w nim plik product-service-0.0.1-SNAPSHOT.jar.
Aplikacjie można wystartować poleceniem:
java -jar product-service-0.0.1-SNAPSHOT.jar
Aplikacjia do działania nie potrzebuje zewnetrznego serwera aplikacyjnego (serwer wbudowany jest w projekt).
Aplikacjia domyślnie uruchamia się na porcie 8080, aby zmienic port nalerzy wpisać wartość portu w pliku application.properties.

# Użytkowanie aplikacji
* Aby wyświetlić produkt po id należy wysłać żądanie GET http://localhost:8080/products?id={n}. 

# Użyte technologie
Spring Boot, Spring Data, Sprig Web,  H2 database, Maven
