package com.santander.apisantander.service;


import com.santander.apisantander.exceptions.BusinessExceptions;
import com.santander.apisantander.exceptions.NotFoundException;
import com.santander.apisantander.mapper.StockMapper;
import com.santander.apisantander.model.DTO.StockDTO;
import com.santander.apisantander.model.Stock;
import com.santander.apisantander.repository.StockRepository;
import com.santander.apisantander.util.MessageUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@Service

public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;


    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
        if (optionalStock.isPresent()){
            throw new BusinessExceptions(MessageUtil.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }


    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(),dto.getDate(),dto.getId());
        if (optionalStock.isPresent()){
            throw new BusinessExceptions(MessageUtil.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }



    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> list = repository.findAll();
        return mapper.toDto(list);
    }



    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }


    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }


    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
}
