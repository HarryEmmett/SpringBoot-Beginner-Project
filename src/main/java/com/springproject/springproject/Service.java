package com.springproject.springproject;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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

        return this.repo.save(updateItem);
    }
}

