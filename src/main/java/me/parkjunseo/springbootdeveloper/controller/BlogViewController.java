package me.parkjunseo.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.parkjunseo.springbootdeveloper.domain.Article;
import me.parkjunseo.springbootdeveloper.dto.ArticleListViewResponse;
import me.parkjunseo.springbootdeveloper.dto.ArticleViewResponse;
import me.parkjunseo.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor //final이 붙은 필드의 생성자롤 자동 생성해줌
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream().map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); //블로그 글 리스트 저장

        return "articleList"; //articleList.html라는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable("id") Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        
        return "article"; //view 이름
    }
}
