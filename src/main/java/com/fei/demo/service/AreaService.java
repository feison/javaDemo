package com.fei.demo.service;

import com.fei.demo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea();

    Area queryAreaById(int areaId);

    boolean insertArea(Area area);

    boolean updateArea(Area area);

    boolean deleteArea(int areaId);
}
