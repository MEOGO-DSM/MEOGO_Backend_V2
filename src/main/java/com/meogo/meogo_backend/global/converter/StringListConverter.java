package com.meogo.meogo_backend.global.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {
  @Override
  public String convertToDatabaseColumn(List<String> dataList) {
    return String.join(",", dataList);
  }

  @Override
  public List<String> convertToEntityAttribute(String data) {
    if(data.isEmpty()){
      return new ArrayList<>();
    }
    return new ArrayList<>(Arrays.asList(data.split(",")));
  }
}