Nothing fancy here, just an example Spring Boot app, to brush up

## Requisites
* Java 8+   
* Apache Maven 3.6+
* Postman 6.7+ (Optional)

## Install
In order to start the application run command below in root dir
> ./mvnw spring-boot:run


## Usage!
When you run this app you can access its features using several RESTful endpoints. This app exposes HATEOAS endpoints.

###### Endpoints
* <a href="http://localhost:8080/cities/search/name?q=London" target="_blank">http://localhost:8080/cities/search/name?q=London</a> - returns a list of cities with London in their name. Ignoring case sensitivity.
* <a href="http://localhost:8080/cities/search/country?q=United%20States" target="_blank">http://localhost:8080/cities/search/country?q=United%20States</a> - return a list of cities in United States. Ignoring case sensitivity.

###### Usage & Examples
This app apply pagination and sorting. You can use **size**, **page**, **sort** parameters to get custom pagiantion and sorting. Default page size is 20. Under the "page" attribute you can find information about the page, and under "_links" attribute you can find links for the next/previous pages etc..

* <a href="http://localhost:8080/cities/search/country?q=United%20States" target="_blank">http://localhost:8080/cities/search/country?q=United%20States</a> - returns a single page JSON listing cities (20 cities in a page)
* <a href="http://localhost:8080/cities/search/country?q=United%20States&page=2&size=5" target="_blank">http://localhost:8080/cities/search/country?q=United%20States&page=2&size=5</a> - returns only FIVE results from the SECOND page
* <a href="http://localhost:8080/cities/search/country?q=United%20States&size=5&sort=name,asc" target="_blank">http://localhost:8080/cities/search/country?q=United%20States&size=5&sort=name,asc</a> - returns FIVE results sorted by name in ascending order
* <a href="http://localhost:8080/cities/search/nameContains?q=Lon&size=3" target="_blank">http://localhost:8080/cities/search/nameContains?q=Lon&size=3</a> - returns the first three results of the search to find any cities with a name containing the word "Lon" (case insensitive search)

###### Get status of app
* <a href="http://localhost:8080/actuator/health" target="_blank">http://localhost:8080/actuator/health</a> - This returns the current health of the app, it is provided by Spring Boot Actuator.

## Architecture

This app uses ***Spring Data REST***. Spring Data REST is part of the umbrella Spring Data project and makes it easy to build hypermedia-driven REST web services on top of Spring Data repositories.
Spring Data REST builds on top of Spring Data repositories, analyzes your application’s domain model and exposes hypermedia-driven HTTP resources for aggregates contained in the model.
At runtime, Spring Data REST automatically creates an implementation of ***CityRepository***. Then it uses the @RepositoryRestResource, and @RestResource annotations to direct Spring MVC to create RESTful endpoints. CityRepository also extends from PagingAndSortingRepository which is extension of CrudRepository(Interface for generic CRUD operations on a repository for a specific type) to provide additional methods to retrieve entities using the pagination and sorting abstraction. <a href="https://spring.io/guides/gs/accessing-data-rest/" target="_blank">more</a>


***Flyway*** is the choise of migration tool. Flyway strongly favors simplicity and convention over configuration. DB scripts located under /resources/db/migration/ .

***H2 Database*** is used in test and runtime.

## Tests
Sprign Data REST entities are cumbersome to Mock/Spy, hence to test. On the other side considering with Spring Data REST there is not much coding done, which makes unit test less favorable. Considering that Integration test with preloaded DB implemented in this app. I opted start server to run test but there is another useful approach which is to not start the server at all but to test only the layer below that. <a href="https://spring.io/guides/gs/testing-web/" target="_blank">more</a> 

## More
You can use cities.posman_collection.json for example queries if you have postman installed. Also the file is human readable without postman app. 

City database added from https://simplemaps.com/data/world-cities
