package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.StockDTO;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.mapper.StockMapper;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
public class StockRestController {

    @Autowired
    IStockService stockService;

    @GetMapping("/retrieve-all-stocks")
    @ResponseBody
    public List<StockDTO> getStocks() {
        return StockMapper.toDTOList(stockService.retrieveAllStocks());
    }

    @GetMapping("/retrieve-stock/{stock-id}")
    @ResponseBody
    public StockDTO retrieveStock(@PathVariable("stock-id") Long stockId) {
        return StockMapper.toDTO(stockService.retrieveStock(stockId));
    }

    @PostMapping("/add-stock")
    @ResponseBody
    public StockDTO addStock(@RequestBody StockDTO stockDTO) {
        Stock entity = StockMapper.toEntity(stockDTO);
        Stock savedEntity = stockService.addStock(entity);
        return StockMapper.toDTO(savedEntity);
    }

    @DeleteMapping("/remove-stock/{stock-id}")
    @ResponseBody
    public void removeStock(@PathVariable("stock-id") Long stockId) {
        stockService.deleteStock(stockId);
    }

    @PutMapping("/modify-stock")
    @ResponseBody
    public StockDTO modifyStock(@RequestBody StockDTO stockDTO) {
        Stock entity = StockMapper.toEntity(stockDTO);
        Stock updatedEntity = stockService.updateStock(entity);
        return StockMapper.toDTO(updatedEntity);
    }
}