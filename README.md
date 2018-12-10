# Distributed-Systems-Project-
JAX-RS web based application using a REST web based service  and database with SQL.

# Steps required to run application

Step 1: SQL database

You will need wampserver3.1.4_x64 in order to run the sql database. Use the Bookings.sql file located in the SQL Database folder for this example. When the wamp executable is being run, head to hidden icons. Click on wamp and hover over MySQL and then select mysql console. No password is required in the console. Paste in the sql code provided in command line to setup the bookings database. Important: Keep the console running for the duration of the project runtime.

Step2: RMI and JAX-RS

The RMI Project is a standard java project. it will be used to establish a connection with the sql database. Run this as a java application in order for the server to begin.

JAX-RS required different steps. When creating the maven project, the archtype must be set to:

Group Id: org.glassfish.jersey.archtypes
Artifact ID: jersey-quickstart-webapp
Version 2.16

This will setup the jax-rs project. Also included is the myswl-connector jar file to help build the connection.

Step 3: Tomcat Server

In the server tab you will need to add tomcat as well as the directory location on your machine. This will help establish the server. 

When the rmi is being run, the JAX-RS project can then be run on server to open the web client. 

