package dev.axorean.service.impl

import dev.axorean.entity.LinkShorten
import dev.axorean.model.ShortenLinkRequest
import dev.axorean.persistence.repo.LinkShortenRepo
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class LinkShortenServiceImplTest extends Specification {
    private LinkShortenServiceImpl linkShortenService;
    private LinkShortenRepo linkShortenRepo

    void setup() {
        linkShortenRepo = Stub()
        linkShortenService = new LinkShortenServiceImpl(linkShortenRepo)
    }

    @Unroll
    def "shorten should return shortened link link#idLink when save link shorten return #idLink"() {
        given:
        ShortenLinkRequest shortenLinkRequest = new ShortenLinkRequest()
        shortenLinkRequest.setOriginalUrl("https://micronaut-projects.github.io/micronaut-test/latest/guide/")
        LinkShorten saveResult = new LinkShorten()
        saveResult.setOriginalLink(shortenLinkRequest.getOriginalUrl())
        saveResult.setIdLink("123")
        saveResult.setCreatedTime(new Date())
        this.linkShortenRepo.save(saveResult) >> saveResult

        when:
        def resultUrl = this.linkShortenService.shorten(shortenLinkRequest)

        then:
        resultUrl == "http://localhost:8080/link/" + shortenLinkRequest
    }
}
