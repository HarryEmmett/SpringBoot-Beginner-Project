package com.springproject.springproject;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository <Model, String> {

}
