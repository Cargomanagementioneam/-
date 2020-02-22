package com.freightyard.project.business.cargoworkManagement.controller;

import com.freightyard.project.base.result.Result;
import com.freightyard.project.business.cargoworkManagement.service.LoadingUnloadingVehicleService;
import com.freightyard.project.business.common.dao.LoadingUnloadingVehicleMapper;
import com.freightyard.project.business.common.modal.LoadingUnloadingVehicle;
import com.freightyard.project.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="装卸车接口")
@RestController
@RequestMapping("LoadingUnloadingVehicleController")
public class LoadingUnloadingVehicleController {
    @Autowired
    LoadingUnloadingVehicleService loadingUnloadingVehicleService;

    @Autowired
    LoadingUnloadingVehicleMapper loadingUnloadingVehicleMapper;

    @ApiOperation(value = "查询全部出车信息")
    @GetMapping("selectLoadingUnloadingVehicleAll")
    public Result selectLoadingUnloadingVehicleAll(){
        return Result.result(loadingUnloadingVehicleMapper.selectAll());
    }

    @ApiOperation(value = "自定义分页查询出车信息")
    @PostMapping("selectLoadingUnloadingVehicleByObject")
    public Result selectLoadingUnloadingVehicleByObject(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestBody LoadingUnloadingVehicle loadingUnloadingVehicle){
        PageUtils pageUtils=new PageUtils();
        pageUtils.setDataList(loadingUnloadingVehicleService.selectLoadingUnloadingVehicleByObject(loadingUnloadingVehicle));
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        return Result.result(pageUtils.paging());
    }

    @ApiOperation(value = "修改出车记录")
    @PutMapping("updateLoadingUnloadingVehicle")
    public Result updateLoadingUnloadingVehicle(@RequestBody LoadingUnloadingVehicle loadingUnloadingVehicle){
        return Result.result(loadingUnloadingVehicleService.updateLoadingUnloadingVehicle(loadingUnloadingVehicle),"修改成功","修改失败");
    }

    @ApiOperation(value = "删除出车记录")
    @DeleteMapping("deleteLoadingUnloadingVehicle/{luvId}")
    public Result deleteLoadingUnloadingVehicle(@PathVariable Integer luvId){
        return Result.result(loadingUnloadingVehicleService.deleteLoadingUnloadingVehicle(luvId),"删除成功","删除失败");
    }

    @ApiOperation(value = "新增出车记录")
    @PostMapping("insertLoadingUnloadingVehicles")
    public Result insertLoadingUnloadingVehicles( @RequestBody LoadingUnloadingVehicle loadingUnloadingVehicle){
        return Result.result(loadingUnloadingVehicleService.insertLoadingUnloadingVehicles(loadingUnloadingVehicle),"新增成功","新增失败");
    }
}
