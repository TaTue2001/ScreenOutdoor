package com.example.ScreenOutdoor.controller.roomController;


import com.example.ScreenOutdoor.dto.roomDTO.RoomResponse;
import com.example.ScreenOutdoor.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/phong")
@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/{phongId}")
    public ResponseEntity<?> getThongTinPhong(@PathVariable int phongId) {
        return ResponseEntity.ok(roomService.getRoomDetail(phongId));
    }

    @GetMapping("/phong")
    public List<RoomResponse> getDanhSachPhong() {
        return roomService.getAllPhong();
    }

}
