package com.example.projectbe.model.repository;

import com.example.projectbe.model.Veanaide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeanaideRepository extends JpaRepository<Veanaide, Long> {
    List<Veanaide> findAllByOrderBySagedusDesc();
}
