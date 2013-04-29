package org.adam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * Created with IntelliJ IDEA.
 * User: aczarny
 * Date: 2/19/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebConfiguration {
  @Bean
  public InternalResourceViewResolver getJspViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setViewClass(JstlView.class);
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
}
