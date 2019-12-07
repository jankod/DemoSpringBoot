package hr.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class ThymeleafConfiguration {

//
//    @Bean
//    public LayoutDialect layoutDialect() {
//        return new LayoutDialect(new GroupingRespectLayoutTitleStrategy());
//    }
//
//    @Bean
//    public SpringSecurityDialect springSecurityDialect() {
//        return new SpringSecurityDialect();
//    }

    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }


//    @Bean
//    public Formatter<LocalDate> localDateFormatter() {
//        return new Formatter<LocalDate>() {
//            @Override
//            public LocalDate parse(String text, Locale locale) throws ParseException {
//                return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
//            }
//
//            @Override
//            public String print(LocalDate object, Locale locale) {
//                return DateTimeFormatter.ISO_DATE.format(object);
//            }
//        };
//    }

}
