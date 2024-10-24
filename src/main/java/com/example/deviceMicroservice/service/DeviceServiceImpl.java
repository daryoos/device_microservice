package com.example.deviceMicroservice.service;

import com.example.deviceMicroservice.dto.DeviceDto;
import com.example.deviceMicroservice.mapper.DeviceMapper;
import com.example.deviceMicroservice.model.Device;
import com.example.deviceMicroservice.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Override
    public Device getById(Long id) {
        Device device = deviceRepository.findById(id);
        System.out.println("LOG:\n" + device + "\n");
        return device;
    }

    @Override
    public void add(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public void update(DeviceDto deviceDto) throws Exception {
        Device deviceUpdated = deviceRepository.findById(deviceDto.getId());
        if (deviceUpdated != null) {
            deviceUpdated.setDescription(deviceDto.getDescription());
            deviceUpdated.setAddress(deviceDto.getAddress());
            deviceUpdated.setMhec(deviceDto.getMhec());

            deviceRepository.save(deviceUpdated);
        }
        else {
            throw new Exception("Device not found");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Device device = deviceRepository.findById(id);
        if (device != null) {
            deviceRepository.delete(device);
        }
        else {
            throw new Exception("Device not found");
        }
    }

    @Override
    public List<Device> getAll() {
        List<Device> devices = new ArrayList<>();
        deviceRepository.findAll().forEach(devices::add);
        return devices;
    }

    @Override
    public List<Device> getByUserId(Long userId){
        List<Device> devices = deviceRepository.findByUserId(userId);
        System.out.println("LOG:\n" + devices + "\n");
        return devices;
    }
}
