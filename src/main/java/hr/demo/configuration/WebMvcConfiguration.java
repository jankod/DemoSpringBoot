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

        registrar.setDateFormatter(DateTimeFormatter.ofPattern(config.getDateFormat()));
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern(config.getDateTimeFormat()));

        registrar.registerFormatters(registry);



//        DateTimeFormatter formater = DateTimeFormatter.ofPattern(config.getDateFormat());
//        registry.addFormatter(new Formatter<LocalDateTime>() {
//
//            @Override
//            public String print(LocalDateTime object, Locale locale) {
//                log.debug("format: {}", object);
//                return formater.format(object);
//            }
//
//            @Override
//            public LocalDateTime parse(String text, Locale locale) throws ParseException {
//                try {
//                    return LocalDateTime.parse(text, formater);
//                } catch (Exception e) {
//                    log.error("", e);
//                    return null;
//
//                }
//            }
//        });
//        registry.addConverter(new Converter<String, LocalDateTime>() {
//
//            @Override
//            public LocalDateTime convert(String s) {
//                try {
//                    return LocalDateTime.parse(s, formater);
//                } catch (Exception e) {
//                    log.error("", e);
//
//
//                }
//            }
//        });

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