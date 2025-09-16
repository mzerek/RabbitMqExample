from Docker:
- tutorial: https://medium.com/@vitthalchandankar2/creating-a-dockerfile-for-a-spring-boot-application-a-step-by-step-guide-237e84bb37b6

docker build -t mz-consumer .

docker run -it --name mz-consumer -p 8081:8081 -d mz-consumer