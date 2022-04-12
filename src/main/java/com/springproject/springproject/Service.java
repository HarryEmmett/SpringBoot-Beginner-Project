package com.springproject.springproject;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface {

    private Repo repo;

    @Autowired
    public Service(Repo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Model> getAllRooms() {
        return this.repo.findAll();
    }

    @Override
    public Model getRoomById(String id) {
        Optional<Model> roomById = this.repo.findById(id);
        return roomById.get();
    }

    @Override
    public Model createRoom(Model model) {
        return this.repo.save(model);
    }

    @Override
    public void deleteRoomById(String id) {
        this.repo.deleteById(id);
    }

    @Override
    public Model updateRoomById(String id, Model model) {
        Model updateItem = this.repo.findById(id).get();
        updateItem.setCapacity(model.getCapacity());
        updateItem.setRoomNo(model.getRoomNo());
        updateItem.setImgUrl(model.getImgUrl());
        updateItem.setRoomPrice(model.getRoomPrice());
        updateItem.setLocation(model.getLocation());
        updateItem.setDescription(model.getDescription());
        updateItem.setTitle(model.getTitle());

        return this.repo.save(updateItem);
    }

    @Override
    public List<Model> getRoomByAvailable() {
        return this.repo.getAvailable();
    }

    @Override
    public Model updateDate(String id, Model model) {

            Model updateItem = this.repo.findById(id).get();

            updateItem.setCapacity(model.getCapacity());
            updateItem.setRoomNo(model.getRoomNo());
            updateItem.setImgUrl(model.getImgUrl());
            updateItem.setRoomPrice(model.getRoomPrice());
            updateItem.setLocation(model.getLocation());
            updateItem.setDescription(model.getDescription());
            updateItem.setTitle(model.getTitle());
            updateItem.setOrderDate(model.getOrderDate());

            return this.repo.save(updateItem);

    }

    @Override
    public void partialUpdate(String productId, String fieldName, Object fieldValue) {
        this.repo.partialUpdate(productId, fieldName, fieldValue);
    }
}

