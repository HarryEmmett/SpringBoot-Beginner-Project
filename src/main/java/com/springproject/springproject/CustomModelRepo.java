package com.springproject.springproject;

public interface CustomModelRepo {
    void partialUpdate(String productId, String fieldName, Object fieldValue);
}
