package com.example.ScreenOutdoor.service;

import com.example.ScreenOutdoor.dto.roomDTO.*;
import com.example.ScreenOutdoor.repository.roomRepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
//@Slf4j
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    private static final Logger log = LoggerFactory.getLogger(RoomService.class);
    public RoomDTO getRoomDetail(int phongId) {
        RoomDTO response = new RoomDTO();
        try {
            List<List<Map<String, Object>>> resultSets = roomRepository.callPhongStoredProcedure(phongId);
            if (!resultSets.isEmpty()) {
                List<Map<String, Object>> roomInfoList = resultSets.get(0);
                if (!roomInfoList.isEmpty()) {
                    Map<String, Object> roomInfo = roomInfoList.get(0);

                    response.setPhongId((Integer) roomInfo.get("phongId"));
                    response.setTenPhong((String) roomInfo.get("tenPhong"));
                    response.setSoGiuong(4);

                    StaffDTO bacSi = new StaffDTO();
                    bacSi.setId_nhanvienyte(roomInfo.get("bacSiId") != null ? (Integer) roomInfo.get("bacSiId") : 0);
                    bacSi.setTen_nhanvien(roomInfo.get("bacSiTen")!= null ?(String) roomInfo.get("bacSiTen"): "");
                    bacSi.setChucdanh(roomInfo.get("bacSiChucDanh") != null ?  roomInfo.get("bacSiChucDanh").toString(): "");
                    bacSi.setSdt(roomInfo.get("bacSiSDT")!= null ? roomInfo.get("bacSiSDT").toString(): "");
                    bacSi.setImages(roomInfo.get("bacSiAnh")!= null ? (String) roomInfo.get("bacSiAnh"):"");
                    response.setBacSyPhuTrach(bacSi);

                    StaffDTO dieuDuong = new StaffDTO();
                    dieuDuong.setId_nhanvienyte(roomInfo.get("ddId") != null ?   (Integer) roomInfo.get("ddId"):0);
                    dieuDuong.setTen_nhanvien(roomInfo.get("ddTen")  != null ?  (String) roomInfo.get("ddTen"):"");
                    dieuDuong.setChucdanh(roomInfo.get("ddChucDanh") != null ?   (String) roomInfo.get("ddChucDanh").toString():"");
                    dieuDuong.setSdt(roomInfo.get("ddSdt")!= null ? roomInfo.get("ddSdt").toString(): "");
                    dieuDuong.setImages(roomInfo.get("ddAnh") != null ?  (String) roomInfo.get("ddAnh"):"");
                    response.setDieuDuongPhuTrach(dieuDuong);
                }

                // Giường
                List<Map<String, Object>> giuongListRaw = resultSets.size() > 1 ? resultSets.get(1) : new ArrayList<>();
                List<BedDTO> giuongList = new ArrayList<>();

                for (Map<String, Object> row : giuongListRaw) {
                    BedDTO giuong = new BedDTO();

                    giuong.setId_giuongbenh(row.get("giuongId") != null ? (Integer) row.get("giuongId") : 0);
                    String tenGiuong = (String) row.get("tenGiuong");
                    if (tenGiuong != null && tenGiuong.contains("(")) {
                        int index = tenGiuong.indexOf('(');
                        if (index>=0) {
                            giuong.setTen_giuongbenh(tenGiuong.substring(0, index).trim());
                        }
                        else {
                            giuong.setTen_giuongbenh(tenGiuong.substring(0, 3).trim());
                        }
                    } else {
                        giuong.setTen_giuongbenh(tenGiuong != null ? tenGiuong : "");
                    }
                    if (row.get("tenBenhNhan") != null) {
                        PatientDTO benhNhan = new PatientDTO();
                        benhNhan.setMa_benhnhan(row.get("benhNhanId") != null ?(String) row.get("benhNhanId"):"");
                        benhNhan.setTen_benhnhan(row.get("tenBenhNhan")!= null ? (String) row.get("tenBenhNhan"):"");
                        benhNhan.setTuoi(row.get("tuoi") != null ?(Integer) row.get("tuoi"):1);
                        benhNhan.setGioitinh(row.get("Gioitinh")!= null ?(String) row.get("Gioitinh"):"");
                        benhNhan.setDiachi(row.get("Dia_chi")!= null ?(String) row.get("Dia_chi"):"");

                        Object ngayNhapVien = row.get("ngayNhapVien");
                        if (ngayNhapVien instanceof java.sql.Timestamp) {
                            benhNhan.setNgaynhapvien(new Date(((Timestamp) ngayNhapVien).getTime()));
                        }

                        Object ngaySinh = row.get("Ngay_sinh");
                        if (ngaySinh instanceof java.sql.Timestamp) {
                            benhNhan.setNgaysinh(new Date(((Timestamp) ngaySinh).getTime()));
                        }

                        giuong.setPatient(benhNhan);
                    } else {
                        giuong.setPatient(null);
                    }
                    if(giuong.id_giuongbenh != 0){
                        giuongList.add(giuong);
                    }
                }
                response.setGiuongList(giuongList);
            }
        } catch (Exception e) {
            log.error("Lỗi khi lấy thông tin phòng ID {}: {}", phongId, e.getMessage(), e);
            response.setPhongId(phongId);
            response.setTenPhong("  ");

            StaffDTO bacSi = new StaffDTO();
            bacSi.setTen_nhanvien("Chưa có bác sĩ phụ trách");
            bacSi.setChucdanh("");
            response.setBacSyPhuTrach(bacSi);

            StaffDTO dieuDuong = new StaffDTO();
            dieuDuong.setTen_nhanvien("Chưa có điều dưỡng phụ trách");
            dieuDuong.setChucdanh("");
            response.setDieuDuongPhuTrach(dieuDuong);

            response.setGiuongList(Collections.emptyList());
        }
        return response;
    }

    public List<RoomResponse> getAllPhong() {
        return roomRepository.getAllPhong();

    }
}