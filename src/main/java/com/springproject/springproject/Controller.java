package com.springproject.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        super();
        this.service = service;
    }

    private CustomModelRepoImpl CustomModelRepoImpl;

    @GetMapping("/getAllRooms")
    public ResponseEntity<List<Model>> getRequest() {
        return ResponseEntity.ok(this.service.getAllRooms());
    }

    @GetMapping("/getAvailableRooms")
    public ResponseEntity<List<Model>> getIdRequest() {
        return ResponseEntity.ok(this.service.getRoomByAvailable());
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

    //updates date booked by taking the value for date booked along with the same values for the other fields
    //from the front end as a big model and resaves them all
    @PutMapping("/updateDateBooked/{id}")
    public ResponseEntity<Model> updateDateBookedRequest(@PathVariable String id, @RequestBody Model date) {
        Model update = this.service.updateDate(id, date);
        ResponseEntity<Model> response = new ResponseEntity<Model>(update, HttpStatus.ACCEPTED);
        return response;
    }

    //updates by field
    @PatchMapping("/partialUpdate/{productId}")
    public void partialUpdateProduct(@PathVariable String productId, @RequestBody Model model) throws Exception {
        for(Field field : Model.class.getDeclaredFields() ) {

            String fieldName = field.getName();
            if (fieldName.equals("id")) {
                continue;
            }

            Method getter = Model.class.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
            Object fieldValue = getter.invoke(model);

            if (Objects.nonNull(fieldValue)) {

                this.service.partialUpdate(productId, fieldName, fieldValue);
            }
        }
    }

}
