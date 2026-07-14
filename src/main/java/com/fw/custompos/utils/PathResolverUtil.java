package com.fw.custompos.utils;

import org.springframework.stereotype.Component;

@Component
public class PathResolverUtil {

  public String resolve(String path) {
    return path.substring(1);
  }
}
