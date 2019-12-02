package com.nativequery.mysqlnativequery.controller;

import com.nativequery.mysqlnativequery.model.Dealer;
import com.nativequery.mysqlnativequery.service.DealerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DealerController {

    private final DealerService dealerService;

    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @GetMapping("/mapper/dealers")
    public List<Dealer> list(){
        return dealerService.getRowMapperList();
    }

    @GetMapping("/extractor/dealers")
    public List<Dealer> dealerList(){
        return dealerService.getResultExtractorList();
    }

    @GetMapping("/dealer/{deal_code}")
    public Dealer getDealer(@PathVariable String deal_code){
        return dealerService.getSingleEntity(deal_code);
    }
}
