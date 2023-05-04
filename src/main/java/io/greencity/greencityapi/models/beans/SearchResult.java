package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

@Data
@Component
public class SearchResult {

    private HttpStatus statusCode;
    private List<Object> results;

    public SearchResult() {
        this.results = new ArrayList<>();

    }

    public <T extends BaseEntity> void setResults(List<T> input) {
        results.addAll(input);

    }

    public <T extends BaseEntity> void setResults(T input) {
        results.add(input);

    }

    public HttpStatus getStatusCode() {
        if (CollectionUtils.isEmpty(results)) {
            this.statusCode = HttpStatus.NOT_FOUND;
        } else {
            this.statusCode = HttpStatus.OK;
        }
        return this.statusCode;
    }

}
