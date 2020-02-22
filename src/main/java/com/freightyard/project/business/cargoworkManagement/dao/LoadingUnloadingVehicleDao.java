package com.freightyard.project.business.cargoworkManagement.dao;

import com.freightyard.project.business.common.modal.LoadingUnloadingVehicle;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LoadingUnloadingVehicleDao {
    @Select("<script>" +
            "select * from loading_unloading_vehicle " +
            "<where>" +
            "<if test = \"loadingUnloadingVehicle.luvId neq null and loadingUnloadingVehicle.luvId neq 0\">" +
            "luv_id=#{loadingUnloadingVehicle.luvId}" +
            "</if>" +
            "<if test = \"loadingUnloadingVehicle.cargoTransportCode neq null and loadingUnloadingVehicle.cargoTransportCode neq 0\">" +
            "and cargo_transport_code =#{loadingUnloadingVehicle.cargoTransportCode}" +
            "</if>" +
            "<if test = \"loadingUnloadingVehicle.loadUnloadTime neq null and loadingUnloadingVehicle.loadUnloadTime neq ''\">" +
            "and load_unload_time > #{loadingUnloadingVehicle.loadUnloadTime}" +
            "</if>" +
            "<if test = \"loadingUnloadingVehicle.loadUnloadPlace neq null and loadingUnloadingVehicle.loadUnloadPlace neq ''\">" +
            "and load_unload_place like '%${loadingUnloadingVehicle.loadUnloadPlace}%'" +
            "</if>" +
            "</where>" +
            "</script>")
    List<LoadingUnloadingVehicle> selectLoadingUnloadingVehicleByObject(@Param("loadingUnloadingVehicle") LoadingUnloadingVehicle loadingUnloadingVehicle);

    @Update("UPDATE loading_unloading_vehicle SET " +
            "cargo_transport_code=#{loadingUnloadingVehicle.cargoTransportCode}," +
            "station_track_car =#{loadingUnloadingVehicle.stationTrackCar}," +
            "load_unload_number=#{loadingUnloadingVehicle.loadUnloadNumber},\n" +
            "load_unload_time =#{loadingUnloadingVehicle.loadUnloadTime}," +
            "load_unload_place=#{loadingUnloadingVehicle.loadUnloadPlace} "+
            "lu_comment=#{loadingUnloadingVehicle.luComment} "+
            "where luv_id=#{loadingUnloadingVehicle.luvId} ")
    Integer updateLoadingUnloadingVehicle(@Param("loadingUnloadingVehicle") LoadingUnloadingVehicle loadingUnloadingVehicle);

    @Delete("delete from loading_unloading_vehicle where luv_id=#{luvId}")
    Integer deleteLoadingUnloadingVehicle(@Param("luvId") Integer luvId);

    @Insert("<script>" +
            "insert into loading_unloading_vehicle values(default,#{loadingUnloadingVehicle.cargoTransportCode}, " +
            "#{loadingUnloadingVehicle.stationTrackCar}," +
            "#{loadingUnloadingVehicle.loadUnloadNumber}," +
            "#{loadingUnloadingVehicle.loadUnloadTime}," +
            "#{loadingUnloadingVehicle.loadUnloadPlace}," +
            "#{loadingUnloadingVehicle.luComment})" +
            "</script>")
    Integer insertLoadingUnloadingVehicles(@Param("loadingUnloadingVehicle") LoadingUnloadingVehicle loadingUnloadingVehicle);
}
