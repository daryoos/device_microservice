package com.example.deviceMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceAddDto {
    private Long userId;
    private String description;
    private String address;
    private Float mhec;
}
