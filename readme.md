#File Processor
Application to parse and store the content of a kind of csv to `MySQL` database. Built using 
JAVA and has highlights listed below:
1. Parallel ingestion in DB using Executors
2. Batch ingestion/update to gain performance
3. Application Dockerized along with the MySQL db (not in a best way)

## Installation
### Running on local machine
1. Login to MySql using command `mysql -u root -p` (enter password then)
2. Create tables using db-init.sql file with command: `mysql -u root -p postman < large-file-processor/conf/db-init.sql`
3. Clone this repo and cd to the project directory
4. Build application using comman `mvn clean install` 
    - Check your maven installation it could be different command like maven instead of mvn
5. Run Application using command: `java -jar target/large-file-processor-1.0-SNAPSHOT.jar `

#### Docker Setup and Running Application
1. Follow 3 & 4 steps defined above
2. docker-compose.yml has both the services mysql and large-file-processor
3. Build application using command: `docker-compose build`
4. Run application setup using command: `docker-compose up -d`
5. Shutdown application setup using command: `docker-compose down`

##Result
Number of products: 466693
Aggregation result count: 
### On running on local machine [MacBook with RAM: 8 GB, 2.7 GHz Intel Core i5]
1. Average data ingestion time = ~6sec
2. Average aggregation and storing result to another table = ~12 sec

### On running docker [on machine MacBook with RAM: 8 GB, 2.7 GHz Intel Core i5]
1. Average data ingestion time = ~13sec
2. Average aggregation and storing result to another table = ~28 sec

##Assumptions
1. SKUs are unique to product so any new details of the existing SKU will get updated and 
the incoming data will take the priority.
2. aggregation table has index on product_name
2. CSV file should bundle in docker image. (This is not a good idea.) 

## Improvements
1. Code level
    1. Make batch size and number or threads configurable via properties and env.
    2. Aggregation job should be run separately not just on completion of ingestion at a 
    regular interval or on trigger base.
    3. Data file (products.csv) shouldn't be packed with docker image. One way to avoid this
    is to look into a DB for incoming ingestino request along with path of some external source
    like s3, then download that file to local storage, do the ingestion and delete file.
    4. Error handling in case of failure from DB.
2. DB init can be added to the mysql build.