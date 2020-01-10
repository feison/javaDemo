package com.fei.demo.dao;

import com.fei.demo.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "areaDao")
public interface AreaDao {
    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(int areaId);
}
