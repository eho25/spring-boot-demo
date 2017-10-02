package com.sboot.services.mappers;

import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @param <T> Entity type
 * @param <S> Model type
 */
public abstract class BaseMapper<T, S> {

    public List<S> convertEntitiesToModels(List<T> data){
        return data.stream().map(d -> convertEntityToModel(d)).collect(Collectors.toList());
    }

    public abstract S convertEntityToModel(T person);
}
