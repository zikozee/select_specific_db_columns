package com.nativequery.mysqlnativequery.service;

import java.util.List;

public interface GenericService<T, ID> {
    T getSingleEntity(ID id);

    List<T> getRowMapperList();

    List<T> getResultExtractorList();
}
