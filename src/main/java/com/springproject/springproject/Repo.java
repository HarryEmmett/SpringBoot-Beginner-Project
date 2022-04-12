package com.springproject.springproject;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Repo extends MongoRepository <Model, String>, CustomModelRepo {
    @Query(value="{ 'orderDate' : null }")
    List<Model> getAvailable();

}
