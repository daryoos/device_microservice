package com.example.deviceMicroservice.repository;

import com.example.deviceMicroservice.model.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer> {
    @Query(value = "select dvc from Device dvc where dvc.id = :id")
    Device findById(@Param(value = "id") Long id);

    @Query(value = "select dvc from Device dvc where dvc.userId = :userId")
    List<Device> findByUserId(@Param(value = "userId") Long userId);
}
