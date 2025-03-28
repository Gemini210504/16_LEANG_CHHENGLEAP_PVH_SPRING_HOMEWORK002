package org.homework.spring_homework02.model.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse <T>{
    private String message;
    private boolean success;
    private HttpStatus status;
    private LocalDateTime timeStamp;
    private T payload;

}
