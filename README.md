# Project Title

Micros service with async play ground 

## Getting Started

Using Intellij, spring boot web starter, H2 and hibernate.

### Prerequisites

Using local port 8080 for REST API and for H2-console.
```
http://localhost:8080/h2-console #connecting to H2 consol
jdbc:h2:mem:MPREST               #URI connection
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Initial test ran the Data Injector to POST Right Triangles
in parallel to using Postman for changing entities, and while
the Async Services were calculating shapes and counting totals. 
```

### And coding style tests

Testing the controller with some Postman request as below:

```
# creating triangles
http://localhost:8080/shapes/rightTriangles
# using json for body as below
{
	"state": 0,
	"edges": [3.0, 4.0]
}
#
# get all shapes
http://localhost:8080/shapes/all
# count
http://localhost:8080/shapes/count
# delete
http://localhost:8080/shapes/100
# update
http://localhost:8080/shapes/2
{
	"state": 1
}


```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Bezalel Bareli** - *Initial work*

