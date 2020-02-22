package com.freightyard.project.business.cargoworkManagement.controller;

import com.freightyard.project.base.result.Result;
import com.freightyard.project.business.cargoworkManagement.service.CargoYardDriveoutService;
import com.freightyard.project.business.common.dao.CargoYardDriveoutMapper;
import com.freightyard.project.business.common.modal.CargoYardDriveout;
import com.freightyard.project.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="货场出车接口")
@RestController
@RequestMapping("CargoYardDriveoutController")
public class CargoYardDriveoutController {

    @Autowired
    CargoYardDriveoutService cargoYardDriveoutService;

    @Autowired
    CargoYardDriveoutMapper cargoYardDriveoutMapper;


    @ApiOperation(value = "查询全部出车信息")
    @GetMapping("selectCargoYardDriveoutAll")
    public Result cargoyarddriveroutList(){
        return Result.result(cargoYardDriveoutMapper.selectAll());
    }

    @ApiOperation(value = "自定义分页查询出车信息")
    @PostMapping("selectCargoYardDriveoutByObject")
    public Result selectmonthplanByObject(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestBody CargoYardDriveout cargoYardDriveout){
        PageUtils pageUtils=new PageUtils();
        pageUtils.setDataList(cargoYardDriveoutService.selectcargoworkByObject(cargoYardDriveout));
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        return Result.result(pageUtils.paging());
    }

    @ApiOperation(value = "修改出车记录")
    @PutMapping("updatecargowork")
    public Result updatecargowork(@RequestBody CargoYardDriveout cargoYardDriveout){
        return Result.result(cargoYardDriveoutService.updatecargowork(cargoYardDriveout),"修改成功","修改失败");
    }

    @ApiOperation(value = "删除出车记录")
    @DeleteMapping("deletecargowork/{cydId}")
    public Result deletecargowork(@PathVariable Integer cydId){
        return Result.result(cargoYardDriveoutService.deletecargowork(cydId),"删除成功","删除失败");
    }

    @ApiOperation(value = "新增出车记录")
    @PostMapping("insertcargowork")
    public Result insertcargowork( @RequestBody CargoYardDriveout cargoYardDriveout){
        return Result.result(cargoYardDriveoutService.insertcargowork(cargoYardDriveout),"新增成功","新增失败");
    }
}
