package com.fw.custompos.utils;

import com.fw.custompos.entities.Menu;
import com.fw.custompos.entities.Order;
import com.fw.custompos.entities.OrderMenu;
import com.fw.custompos.entities.Transaction;
import com.fw.custompos.services.dto.MenuDropdownDTO;
import com.fw.custompos.services.dto.ReceiptMenuJsonDTO;
import com.fw.custompos.services.dto.TransactionListingDTO;
import com.fw.custompos.web.responses.MenuListingResponse;
import com.fw.custompos.web.responses.MenuUpdateViewResponse;
import com.fw.custompos.web.responses.OrderDetailsInfoResponse;
import com.fw.custompos.web.responses.OrderDetailsMenuOrderedResponse;
import com.fw.custompos.web.responses.OrderListingResponse;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

  public OrderListingResponse mapOrderToOrderListingResponse(Order order) {
    OrderListingResponse retval = new OrderListingResponse();
    retval.setOrderId(order.getId());
    retval.setCustomerName(order.getCustomerName());
    retval.setCreatedDate(order.getCreatedDate());
    return retval;
  }

  public OrderDetailsMenuOrderedResponse mapOrderMenuToOrderDetailsMenuOrderedResponse(
      OrderMenu om) {
    OrderDetailsMenuOrderedResponse retval = new OrderDetailsMenuOrderedResponse();
    retval.setOrderMenuId(om.getId());
    retval.setMenuName(om.getMenu().getName());
    retval.setPrice(om.getMenu().getPrice());
    retval.setQuantity(om.getQuantity());
    retval.setNotes(om.getNotes());
    return retval;
  }

  public OrderDetailsInfoResponse mapOrderToOrderDetailsInfoResponse(Order o) {
    OrderDetailsInfoResponse retval = new OrderDetailsInfoResponse();
    retval.setOrderId(o.getId());
    retval.setCustomerName(o.getCustomerName());
    return retval;
  }

  public MenuDropdownDTO mapMenuToMenuDropdownDTO(Menu m) {
    MenuDropdownDTO retval = new MenuDropdownDTO();
    retval.setId(m.getId());
    retval.setName(m.getName());
    return retval;
  }

  public ReceiptMenuJsonDTO mapOrderDetailsMenuOrderedResponseToReceiptMenuJsonDTO(
      OrderDetailsMenuOrderedResponse odmor) {
    ReceiptMenuJsonDTO retval = new ReceiptMenuJsonDTO();
    retval.setMenuName(odmor.getMenuName());
    retval.setPrice(odmor.getPrice());
    retval.setPriceString(odmor.getPriceString());
    retval.setQuantity(odmor.getQuantity());
    retval.setNotes(odmor.getNotes());
    return retval;
  }

  public TransactionListingDTO mapTransactionToTransactionListingDTO(Transaction t) {
    TransactionListingDTO retval = new TransactionListingDTO();
    retval.setTransactionId(t.getId());
    retval.setCustomerName(t.getCustomerName());
    retval.setTransactionDate(t.getCreatedDate());
    retval.setTotalPrice(t.getTotalPrice());
    return retval;
  }

  public MenuListingResponse mapMenuToMenuListingResponse(Menu m) {
    MenuListingResponse retval = new MenuListingResponse();
    retval.setMenuId(m.getId());
    retval.setCreatedDate(m.getCreatedDate());
    retval.setLastModifiedDate(m.getLastModifiedDate());
    retval.setMenuName(m.getName());
    retval.setPrice(m.getPrice());
    return retval;
  }

  public MenuUpdateViewResponse mapMenuToMenuUpdateViewResponse(Menu m) {
    MenuUpdateViewResponse retval = new MenuUpdateViewResponse();
    retval.setId(m.getId());
    retval.setName(m.getName());
    retval.setPrice(m.getPrice());
    return retval;
  }
}
