package dev.axorean.controller;

import dev.axorean.entity.LinkShorten;
import dev.axorean.service.LinkShortenService;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.scheduling.TaskExecutors;
import lombok.RequiredArgsConstructor;

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

    @Get(uri = "/{idLink}")
    public void redirectLink (){
        RedirectRequest request
    }
}
