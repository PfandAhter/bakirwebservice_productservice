package com.bakirwebservice.productservice.rest.service.interfaces;

import java.util.List;

public interface IMapperService {

    <T,D> List<D> map(List<T> source, Class<D> destination);
}
