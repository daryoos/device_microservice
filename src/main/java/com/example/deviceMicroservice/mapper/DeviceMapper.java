package com.example.deviceMicroservice.mapper;

import com.example.deviceMicroservice.dto.DeviceAddDto;
import com.example.deviceMicroservice.dto.DeviceDto;
import com.example.deviceMicroservice.model.Device;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DeviceMapper {
    private Device device;
    private DeviceDto deviceDto;
    private DeviceAddDto deviceAddDto;

    public DeviceDto toDto() {
        return toDeviceDto(device);
    }

    public Device toEntity() {
        return toDeviceEntity(deviceDto);
    }

    public Device addDtoToEntity() {
        return toDeviceEntity(deviceAddDto);
    }

    public Device toDeviceEntity(DeviceAddDto deviceAddDto) {
        Device device = new Device();

        device.setUserId(deviceAddDto.getUserId());
        device.setDescription(deviceAddDto.getDescription());
        device.setAddress(deviceAddDto.getAddress());
        device.setMhec(deviceAddDto.getMhec());

        return device;
    }

    public Device toDeviceEntity(DeviceDto deviceDto) {
        Device device = new Device();

        device.setId(deviceDto.getId());
        device.setUserId(deviceDto.getUserId());
        device.setDescription(deviceDto.getDescription());
        device.setAddress(deviceDto.getAddress());
        device.setMhec(deviceDto.getMhec());

        return device;
    }

    public DeviceDto toDeviceDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();

        deviceDto.setId(device.getId());
        deviceDto.setUserId(device.getUserId());
        deviceDto.setDescription(device.getDescription());
        deviceDto.setAddress(device.getAddress());
        deviceDto.setMhec(device.getMhec());

        return deviceDto;
    }
}
