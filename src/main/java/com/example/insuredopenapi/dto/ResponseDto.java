package com.example.insuredopenapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {

    private final String code;
    private final String message;
    private final Object data;

}
