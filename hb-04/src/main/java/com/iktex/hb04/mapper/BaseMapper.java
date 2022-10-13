package com.iktex.hb04.mapper;

public interface BaseMapper<T, S> {
    T map(S model, Object... params);
}
