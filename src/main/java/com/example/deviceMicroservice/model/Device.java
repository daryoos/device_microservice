package com.example.deviceMicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class Device {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "MHEC")
    private Float mhec;
}
