package dev.axorean.service;

import dev.axorean.entity.LinkShorten;
import dev.axorean.model.ShortenLinkRequest;

public interface LinkShortenService {
    String shorten(ShortenLinkRequest originalLink);
    String getOriginalLink(String linkId);
}
