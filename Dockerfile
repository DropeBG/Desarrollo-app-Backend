from openjdk:22-jdk
 
workdir /app
 
copy  app/build/libs/EVC2-0.0.1-SNAPSHOT.jar /app/EVC2-0.0.1-SNAPSHOT.jar
 
cmd ["java", "-jar", "EVC2-0.0.1-SNAPSHOT.jar"]