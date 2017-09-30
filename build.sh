cd commons && ./mvnw  clean install && cd .. &&
cd discovery && ./mvn clean install && cd .. &&
cd gateway && ./mvn clean install && cd .. &&
cd notes && ./mvn clean install && cd .. &&
cd security && ./mvn clean install && cd .. &&
cd users && ./mvn clean install && cd ..

#todo check why this is not working under java 9