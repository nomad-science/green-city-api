package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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

    public void setResults(List<T> results) {
        this.results = results;
        this.statusCode = CollectionUtils.isEmpty(results) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    }

}
