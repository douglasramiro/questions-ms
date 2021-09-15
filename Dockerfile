FROM public.ecr.aws/x6x7c6a7/custom-java:latest
MAINTAINER Douglas Ramiro <douglars@amazon.com>
COPY questions-ms-app/target/questions-ms-app.jar questions-ms-app.jar
ENTRYPOINT ["java","-jar","/questions-ms-app.jar"]