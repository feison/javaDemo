package com.example.demo.service.impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaDao areaDao;

    public AreaServiceImpl(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if (area.getAreaName() == null || "".equals(area.getAreaName())) {
            throw new RuntimeException("插入失败:信息为空");
        }
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        try {
            int effectedNumber = areaDao.insertArea(area);
            if (effectedNumber > 0) {
                return true;
            }
            throw new RuntimeException("插入失败");
        } catch (Exception e) {
            throw new RuntimeException("插入失败:" + e.getMessage());
        }
    }

    @Override
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int effectedNumber = areaDao.updateArea(area);
                if (effectedNumber > 0) {
                    return true;
                }
                throw new RuntimeException("更新失败");
            } catch (Exception e) {
                throw new RuntimeException("更新失败:" + e.getMessage());
            }
        }
        throw new RuntimeException("更新失败:信息为空");
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNumber = areaDao.deleteArea(areaId);
                if (effectedNumber > 0) {
                    return true;
                }
                throw new RuntimeException("删除失败");
            } catch (Exception e) {
                throw new RuntimeException("删除失败:" + e.getMessage());
            }
        }
        throw new RuntimeException("删除失败:信息为空");
    }
}
