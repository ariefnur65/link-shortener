package dev.axorean.service.impl;

import dev.axorean.entity.LinkShorten;
import dev.axorean.persistence.repo.LinkShortenRepo;
import dev.axorean.service.LinkShortenService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class LinkShortenServiceImpl implements LinkShortenService {
    private final LinkShortenRepo linkShortenRepo;
    @Override
    public LinkShorten save(String originalLink) {
        LinkShorten linkShorten = LinkShorten.builder()
                .originalLink(originalLink)
                .build();
        return this.linkShortenRepo.save(linkShorten);
    }

    @Override
    public String getOriginalLink(String linkId) {
        LinkShorten byIdLink = this.linkShortenRepo.getByIdLink(linkId);
        return byIdLink.getOriginalLink();
    }
}
