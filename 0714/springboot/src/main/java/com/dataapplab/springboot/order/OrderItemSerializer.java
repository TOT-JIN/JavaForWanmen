package com.dataapplab.springboot.order;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class OrderItemSerializer extends StdSerializer<OrderItem> {

    public OrderItemSerializer() {
        this(null);
    }

    private OrderItemSerializer(Class<OrderItem> t) {
        super(t);
    }

    @Override
    public void serialize(OrderItem item, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {

        generator.writeStartObject();
        generator.writeNumberField("skuId", item.getSku().getId());
        generator.writeStringField("skuName", item.getSku().getSkuName());
        generator.writeStringField("skuNo", item.getSku().getSkuNo());
        generator.writeNumberField("qty", item.getQuantity());
        generator.writeNumberField("unitPrice", item.getUnitPrice());
        generator.writeEndObject();
    }
}