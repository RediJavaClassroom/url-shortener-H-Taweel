package com.redi.shortener.repository;

import com.redi.shortener.persistence.URLShortened;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLShortenerRepository extends JpaRepository<URLShortened, Long> {
    public URLShortened getURLShortenedByKey(String key);
}