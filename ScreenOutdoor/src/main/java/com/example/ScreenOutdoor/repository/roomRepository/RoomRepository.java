package com.example.ScreenOutdoor.repository.roomRepository;

import com.example.ScreenOutdoor.dto.roomDTO.RoomDTO;
import com.example.ScreenOutdoor.dto.roomDTO.RoomResponse;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class RoomRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(RoomRepository.class);
    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<List<Map<String, Object>>> callPhongStoredProcedure(int phongId) {
        List<List<Map<String, Object>>> resultSets = new ArrayList<>();

        jdbcTemplate.execute((ConnectionCallback<Void>) connection -> {
                try (CallableStatement cs = connection.prepareCall("{call sp_get_phong_detail_2(?)}")) {
                cs.setInt(1, phongId);
                boolean hasResult = cs.execute();
                List<Map<String, Object>> resultList = new ArrayList<>();
                int resultSetIndex = 0;
                while (hasResult) {
                    try (ResultSet rs = cs.getResultSet()) {
                        int columnCount = rs.getMetaData().getColumnCount();
                        while (rs.next()) {
                            Map<String, Object> row = new HashMap<>();
                            for (int i = 1; i <= columnCount; i++) {


                                String column = rs.getMetaData().getColumnName(i);
                                row.put(column, rs.getObject(i));
                            }
                            resultList.add(row);
                            log.info(row.toString());
                        }
                    }
                    resultSets.add(resultList);
                    hasResult = cs.getMoreResults();
                }
                log.info("ResultSet [{}]: {}  bản ghi ", resultSetIndex, resultList.size() );

                resultSets.add(resultList);
            }
            return null;
        });

        return resultSets;
    }

    public List<RoomResponse> getAllPhong() {
        String sql = "SELECT id_buong_benh, ten_buong_benh FROM tbl_DM_Buong_Benh ORDER BY ten_buong_benh where ";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new RoomResponse(
                        rs.getInt("id_buong_benh"),
                        rs.getString("ten_buong_benh"),
                        4
                )
        );
    }
}



