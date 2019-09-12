package com.example.restaurant.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-09-11 20:01
 **/
public class DataSerializerUtils extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(!StringUtils.isEmpty(value)) {
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.HALF_UP);
            double _value = NumberUtils.toDouble(value);
            gen.writeString(df.format(_value));
        }else {//这个分支不要忘记了，否则将不输出这个属性的值
            gen.writeString(value);
        }
    }
}
