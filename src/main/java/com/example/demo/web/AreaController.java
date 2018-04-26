package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(value = "/list")
    public Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.queryArea();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @GetMapping(value = "/getOne")
    public Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        Area list = areaService.queryAreaById(areaId);
        modelMap.put("area", list);

        return modelMap;
    }

    @PostMapping(value = "/add")
    public Map<String, Object> add(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }

    @PostMapping(value = "/update")
    public Map<String, Object> update(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.updateArea(area));
        return modelMap;
    }

    @PostMapping(value = "/delete")
    public Map<String, Object> del(@RequestBody Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
