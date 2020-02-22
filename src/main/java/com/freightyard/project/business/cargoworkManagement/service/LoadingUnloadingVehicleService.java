package com.freightyard.project.business.cargoworkManagement.service;

import com.freightyard.project.business.common.modal.LoadingUnloadingVehicle;

import java.util.List;

public interface LoadingUnloadingVehicleService {
    /**
     * 查询装卸车记录
     * */
    List<LoadingUnloadingVehicle> selectLoadingUnloadingVehicleByObject(LoadingUnloadingVehicle loadingUnloadingVehicle);

    /**
     * 删除装卸车记录
     * */
    Integer deleteLoadingUnloadingVehicle(Integer cydId);

    /**
     * 更改装卸车记录
     * */
    Integer updateLoadingUnloadingVehicle(LoadingUnloadingVehicle loadingUnloadingVehicle);

    /**
     * 新增装卸车记录
     * */
    Integer insertLoadingUnloadingVehicles(LoadingUnloadingVehicle loadingUnloadingVehicle);
}
