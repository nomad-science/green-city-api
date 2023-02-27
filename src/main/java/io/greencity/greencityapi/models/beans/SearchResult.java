package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

@Data
@Component
public class SearchResult<T> {

    private HttpStatus statusCode;
    private List<T> results;

    public SearchResult() {
        this.results = new ArrayList<>();
        // We treat an empty list in a Search Result object as a 404
        this.statusCode = HttpStatus.NOT_FOUND;
    }

    public void setResults(List<T> results) {
        this.results = results;
        if (!CollectionUtils.isEmpty(results)) {
            this.statusCode = HttpStatus.OK;
        }
    }

}
