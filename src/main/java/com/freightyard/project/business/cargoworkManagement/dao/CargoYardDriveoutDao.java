package com.freightyard.project.business.cargoworkManagement.dao;

import com.freightyard.project.business.common.modal.CargoYardDriveout;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoYardDriveoutDao {

    @Select("<script>" +
            "select * from cargo_yard_driveout " +
            "<where>" +
            "<if test = \"cargoYardDriveout.cydId neq null and cargoYardDriveout.cydId neq 0\">" +
            "cyd_id=#{cargoYardDriveout.cydId}" +
            "</if>" +
            "<if test = \"cargoYardDriveout.cargoTransportCode neq null and cargoYardDriveout.cargoTransportCode neq 0\">" +
            "and cargo_transport_code =#{cargoYardDriveout.cargoTransportCode}" +
            "</if>" +
            "<if test = \"cargoYardDriveout.drivingTime neq null and cargoYardDriveout.drivingTime neq ''\">" +
            "and driving_time > #{cargoYardDriveout.drivingTime}" +
            "</if>" +
            "</where>" +
            "</script>")
    List<CargoYardDriveout> selectcargoworkByObject(@Param("cargoYardDriveout") CargoYardDriveout cargoYardDriveout);

    @Update("UPDATE cargo_yard_driveout SET cargo_transport_code=#{cargoYardDriveout.cargoTransportCode}," +
            "driving_time =#{cargoYardDriveout.drivingTime},driving_contents=#{cargoYardDriveout.drivingContents},\n" +
            "driving_number =#{cargoYardDriveout.drivingNumber}," +
            "cyd_comment=#{cargoYardDriveout.cydComment} "+
            "where cyd_id=#{cargoYardDriveout.cydId} ")
    Integer updatecargowork(@Param("cargoYardDriveout") CargoYardDriveout cargoYardDriveout);

    @Delete("delete from cargo_yard_driveout where cyd_id=#{cydId}")
    Integer deletecargowork(@Param("cydId") Integer cydId);

    @Insert("<script>" +
            "insert into cargo_yard_driveout values(default,#{cargoYardDriveout.cargoTransportCode}, " +
            "#{cargoYardDriveout.drivingTime}," +
            "#{cargoYardDriveout.drivingContents}," +
            "#{cargoYardDriveout.drivingNumber}," +
            "#{cargoYardDriveout.cydComment})" +
            "</script>")
    Integer insertManyplans(@Param("cargoYardDriveout") CargoYardDriveout cargoYardDriveout);

}
