package com.freightyard.project.business.cargoworkManagement.service.impl;

import com.freightyard.project.business.cargoworkManagement.dao.LoadingUnloadingVehicleDao;
import com.freightyard.project.business.cargoworkManagement.service.LoadingUnloadingVehicleService;
import com.freightyard.project.business.common.modal.LoadingUnloadingVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadingUnloadingVehicleServiceImpl implements LoadingUnloadingVehicleService {

    @Autowired
    LoadingUnloadingVehicleDao loadingUnloadingVehicleDao;

    @Override
    public List<LoadingUnloadingVehicle> selectLoadingUnloadingVehicleByObject(LoadingUnloadingVehicle loadingUnloadingVehicle) {
        return loadingUnloadingVehicleDao.selectLoadingUnloadingVehicleByObject(loadingUnloadingVehicle);
    }

    @Override
    public Integer deleteLoadingUnloadingVehicle(Integer cydId) {
        return loadingUnloadingVehicleDao.deleteLoadingUnloadingVehicle(cydId);
    }

    @Override
    public Integer updateLoadingUnloadingVehicle(LoadingUnloadingVehicle loadingUnloadingVehicle) {
        return loadingUnloadingVehicleDao.updateLoadingUnloadingVehicle(loadingUnloadingVehicle);
    }

    @Override
    public Integer insertLoadingUnloadingVehicles(LoadingUnloadingVehicle loadingUnloadingVehicle) {
        return loadingUnloadingVehicleDao.insertLoadingUnloadingVehicles(loadingUnloadingVehicle);
    }
}
