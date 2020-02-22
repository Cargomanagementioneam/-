package com.freightyard.project.business.cargoworkManagement.service;

import com.freightyard.project.business.common.modal.CargoYardDriveout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CargoYardDriveoutService {

    /**
     * 查询出车记录
     * */
    List<CargoYardDriveout> selectcargoworkByObject(CargoYardDriveout cargoYardDriveout);

    /**
     * 删除出车记录
     * */
    Integer deletecargowork(Integer cydId);

    /**
     * 更改出车记录
     * */
    Integer updatecargowork(CargoYardDriveout cargoYardDriveout);

    /**
     * 新增出车记录
     * */
    Integer insertcargowork(CargoYardDriveout cargoYardDriveout);
}
