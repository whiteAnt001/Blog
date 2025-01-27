package me.parkjunseo.springbootdeveloper.repository;

import me.parkjunseo.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
