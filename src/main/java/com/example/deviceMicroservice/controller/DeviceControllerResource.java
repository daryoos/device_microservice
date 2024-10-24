package com.example.deviceMicroservice.controller;

import com.example.deviceMicroservice.dto.DeviceAddDto;
import com.example.deviceMicroservice.dto.DeviceDto;
import com.example.deviceMicroservice.model.Device;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/devices")
public interface DeviceControllerResource {

    @GetMapping(value = "/getById/{id}")
    ResponseEntity<Device> getById(@PathVariable  Long id);

    @PostMapping(value = "/add")
    ResponseEntity<String> add(@RequestBody  DeviceAddDto deviceAddDto);

    @PutMapping(value = "/update")
    ResponseEntity<String> update(@RequestBody DeviceDto deviceDto);

    @DeleteMapping(value = "/deleteById/{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

    @GetMapping(value = "/getAll")
    ResponseEntity<List<Device>> getAll();

    @GetMapping(value = "/getByUserId/{userId}")
    ResponseEntity<List<Device>> getByUserId(@PathVariable Long userId);
}
