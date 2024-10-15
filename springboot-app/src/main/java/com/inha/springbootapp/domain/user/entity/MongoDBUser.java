package com.inha.springbootapp.domain.user.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class MongoDBUser {

    @Id // ID 필드에 값이 할당되지 않으면 MongoDB가 자동으로 ObjectId를 생성
    private ObjectId userId;

    @NotNull(message = "Username cannot be null")
    @Indexed(unique = true)
    private String userName;

    private String email;
}
