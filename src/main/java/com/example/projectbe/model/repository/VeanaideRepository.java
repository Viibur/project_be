package com.example.projectbe.model.repository;

import com.example.projectbe.model.Veanaide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeanaideRepository extends JpaRepository<Veanaide, Long> {
    List<Veanaide> findAllByRaporteeritudFalseOrderBySagedusDesc();

    @Modifying
    @Query("UPDATE Veanaide veanaide SET veanaide.raporteeritud = true WHERE veanaide.id = :id")
    void raporteeriById(Long id);

    List<Veanaide> findAllByRaporteeritudTrue();

    @Modifying
    @Query("UPDATE Veanaide veanaide SET veanaide.raporteeritud = false")
    void raporteeritudToTrue();
}
