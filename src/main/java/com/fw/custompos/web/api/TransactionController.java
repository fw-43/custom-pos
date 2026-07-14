package com.fw.custompos.web.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.services.impl.TransactionService;
import com.fw.custompos.web.requests.SubmitPaymentRequest;
import com.fw.custompos.web.responses.SubmitPaymentResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiViewContracts.API + ApiViewContracts.TRANSACTION)
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping(ApiViewContracts.SUBMIT_PAYMENT)
  public SubmitPaymentResponse submitPayment(@RequestBody SubmitPaymentRequest request)
      throws JsonProcessingException {
    return transactionService.submitPayment(request.getOrderId());
  }
}
