package dev.axorean.persistence.repo;

import dev.axorean.entity.LinkShorten;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface LinkShortenRepo extends CrudRepository<LinkShorten, String> {
    @NonNull
    LinkShorten getByIdLink(String idLink);
}
