package com.inha.springbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cdimascio.dotenv.Dotenv;

// import javax.sql.DataSource;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.sql.Connection;
// import java.sql.DatabaseMetaData;
// import java.sql.SQLException;

// 컨트롤러에서 CORS를 개별적으로 설정하는 방법
// @CrossOrigin(origins = "http://localhost:3001") // React 애플리케이션의 URL
@RestController
@RequestMapping("/api")
public class HelloController {

    Dotenv dotenv = Dotenv.load();
    private final String reactURL = "http://localhost:" + dotenv.get("REACT_HOST_PORT");

    // @Autowired
    // private DataSource dataSource; // MariaDB와 MySQL은 동일한 JDBC 드라이버를 사용하기 때문에, 하나의 DataSource를 통해 두 데이터베이스에 연결할 수 있다.

    // @GetMapping("/health/RDBMS")
    // public String pingRDBMS() {
    //     try (Connection connection = dataSource.getConnection()) {
    //         DatabaseMetaData metaData = connection.getMetaData();   // IP주소와 포트를 가져오기 위한 메타데이터
    //         String url = metaData.getURL();                         // JDBC URL에서 IP 주소와 포트를 얻기
    //         return "RDBMS: Connected - " + url;
    //     } catch (SQLException e) {
    //         return "RDBMS: Not Connected - " + e.getMessage();
    //     }
    // }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello: " + reactURL;
    }
}