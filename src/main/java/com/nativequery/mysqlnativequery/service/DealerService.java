package com.nativequery.mysqlnativequery.service;

import com.nativequery.mysqlnativequery.model.Dealer;

import java.util.List;

public interface DealerService extends GenericService<Dealer, String>{

    Dealer getSingleEntity(String id);

    List<Dealer> getRowMapperList();

    List<Dealer> getResultExtractorList();
}
