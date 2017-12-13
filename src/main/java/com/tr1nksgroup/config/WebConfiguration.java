package com.tr1nksgroup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web конфигурация приложения
 * описание view resolver,
 * описание template resolver,
 * расположение ресурсов,
 * алиасы
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
//    private static final String ENCODING = "UTF-8";
//    private ApplicationContext applicationContext;

//    /**
//     * template view resolver для thymeleaf
//     *
//     * @return template view resolver
//     */
//    @Bean
//    public ViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setOrder(1);
//        viewResolver.setCharacterEncoding(ENCODING);
//        return viewResolver;
//    }
//@Bean
//public JavaMailSender getJavaMailSender() {
//    JavaMailSender mailSender = new JavaMailSenderImpl();
//    mailSender.setHost("smtp.gmail.com");
//    mailSender.setPort(587);
//
//    mailSender.setUsername("my.gmail@gmail.com");
//    mailSender.setPassword("password");
//
//    Properties props = mailSender.getJavaMailProperties();
//    props.put("mail.transport.protocol", "smtp");
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.starttls.enable", "true");
//    props.put("mail.debug", "true");
//
//    return mailSender;
//}
//    /**
//     * template resolver для thymeleaf, с расширением view - .html
//     *
//     * @return template resolver
//     */
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(this.applicationContext);
//        templateResolver.setPrefix("/WEB-INF/pages/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCacheable(true);
//        templateResolver.setCharacterEncoding(ENCODING);
//        templateResolver.addTemplateAlias("includes", "./../includes");
////        templateResolver.addTemplateAlias("navigation","./../includes/navigation");
////        templateResolver.addTemplateAlias("cssIncludes","./../includes/cssIncludes");
////        templateResolver.addTemplateAlias("jsIncludes","./../includes/jsIncludes");
//        return templateResolver;
//    }

//    /**
//     * template engine для thymeleaf
//     *
//     * @return template engine
//     */
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        templateEngine.addDialect(new SpringSecurityDialect());
//        return templateEngine;
//    }

    /**
     * {@inheritDoc}
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/theme/**").addResourceLocations("classpath:/static/theme/");
        registry.addResourceHandler("css/**").addResourceLocations("classpath:/static/theme/css/");
        registry.addResourceHandler("fonts/**").addResourceLocations("classpath:/static/theme/fonts/");
        registry.addResourceHandler("js/**").addResourceLocations("classpath:/static/theme/js/");
        registry.addResourceHandler("includes/**").addResourceLocations("classpath:/templates/includes/");
//        registry.addResourceHandler("css/**").addResourceLocations("classpath:/static/css/");
//        registry.addResourceHandler("images/**").addResourceLocations("classpath:/static/images/");
//        registry.addResourceHandler("js/**").addResourceLocations("classpath:/static/js/");
    }


}
