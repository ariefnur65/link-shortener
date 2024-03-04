package dev.axorean.service.impl;

import dev.axorean.entity.LinkShorten;
import dev.axorean.model.ShortenLinkRequest;
import dev.axorean.persistence.repo.LinkShortenRepo;
import dev.axorean.service.LinkShortenService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class LinkShortenServiceImpl implements LinkShortenService {
    private final LinkShortenRepo linkShortenRepo;
    @Override
    public String shorten(ShortenLinkRequest originalLink) {
        LinkShorten linkShorten = LinkShorten.builder()
                .originalLink(originalLink.getOriginalUrl())
                .build();
        LinkShorten save = this.linkShortenRepo.save(linkShorten);
        return "http://localhost:8080/link/" + save.getIdLink();
    }

    @Override
    public String getOriginalLink(String linkId) {
        LinkShorten byIdLink = this.linkShortenRepo.getByIdLink(linkId);
        return byIdLink.getOriginalLink();
    }
}
