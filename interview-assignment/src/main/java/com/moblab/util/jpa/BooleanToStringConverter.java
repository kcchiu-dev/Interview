package com.moblab.util.jpa;

import javax.persistence.AttributeConverter;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;



public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    private static final String TRUE = "y";

    private static final String FALSE = "n";

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value == null)
            return null;
        return value.booleanValue() ? TRUE : FALSE;
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return StringUtils.isNotEmpty(value) && BooleanUtils.toBoolean(value);
    }

}
