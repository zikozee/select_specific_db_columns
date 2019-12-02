package com.nativequery.mysqlnativequery.globalHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
