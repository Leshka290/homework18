package com.example.homework18.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LENGTH_REQUIRED, reason = "Превышена емкость списка сотрудников")
public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException() {
        super();
    }
}
