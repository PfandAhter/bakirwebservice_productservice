package com.bakirwebservice.productservice.rest.service;

import com.bakirwebservice.productservice.rest.service.interfaces.IMapperService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class MapperServiceImpl implements IMapperService {
    private final ModelMapper modelMapper;


    //Normal modelMapper cant map list so we created own modelmapper

    @Override
    public <T,D> List<D> map(List<T> source , Class<D> destination){
        List<D> target = new ArrayList<>();
        for( T element : source){
            target.add(modelMapper.map(element,destination));
        }
        return target;
    }

//    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
//        return entityList.stream()
//                .map(entity -> map(entity, outCLass))
//                .collect(Collectors.toList());
//    }
}
