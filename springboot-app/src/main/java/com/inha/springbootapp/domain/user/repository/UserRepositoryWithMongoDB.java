package com.inha.springbootapp.domain.user.repository;

import com.inha.springbootapp.domain.user.entity.MongoDBUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryWithMongoDB extends MongoRepository<MongoDBUser, ObjectId> {
    MongoDBUser findByUserName(String checkUserName);
}
