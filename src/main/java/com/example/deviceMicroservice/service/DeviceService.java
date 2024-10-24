package com.example.deviceMicroservice.service;

import com.example.deviceMicroservice.dto.DeviceDto;
import com.example.deviceMicroservice.model.Device;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceService {
    Device getById(Long id);

    void add(Device device);

    void update(DeviceDto deviceDto) throws Exception;

    void delete(Long id) throws Exception;

    List<Device> getAll();

    List<Device> getByUserId(Long userId);
}
