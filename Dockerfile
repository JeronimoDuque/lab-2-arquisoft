FROM openjdk:17
EXPOSE 8080
ADD target/lab-02-arq-soft.jar /lab-02-arq-soft.jar
ENTRYPOINT [ "java","-jar","/lab-02-arq-soft.jar" ]