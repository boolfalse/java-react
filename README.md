
## Java & React.js app



#### About:

- This is a simple Java Spring boot & React.js full-stack app.



#### Setup:

- [Optional] Setup [`Maven`](https://maven.apache.org/download.cgi).
```shell
# maven: download, extract and move to the executable folder
wget https://dlcdn.apache.org/maven/maven-3/3.9.3/binaries/apache-maven-3.9.3-bin.tar.gz
tar -xvf apache-maven-3.9.3-bin.tar.gz
sudo mv apache-maven-3.6.3 /opt/

# publish maven path
export PATH="$PATH:/opt/apache-maven-3.9.3/bin"

# set maven path to the default usable programs
nano ~/.bashrc
# add the line
PATH="$PATH:/opt/apache-maven-3.9.3/bin"
# reload the terminal or apply the changes
source ~/.bashrc
```

- Setup _.env_ credentials as described in _.env.example_ in _src/main/resources/_ folder.

- Run the backend:
```shell
mvn spring-boot:run
```

- Install client dependencies:
```shell
npm install --prefix=client/
```
- Run the client
```shell
npm run start --prefix=client/
```



#### Resources:

- Postman [Collection](https://documenter.getpostman.com/view/1747137/2s9XxtxFaS)
- freeCodeCamp video: [Full Stack Development with Java Spring Boot, React, and MongoDB – Full Course](https://www.youtube.com/watch?v=5PdEmeopJVQ)
- freeCodeCamp article: [Full Stack Development with MongoDB, Java, and React](https://www.freecodecamp.org/news/full-stack-development-with-mongodb-java-and-react/)
- [Java JDK download](https://www.oracle.com/java/technologies/downloads/)
- [Spring Initializr](https://start.spring.io/)
- [Spring backend](https://github.com/fhsinchy/movieist)
- Install [me.paulschwarz/spring-dotenv](https://mvnrepository.com/artifact/me.paulschwarz/spring-dotenv)
- [How to Install Maven on Linux](https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu)



#### Author:

- [BoolFalse](https://boolfalse.com/)
