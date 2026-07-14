package com.fw.custompos.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.stereotype.Component;

@Component
public class CurrencyStringFormatUtil {

  private DecimalFormat decimalFormat;
  private DecimalFormatSymbols decimalFormatSymbols;

  public CurrencyStringFormatUtil() {
    decimalFormat = (DecimalFormat) (NumberFormat.getInstance(Locale.US));
    decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
    decimalFormatSymbols.setGroupingSeparator(',');
    decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
  }

  public String format(Integer integer) {
    return decimalFormat.format(integer);
  }
}
