package cn.com.taiji.config;

import cn.com.taiji.interceptor.LoginInterceptor;
import cn.com.taiji.interceptor.TimeInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Config extends WebMvcConfigurerAdapter {
    //请求头方式的国际化
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource;

    }
    //cookie方式的国际化
    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver=new CookieLocaleResolver();
        localeResolver.setCookieName("cookieLocale");
        return localeResolver;
    }
    //*session方式的国际化*/
    @Bean("localeResolver")
    public LocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();

        sessionLocaleResolver.setLocaleAttributeName("sessionLocale");
        return sessionLocaleResolver;
    }
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;

    }


    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(new TimeInterceptor());
        registry.addInterceptor(new LoginInterceptor());


    }
}
