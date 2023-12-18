package dev.axorean.entity;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@MappedEntity
@RequiredArgsConstructor
public class LinkShorten {
    @Id
    @GeneratedValue
    private String idLink;

    @NotNull
    private String originalLink;

    @DateCreated
    private Date createdTime;
}
