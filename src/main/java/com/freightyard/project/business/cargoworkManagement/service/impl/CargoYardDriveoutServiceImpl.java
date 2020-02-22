package com.freightyard.project.business.cargoworkManagement.service.impl;

import com.freightyard.project.business.cargoworkManagement.service.CargoYardDriveoutService;
import com.freightyard.project.business.common.modal.CargoYardDriveout;
import com.freightyard.project.utils.PoiUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import  com.freightyard.project.business.cargoworkManagement.dao.*;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CargoYardDriveoutServiceImpl implements CargoYardDriveoutService {

    @Autowired
    CargoYardDriveoutDao cargoworkDao;

    @Override
    public List<CargoYardDriveout> selectcargoworkByObject(CargoYardDriveout cargoYardDriveout) {
        return cargoworkDao.selectcargoworkByObject(cargoYardDriveout);
    }

    @Override
    public Integer deletecargowork(Integer cydId) {
        return cargoworkDao.deletecargowork(cydId);
    }

    @Override
    public Integer updatecargowork(CargoYardDriveout cargoYardDriveout) {
        return cargoworkDao.updatecargowork(cargoYardDriveout);
    }

    @Override
    public Integer insertcargowork(CargoYardDriveout cargoYardDriveout) {
        Integer a =cargoworkDao.insertManyplans(cargoYardDriveout);
        System.out.println(a);
        return a;
    }


}
