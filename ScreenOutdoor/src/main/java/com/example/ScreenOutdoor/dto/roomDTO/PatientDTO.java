package com.example.ScreenOutdoor.dto.roomDTO;

import lombok.*;

import java.sql.Date;
//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class PatientDTO {
    public String ma_benhnhan;
    public String ten_benhnhan;
    public int tuoi;
    public Date ngaysinh;
    public String gioitinh;
    public Date ngaynhapvien;
    public String diachi;

    public PatientDTO() {
    }

    public PatientDTO(String ma_benhnhan, String ten_benhnhan, int tuoi, Date ngaysinh, String gioitinh, Date ngaynhapvien, String diachi) {
        this.ma_benhnhan = ma_benhnhan;
        this.ten_benhnhan = ten_benhnhan;
        this.tuoi = tuoi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.ngaynhapvien = ngaynhapvien;
        this.diachi = diachi;
    }

    public String getMa_benhnhan() {
        return ma_benhnhan;
    }

    public String getTen_benhnhan() {
        return ten_benhnhan;
    }

    public int getTuoi() {
        return tuoi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public Date getNgaynhapvien() {
        return ngaynhapvien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setMa_benhnhan(String ma_benhnhan) {
        this.ma_benhnhan = ma_benhnhan;
    }

    public void setTen_benhnhan(String ten_benhnhan) {
        this.ten_benhnhan = ten_benhnhan;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgaynhapvien(Date ngaynhapvien) {
        this.ngaynhapvien = ngaynhapvien;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
