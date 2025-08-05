package com.example.ScreenOutdoor.dto.roomDTO;


public class BedDTO {
    public int id_giuongbenh;
    public String ten_giuongbenh;
    public PatientDTO patient;

    public BedDTO() {
    }

    public BedDTO(int id_giuongbenh, String ten_giuongbenh, PatientDTO patient) {
        this.id_giuongbenh = id_giuongbenh;
        this.ten_giuongbenh = ten_giuongbenh;
        this.patient = patient;
    }

    public int getId_giuongbenh() {
        return id_giuongbenh;
    }

    public String getTen_giuongbenh() {
        return ten_giuongbenh;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setId_giuongbenh(int id_giuongbenh) {
        this.id_giuongbenh = id_giuongbenh;
    }

    public void setTen_giuongbenh(String ten_giuongbenh) {
        this.ten_giuongbenh = ten_giuongbenh;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}