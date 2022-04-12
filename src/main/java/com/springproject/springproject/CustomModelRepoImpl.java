package com.springproject.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;

public class CustomModelRepoImpl implements CustomModelRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void partialUpdate(String productId, String fieldName, Object fieldValue) {

        mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("id").is(productId)),
                BasicUpdate.update(fieldName, fieldValue), FindAndModifyOptions.none(), Model.class);

    }
}
