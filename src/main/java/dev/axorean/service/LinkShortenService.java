package dev.axorean.service;

import dev.axorean.entity.LinkShorten;

public interface LinkShortenService {
    LinkShorten save(String originalLink);
    String getOriginalLink(String linkId);
}
