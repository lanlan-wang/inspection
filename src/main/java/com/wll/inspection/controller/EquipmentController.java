package com.wll.inspection.controller;


import com.github.pagehelper.PageInfo;
import com.wll.inspection.VO.ResultVO;
import com.wll.inspection.accessctro.RoleControl;
import com.wll.inspection.dao.Company;
import com.wll.inspection.dao.Equipment;
import com.wll.inspection.enums.RoleEnum;
import com.wll.inspection.service.EquipmentService;
import com.wll.inspection.utils.PageRequest;
import com.wll.inspection.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "巡检设备")
@RequestMapping("/equipment")
@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class EquipmentController {
    @Autowired
    EquipmentService  equipmentService;

    @GetMapping("/deleteEquipment/{Id}")
    @ApiOperation("删除设备")
    public ResultVO delEquipment(@PathVariable Long Id){
        return equipmentService.deleteEquipment(Id) ;
    }

    @PostMapping("/addEquipment")
    @ApiOperation("添加设备")
    public ResultVO addEquipment(@RequestBody Equipment equipment){
        return equipmentService.addEquipment(equipment);
    }

    @GetMapping("/selectEquipment/{Id}")
    @ApiOperation("通过Id查找设备")
    public ResultVO selectEquipment(@PathVariable Long Id){
        return equipmentService.selectById(Id);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查找所有的设备")
    public ResultVO selectAll(){
        return equipmentService.selectAll();
    }

    @ApiOperation("分页查询")
    @GetMapping("/testPageHelper1/{pageNum}/{pageSize}")
    public PageInfo<Equipment> testPageHelper1(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo<Equipment> queryResult = equipmentService.findAllUserByPageS(pageNum, pageSize);
        return queryResult;
    }

    @PostMapping("/update")
    @ApiOperation("更新设备")
    public ResultVO update(@RequestBody Equipment equipment){
        return equipmentService.update(equipment);
    }
}
