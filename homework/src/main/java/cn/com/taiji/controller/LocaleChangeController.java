package cn.com.taiji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class LocaleChangeController {
    @Autowired
    private MessageSource messageSource;

    //国际化
    @GetMapping("locale")
    public  String locale(Model model){
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("name", messageSource.getMessage("name", null, locale));
        return "locale";
    }

}
