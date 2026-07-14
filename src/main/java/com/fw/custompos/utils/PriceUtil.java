package com.fw.custompos.utils;

import com.fw.custompos.web.responses.OrderDetailsMenuOrderedResponse;
import java.util.ArrayList;
import java.util.List;

public class PriceUtil {

  public static Integer calculateTotalPrice(List<OrderDetailsMenuOrderedResponse> mo) {
    List<Integer> product = new ArrayList<>();
    for (int i = 0; i < mo.size(); i++) {
      product.add(mo.get(i).getPrice() * mo.get(i).getQuantity());
    }
    return product.stream().mapToInt(a -> a).sum();
  }
}
