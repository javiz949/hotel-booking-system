package com.hotelsystem.hotelbooking.rooms;

import com.hotelsystem.hotelbooking.shared.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByType(RoomType type);
    List<Room> findByStatus(String status);
    List<Room> findByCapacityGreaterThanEqual(Integer capacity);
}