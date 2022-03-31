package com.springproject.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        super();
        this.service = service;
    }

    @GetMapping("/getAllRooms")
    public ResponseEntity<List<Model>> getRequest() {
        return ResponseEntity.ok(this.service.getAllRooms());
    }

    @GetMapping("/getRoomBy/{id}")
    public ResponseEntity<Model> getIdRequest(@PathVariable String id) {
        return ResponseEntity.ok(this.service.getRoomById(id));
    }

    @PostMapping("/createNewRoom")
    public ResponseEntity<Model> createRequest(@RequestBody Model model) {
        Model created = this.service.createRoom(model);
        ResponseEntity<Model> response = new ResponseEntity<Model>(created, HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<Model> deleteRequest(@PathVariable String id) {
        this.service.deleteRoomById(id);
        ResponseEntity<Model> response = new ResponseEntity<Model>(HttpStatus.NO_CONTENT);
        return response;
    }

    @PutMapping("/updateBy/{id}")
    public ResponseEntity<Model> updateRequest(@PathVariable String id, @RequestBody Model model) {
        Model update = this.service.updateRoomById(id, model);
        ResponseEntity<Model> response = new ResponseEntity<Model>(update, HttpStatus.ACCEPTED);
        return response;
    }

}
