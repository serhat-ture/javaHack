package com.javahack.blog.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException   extends RuntimeException{
    private String entityName;
    private String fieldName;
    private long fieldValue;

    public EntityNotFoundException(String entityName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : '%s'", entityName, fieldName, fieldValue)); // Post not found with id : 1

        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
