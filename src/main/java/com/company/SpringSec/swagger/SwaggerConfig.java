package com.company.SpringSec.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "InfoSec", version = "0.1",
        contact = @Contact(name = "Mahammad Niyazli",email = "mahammad.niyazli@gmail.com"),
        license = @License(name = "Apache 2.0",
                url = "https://www.apache.org/licenses/LICENSE-2.0.html")))
public class SwaggerConfig {

}
