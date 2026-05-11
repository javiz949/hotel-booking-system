package com.hotelsystem.hotelbooking.recommendations;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByUserId(Long userId);
    List<Recommendation> findByUserIdOrderByScoreDesc(Long userId);
}