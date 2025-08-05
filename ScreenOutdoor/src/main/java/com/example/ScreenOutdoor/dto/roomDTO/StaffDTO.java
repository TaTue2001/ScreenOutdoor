package com.example.ScreenOutdoor.dto.roomDTO;
import lombok.*;


public class StaffDTO {
    public int id_nhanvienyte;
    public String ten_nhanvien;
    public String chucdanh;
    public String images;
    public String sdt;

    public StaffDTO(int id_nhanvienyte, String ten_nhanvien, String chucdanh, String images, String sdt) {
        this.id_nhanvienyte = id_nhanvienyte;
        this.ten_nhanvien = ten_nhanvien;
        this.chucdanh = chucdanh;
        this.images = images;
        this.sdt = sdt;
    }

    public StaffDTO() {
    }

    public int getId_nhanvienyte() {
        return id_nhanvienyte;
    }

    public void setId_nhanvienyte(int id_nhanvienyte) {
        this.id_nhanvienyte = id_nhanvienyte;
    }

    public String getTen_nhanvien() {
        return ten_nhanvien;
    }

    public void setTen_nhanvien(String ten_nhanvien) {
        this.ten_nhanvien = ten_nhanvien;
    }

    public String getChucdanh() {
        return chucdanh;
    }

    public void setChucdanh(String chucdanh) {
        this.chucdanh = chucdanh;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}