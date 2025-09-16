from Docker:
- tutorial: https://medium.com/@vitthalchandankar2/creating-a-dockerfile-for-a-spring-boot-application-a-step-by-step-guide-237e84bb37b6

docker build -t mz-producer .

docker run -it --name mz-producer -p 8080:8080 -d mz-producer