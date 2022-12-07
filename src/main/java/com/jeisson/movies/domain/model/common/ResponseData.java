package com.jeisson.movies.domain.model.common;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
public class ResponseData{
    protected LocalDateTime timestamp;
    protected int statusCode;
    protected String status;
    protected String message;
    protected Map<?,?> data;
}
