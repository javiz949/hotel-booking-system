package com.hotelsystem.hotelbooking.rooms;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.hotelsystem.hotelbooking.shared.enums.RoomType;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    @NotNull
    private Integer capacity;

    @NotNull
    private BigDecimal pricePerNight;

    private String description;

    private String imageUrl;

    private Boolean hasWifi = false;

    private Boolean hasView = false;

    private Boolean hasAC = false;

    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'AVAILABLE'")
    private String status = "AVAILABLE";
}