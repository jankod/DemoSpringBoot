package hr.demo.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.format.DateTimeFormatter;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final MyConfig config;


    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);

        //registrar.setDateFormatter(DateTimeFormatter.ofPattern(config.getDateFormat()));
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(config.getDateTimeFormat()));

        registrar.registerFormatters(registry);

    }

//    @Bean
//    public FormattingConversionService conversionService() {
//
//        // Use the DefaultFormattingConversionService but do not register defaults
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//
//        // Ensure @NumberFormat is still supported
//        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
//
//        // Register date conversion with a specific global format
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("dd.MM.yyyy HH:mm:ss"));
//        registrar.registerFormatters(conversionService);
//
//
//        return conversionService;
//    }
//
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//
//        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
//        registrar.setUseIsoFormat(true);
//
//
//        registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
//
//        registrar.registerFormatters(registry);
//        //registry.addFormatterForFieldAnnotation(new Jsr310DateTimeFormatAnnotationFormatterFactory());
//
//    }

}