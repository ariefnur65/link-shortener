package dev.axorean.service;

import dev.axorean.entity.LinkShorten;

public interface LinkShortenService {
    String shorten(String originalLink);
    String getOriginalLink(String linkId);
}
