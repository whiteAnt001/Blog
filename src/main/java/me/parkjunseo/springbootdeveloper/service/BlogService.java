package me.parkjunseo.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.parkjunseo.springbootdeveloper.domain.Article;
import me.parkjunseo.springbootdeveloper.dto.AddArticleRequest;
import me.parkjunseo.springbootdeveloper.dto.UpdateArticleRequest;
import me.parkjunseo.springbootdeveloper.repository.BlogRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNUll이 붙은 필드의 생성자를 추가해주는 어노테이션
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id){ //글 조회 API
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) { //글 삭제 API
        blogRepository.deleteById(id);
    }

    @Transactional //트랜젝션 메서드
    public Article update(long id, UpdateArticleRequest request) { // 글 수정 API
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
