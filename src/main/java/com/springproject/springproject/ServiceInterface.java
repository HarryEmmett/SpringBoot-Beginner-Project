package com.springproject.springproject;

import java.util.List;

public interface ServiceInterface {

        List<Model> getAllRooms();
        Model getRoomById(String id);
        Model createRoom(Model model);
        void deleteRoomById(String id);
        Model updateRoomById(String id, Model model);
}
