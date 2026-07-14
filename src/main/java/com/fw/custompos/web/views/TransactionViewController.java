package com.fw.custompos.web.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.constants.CompanyProfile;
import com.fw.custompos.services.impl.TransactionService;
import com.fw.custompos.utils.PathResolverUtil;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(ApiViewContracts.TRANSACTION)
public class TransactionViewController {

  private final PathResolverUtil pathResolverUtil;
  private final TransactionService transactionService;

  public TransactionViewController(
      PathResolverUtil pathResolverUtil, TransactionService transactionService) {
    this.pathResolverUtil = pathResolverUtil;
    this.transactionService = transactionService;
  }

  @GetMapping(ApiViewContracts.LIST)
  public String list(Model model) {
    model.addAttribute("default", "true");
    model.addAttribute("tlr", transactionService.getTransactionHistory());
    return pathResolverUtil.resolve(ApiViewContracts.TRANSACTION + ApiViewContracts.LIST);
  }

  @GetMapping(ApiViewContracts.FILTER)
  public String filter(
      Model model,
      @RequestParam(name = "customerName") String customerName,
      @RequestParam(name = "year") String year,
      @RequestParam(name = "month") String month,
      @RequestParam(name = "date") String date) {
    model.addAttribute("default", "false");
    model.addAttribute(
        "tlr", transactionService.getTransactionHistory(customerName, year, month, date));
    return pathResolverUtil.resolve(ApiViewContracts.TRANSACTION + ApiViewContracts.LIST);
  }

  @GetMapping(ApiViewContracts.VIEW_RECEIPT + "/{id}")
  public String viewReceipt(Model model, @PathVariable String id)
      throws JsonProcessingException, JsonMappingException {
    model.addAttribute(
        "receiptContent", transactionService.getReceiptContentByTransactionId(UUID.fromString(id)));
    model.addAttribute("companyName", CompanyProfile.name);
    model.addAttribute("companyAddress", CompanyProfile.address);
    model.addAttribute("companyCity", CompanyProfile.city);
    model.addAttribute("companyPhone", CompanyProfile.phone);
    return pathResolverUtil.resolve(ApiViewContracts.TRANSACTION + ApiViewContracts.VIEW_RECEIPT);
  }
}
