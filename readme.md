# REG KMITL | Java OOP Project
โพรเจกต์แอปพลิเคชั่นสำนักทะเบียน สร้างจาก Java Application

## Account for testing
#### Student
```
Username : Student01
Password : Student1234
```
#### Prof.
```
Username : Prof01
Password : Prof1234
```
#### Admin
```
Username : Admin01
Password : Admin1234
```

## Note
- if project is not work , my database is not available for public access. You can run the project by using your own database by self build project.

## Build | การสร้างโปรเจกต์
### Prerequisites
- [Java 23](https://www.oracle.com/th/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [MariaDB](https://mariadb.org/download/)

I prefet to use IntelliJ IDEA as IDE that can make easy with using maven , but you can use any IDE that supports Java.
### Clone the repository
```bash
git clone git@github.com:REG-KMITL-OOP-Project/REG-KMITL.git
```
### Install Marven dependencies
```bash
cd REG-KMITL
mvn clean install
```

### Setup Dotenv
- Copy the `.env.example` file to `.env` and set the environment variables.

### Setup Database
- Create a database in MariaDB and import the `sql` file located in `/database` to create the tables.

### Run the application
- run the main class `Main.java` in the `/src/main/java/dev/it22/kmitl/reg` package.


## Design
- [Figma](https://www.figma.com/design/bh0zBeAslPtqWXQ6DIwhoF/OOP-%7C-REG-KMITL?node-id=0-1&t=92OoQPucZ0aCexYm-1)
