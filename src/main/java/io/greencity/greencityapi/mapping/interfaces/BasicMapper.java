package io.greencity.greencityapi.mapping.interfaces;

import java.util.List;
import java.util.stream.Stream;

public interface BasicMapper<T, U> {

    T convertDto(U dto);

    List<T> convertDtosList(Stream<U> dtos);

}
