package io.greencity.greencityapi.models.beans;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;

@Data
@Component
public class SearchResult<T> {

    private HttpStatus statusCode;
    private List<T> results;

    public void setStatusCode(HttpStatus code) {
        this.statusCode = code;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public List<T> getResults() {
        return this.results;
    }

}
