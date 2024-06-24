FROM openjdk
WORKDIR salaf
COPY . .
CMD ["java", "src/Main.java"]
