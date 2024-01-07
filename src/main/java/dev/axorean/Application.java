package dev.axorean;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
        info = @Info(
                title = "Link Shortener",
                version = "0.1",
                description = "Link Shortener",
                license = @License(name = "Apache 2.0", url = "https://axorean.dev"),
                contact = @Contact(name = "Arief Nur Prakoso", email = "ariefnur652010@gmail.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}