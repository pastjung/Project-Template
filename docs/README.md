# Project-Template

> Initial written at october 10, 2024 <br/>
> last updated at: october 15, 2024


## Current: ver. 1.0.2<br/>
>* ver 1.0.0.
>   * Init: 프로젝트 세팅 ( React + Spring Boot )
>   * CORS 설정
>* ver 1.0.1.
>   * 설정 변경: .gitignore파일에 IntelliJ IDLE 서정 파일 .idea & DB Volume 파일 db-data 추가
>   * Spring Boot: build.gradle 파일에 설명 주석 추가
>   * Spring Boot: application.properties -> application.yml 변경
>   * DB 연결: MySQL, MariaDB, MongoDB
>   * Spring Boot: RDBMS & NOSQL 데이터베이스 사용법 예시 코드 추가
>* ver 1.0.2.
>   * RDBMDS의 QueryDSL 추가 ( MongoDB는 QueryDSL을 자주 사용하지 않아서 RDBMS만 추가함 )

# 1. 프로그램 (프로젝트) 설명

- 본 프로젝트의 운영체제는 Linux OS를 기반으로 작성되었습니다.
- 본 프로젝트는 Spring Security와 JWT를 고려하지 않은 프로젝트 입니다. ( 추후에 Spring Security를 도입할 경우 Filter와 연결해서 고려할 예정입니다. )
- 본 프로젝트는 CORS 설정의 경우 Backend에서 설정하는 것이 바람직하다고 생각하여 Spring Boot 프로젝트에서 설정을 했습니다.

# 2. Prerequisite

- 본 프로젝트는 Docker를 사용하므로 `.env.template` 파일을 참고하여 `.env` 파일에 환경 변수값을 작성해주세요.
    - root, react-app, springboot-app 총 3가지 파일을 모두 작성해주세요.
    - MySQL, MariaDB, MongoDB 중 사용하려는 DB만 작성해주세요.
    - `HOST_PORT` : 외부에서 컨테이너의 애플리케이션에 접근하는데 사용하는 포트 ( 노출되도 괜찮은 포트 )
    - `SERVER_PORT` : 애플리케이션이 컨테이너 내에서 통신하는 포트 ( 노출되면 안되는 포트 )
    - Vite에서는 보안이 필요한 환경변수의 유출을 막기 위해서 `VITE_`으로 시작하지 않는 환경변수는 무시되기 때문에 `VITE_SPRINGBOOT_HOST_PORT`가 필요합니다.
    - `root/.env` : 로컬 환경에서 docker-compose.yml 파일을 실행시키기 위해 필요한 환경 변수 파일입니다.
        ```
        # 예시
        SPRINGBOOT_HOST_PORT=8081
        SPRINGBOOT_SERVER_PORT=8080

        REACT_HOST_PORT=5174
        REACT_SERVER_PORT=5173

        # MySQL
        MYSQL_ROOT_PASSWORD=12345678
        MYSQL_HOST_PORT=3306
        MYSQL_SERVER_PORT=3306
        MYSQL_DATABASE=mydatabase
        MYSQL_USER=my_user
        MYSQL_PASSWORD=1234

        # MariaDB
        MARIADB_ROOT_PASSWORD=12345678
        MARIADB_HOST_PORT=3306
        MARIADB_SERVER_PORT=3306
        MARIADB_DATABASE=mydatabase
        MARIADB_USER=my_user
        MARIADB_PASSWORD=1234

        # MongoDB
        MONGO_INITDB_ROOT_USERNAME=root
        MONGO_INITDB_ROOT_PASSWORD=12345678
        MONGO_INITDB_DATABASE=mydatabase
        MONGODB_HOST_PORT=27017
        MONGODB_SERVER_PORT=27017
        ```
    - `react-app/.env` : React 애플리케이션 환경을 실행시키기 위해 필요한 환경 변수 파일입니다.
        ```
        # 예시
        VITE_REACT_SERVER_PORT=5173
        VITE_SPRINGBOOT_HOST_PORT=8081
        ```
    - `springboot-app/.env` : Springboot 애플리케이션 환경을 실행시키기 위해 필요한 환경 변수 파일입니다.
        ```
        # 예시
        REACT_HOST_PORT=5174
        SPRINGBOOT_SERVER_PORT=8080

        # MYSQL 설정
        MYSQL_HOST=mysql-container
        MYSQL_PORT=3306
        MYSQL_DATABASE=mydatabase
        MYSQL_USER=my_user
        MYSQL_PASSWORD=1234

        # MariaDB 설정
        MARIADB_HOST=mariadb-container
        MARIADB_PORT=3306
        MARIADB_DATABASE=mydatabase
        MARIADB_USER=my_user
        MARIADB_PASSWORD=1234

        # MongoDB 설정
        MONGODB_HOST=mongodb-container
        MONGODB_PORT=27017
        MONGODB_DATABASE=mydatabase
        MONGODB_USER=root
        MONGODB_PASSWORD=12345678
        MONGO_INITDB_AUTHDB=admin
        ```
