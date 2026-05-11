package com.hotelsystem.hotelbooking.bookings;

import com.hotelsystem.hotelbooking.rooms.Room;
import com.hotelsystem.hotelbooking.shared.enums.BookingStatus;
import com.hotelsystem.hotelbooking.users.User;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BigDecimal totalPrice;

    @Column(unique = true)
    private String bookingReference;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        bookingReference = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}