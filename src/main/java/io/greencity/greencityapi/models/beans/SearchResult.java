package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@Component
public class SearchResult<T> {

    private HttpStatus statusCode;
    private List<T> results;

}
