package com.sboot.data.repositories;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T, S extends Serializable> {
    List<T> batchSave(List<T> entities);
}
