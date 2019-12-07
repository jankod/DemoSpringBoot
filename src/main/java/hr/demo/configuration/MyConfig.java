package hr.demo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Data
@Configuration
@ConfigurationProperties(prefix = "matison", ignoreUnknownFields = false)
public class MyConfig {

    private String dateTimeFormat;
    private String dateFormat;
    private String dateTimeFormatJsMoment;
    private String locale;


}
