package com.example.demo.mapper;

import com.example.demo.model.Customer;
import com.example.demo.pojo.CreateCustomerRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SimplePojoToModelMapper {
    @Mapping(target = "id", ignore = true)
    Customer fromCreateCustomerRequest(CreateCustomerRequest request);
}
