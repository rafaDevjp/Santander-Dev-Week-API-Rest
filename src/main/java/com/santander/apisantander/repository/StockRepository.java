package com.santander.apisantander.repository;

import com.santander.apisantander.model.DTO.StockDTO;
import com.santander.apisantander.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);


    @Query("SELECT stock FROM Stock stock WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id );


    @Query("SELECT stock FROM Stock stock WHERE stock.date = CURRENT_DATE ")
    Optional<List<Stock>> findByToday(LocalDate now);
}
