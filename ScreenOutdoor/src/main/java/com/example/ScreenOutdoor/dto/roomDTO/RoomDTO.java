package com.example.ScreenOutdoor.dto.roomDTO;
import java.util.List;


public class RoomDTO {
    private int phongId;
    private String tenPhong;
    private StaffDTO bacSyPhuTrach;
    private StaffDTO dieuDuongPhuTrach;
    private List<BedDTO> giuongList;
    private int soGiuong;
    private StaffDTO bacSyPhuTrach2;
    private StaffDTO dieuDuongPhuTrach2;


    public RoomDTO() {
    }

    public RoomDTO(int phongId, String tenPhong, StaffDTO bacSyPhuTrach, StaffDTO dieuDuongPhuTrach, List<BedDTO> giuongList, StaffDTO bacSyPhuTrach2, StaffDTO dieuDuongPhuTrach2, int soGiuong) {
        this.phongId = phongId;
        this.tenPhong = tenPhong;
        this.bacSyPhuTrach = bacSyPhuTrach;
        this.dieuDuongPhuTrach = dieuDuongPhuTrach;
        this.giuongList = giuongList;
        this.bacSyPhuTrach2 = bacSyPhuTrach2;
        this.dieuDuongPhuTrach2 = dieuDuongPhuTrach2;
        this.soGiuong = soGiuong;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public StaffDTO getBacSyPhuTrach() {
        return bacSyPhuTrach;
    }

    public void setBacSyPhuTrach(StaffDTO bacSyPhuTrach) {
        this.bacSyPhuTrach = bacSyPhuTrach;
    }

    public StaffDTO getDieuDuongPhuTrach() {
        return dieuDuongPhuTrach;
    }

    public void setDieuDuongPhuTrach(StaffDTO dieuDuongPhuTrach) {
        this.dieuDuongPhuTrach = dieuDuongPhuTrach;
    }

    public List<BedDTO> getGiuongList() {
        return giuongList;
    }

    public void setGiuongList(List<BedDTO> giuongList) {
        this.giuongList = giuongList;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public StaffDTO getBacSyPhuTrach2() {
        return bacSyPhuTrach2;
    }

    public void setBacSyPhuTrach2(StaffDTO bacSyPhuTrach2) {
        this.bacSyPhuTrach2 = bacSyPhuTrach2;
    }

    public StaffDTO getDieuDuongPhuTrach2() {
        return dieuDuongPhuTrach2;
    }

    public void setDieuDuongPhuTrach2(StaffDTO dieuDuongPhuTrach2) {
        this.dieuDuongPhuTrach2 = dieuDuongPhuTrach2;
    }
}

