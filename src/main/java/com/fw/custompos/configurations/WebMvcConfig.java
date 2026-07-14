package com.fw.custompos.configurations;

import com.fw.custompos.constants.ApiViewContracts;
import com.fw.custompos.utils.PathResolverUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final PathResolverUtil pathResolverUtil;

  public WebMvcConfig(PathResolverUtil pathResolverUtil) {
    this.pathResolverUtil = pathResolverUtil;
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry
        .addViewController(ApiViewContracts.AUTH + ApiViewContracts.LOGIN)
        .setViewName(pathResolverUtil.resolve(ApiViewContracts.AUTH + ApiViewContracts.LOGIN));
    registry
        .addViewController("/")
        .setViewName(pathResolverUtil.resolve(ApiViewContracts.AUTH + ApiViewContracts.LOGIN));
  }
}
