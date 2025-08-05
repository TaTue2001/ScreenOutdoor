package com.example.ScreenOutdoor.dto.roomDTO;

import lombok.*;

public class RoomResponse {
    private int phongId;
    private String tenPhong;
    private int soGiuong;

    public RoomResponse(int phongId, String tenPhong, int soGiuong) {
        this.phongId = phongId;
        this.tenPhong = tenPhong;
        this.soGiuong = soGiuong;
    }

    public RoomResponse() {
    }

    public int getPhongId() {
        return phongId;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }
}
