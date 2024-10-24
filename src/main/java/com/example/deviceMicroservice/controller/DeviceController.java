package com.example.deviceMicroservice.controller;

import com.example.deviceMicroservice.dto.DeviceAddDto;
import com.example.deviceMicroservice.dto.DeviceDto;
import com.example.deviceMicroservice.mapper.DeviceMapper;
import com.example.deviceMicroservice.model.Device;
import com.example.deviceMicroservice.repository.DeviceRepository;
import com.example.deviceMicroservice.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor

public class DeviceController implements DeviceControllerResource {

    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper;
    private final DeviceRepository deviceRepository;

    @Override
    public ResponseEntity<Device> getById(Long id) {
        Device device = deviceService.getById(id);

        return ResponseEntity.status(200).body(device);
    }

    @Override
    public ResponseEntity<String> add(DeviceAddDto deviceAddDto) {
        Device device = deviceMapper.withDeviceAddDto(deviceAddDto).addDtoToEntity();

        try {
            deviceRepository.save(device);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Device added successfully");
    }

    @Override
    public ResponseEntity<String> update(DeviceDto deviceDto) {
        try {
            deviceService.update(deviceDto);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Device updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            deviceService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(200).body("Device deleted successfully");
    }

    @Override
    public ResponseEntity<List<Device>> getAll() {
        List<Device> deviceList = deviceService.getAll();
        return ResponseEntity.status(200).body(deviceList);
    }

    @Override
    public ResponseEntity<List<Device>> getByUserId(Long userId) {
        List<Device> devices = deviceService.getByUserId(userId);
        return ResponseEntity.status(200).body(devices);
    }
}
