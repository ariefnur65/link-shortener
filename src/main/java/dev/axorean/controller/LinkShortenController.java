package dev.axorean.controller;

import dev.axorean.service.LinkShortenService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequiredArgsConstructor
@ExecuteOn(TaskExecutors.BLOCKING)
public class LinkShortenController {
    private final LinkShortenService linkShortenService;

    @Post(uri = "/shorten")
    @Status(HttpStatus.CREATED)
    public String shorten(@Body String originalLink) {
        return this.linkShortenService.shorten(originalLink);
    }

    @Get(uri = "/link/{idLink}")
    public HttpResponse<String> redirectLink (@PathVariable String idLink) throws URISyntaxException {
        String url = this.linkShortenService.getOriginalLink(idLink);
        URI redirectUrl = new URI(url);
        return HttpResponse.redirect(redirectUrl);
    }
}
