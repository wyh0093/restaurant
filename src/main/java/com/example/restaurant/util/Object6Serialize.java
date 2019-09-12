package com.example.restaurant.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-09-11 19:57
 **/
public class Object6Serialize extends JsonSerializer<Object> {

    //修改要除的数据
    private static final BigDecimal TEMP = BigDecimal.valueOf(1L);
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            BigDecimal bigDecimal = new BigDecimal(value.toString());
            //参考该方法 第二个参数是几就保留几位小数 第三个参数 参考 RoundingMode.java
            gen.writeNumber(bigDecimal.divide(TEMP, 4, RoundingMode.DOWN));
        }
    }
}