- 본 프로젝트는 Spring Boot를 사용하므로 `springboot-app/src/main/resources/application.yml.template` 파일을 사용하여 `application.yml` 파일을 생성해주세요. ( 그대로 생성하면 됩니다. )

# 3. 구동 방법

## 3.1. 프로젝트 실행

본 프로젝트는 Docker Compose를 사용하므로 이를 실행시켜주세요.

```shell
(sudo) docker compose up (--build)
```

## 3.2 프로젝트 종료

본 프로젝트는 Docker Compose를 사용하므로 이를 실행시켜주세요.

```shell
(sudo) docker compose down (-v)
```

# 4. 디렉토리 및 파일 설명
```
    /Project-Template
    ├── docs/
    │   ├── PULL_REQUEST_TEMPLATE.md
    │   ├── README.md
    │   └── secrets.png
    │
    ├── react-app/
    │   ├── public/
    │   │   └── vite.svg
    │   ├── src/
    │   │   ├── assets/
    │   │   │   └── vite.svg
    │   │   ├── App.css
    │   │   ├── App.jsx
    │   │   ├── index.css
    │   │   └── main.jsx
    │   │
    │   ├── .env
    │   ├── .env.template
    │   ├── .gitignore
    │   ├── dockerfile
    │   ├── eslint.config.js
    │   ├── index.html
    │   ├── package-lock.json
    │   ├── package.json
    │   ├── README.md
    │   └── vite.config.js
    │
    ├── springboot-app/
    │   ├── gradle/
    │   │   └── wrapper/
    │   │       ├── gradle-wrapper.jar
    │   │       └── gradle-wrapper.properties
    │   ├── src/
    │   │   ├── main/
    │   │   │   ├── java/com/inha/springbootapp/
    │   │   │   │   ├── domain/
    │   │   │   │   │   ├── common/
    │   │   │   │   │   │   ├── controller/
    │   │   │   │   │   │   │   └── HelloController.java
    │   │   │   │   │   │   ├── dto/
    │   │   │   │   │   │   │   ├── CommonResponse.java
    │   │   │   │   │   │   │   └── ExceptionResponse.java
    │   │   │   │   │   │   └── entity/
    │   │   │   │   │   │       └── Timestamped.java
    │   │   │   │   │   └── user/
    │   │   │   │   │       ├── controller/
    │   │   │   │   │       │   └── UserController.java
    │   │   │   │   │       ├── dto/
    │   │   │   │   │       │   ├── requestDto/
    │   │   │   │   │       │   │   └── SignUpRequest.java
    │   │   │   │   │       │   ├── responseDto/
    │   │   │   │   │       │   │   └── SignUpResponse.java
    │   │   │   │   │       │   └── vo/
    │   │   │   │   │       │       └── RDBMSUserVo.java
    │   │   │   │   │       ├── entity/
    │   │   │   │   │       │   ├── MongoDBUser.java
    │   │   │   │   │       │   └── RDBMSUser.java
    │   │   │   │   │       ├── repository/
    │   │   │   │   │       │   ├── noSql/
    │   │   │   │   │       │   │   └── UserRepositoryWithMongoDB.java
    │   │   │   │   │       │   └── rdbms/
    |   │   │   │   │       │       ├── queryDsl/
    |   |   │   │   │       │       │   ├── UserQueryRepository.java
    |   │   │   │   │       │       │   └── UserQueryRepositoryImpl.java
    │   │   │   │   │       │       └── UserRepositoryWithRDBMS.java
    │   │   │   │   │       └── service/
    │   │   │   │   │           └── UserService.java
    │   │   │   │   ├── global
    │   │   │   │   │   ├── config/
    │   │   │   │   │   │   ├── GlobalCorsConfig.java
        │   │   │   │   │   ├── JpaConfig.java
    │   │   │   │   │   │   └── QueryDSLConfig.java
    │   │   │   │   │   └── exception/
    │   │   │   │   │       └── GlobalExceptionHandler.java
    │   │   │   │   └── springbootAppApplication.java
    │   │   │   └── resources/
    │   │   │       ├── application.yml
    │   │   │       ├── application.yml.template
    │   │   │       └── application.properties.template
    │   │   └── test/
    │   │       └── java/com/inha/springbootapp/
    │   │           └── springbootAppApplicationTest.java
    │   │
    │   ├── .env
    │   ├── .env.template
    │   ├── .gitignore
    │   ├── build.gradle
    │   ├── dockerfile
    │   ├── gradlew
    │   ├── gradlew.bat
    │   └── settings.gradle
    │
    ├── .env
    ├── .env.template
    ├── .gitattributes
    ├── .gitignore
    └── docker-compose.yml
```