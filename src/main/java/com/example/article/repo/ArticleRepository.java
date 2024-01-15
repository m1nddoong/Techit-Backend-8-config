package com.example.article.repo;

import com.example.article.entity.Article;
import java.io.Writer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository
        extends JpaRepository<Article, Long> {

    // id가 역순으로 정렬된 articles 들을 가져와 List 로 반환하도록
    // SELECT * FROM article ORDER BY id DESC;

    List<Article> findAllByOrderByIdDesc();

    // SELECT * FROM article ORDER BY writer DESC;
    List<Article> findAllByOrderByWriterDesc();

    // SELECT * FROM article ORDER BY title;
    List<Article> findAllByOrderByTitle();

    // 아전글 : 나보다 나중에 작성되었으며 (가장 먼저 작성된 글)
    // SELECT * FROM article WHERE id > ?; (id 가 어떠한 특정한 값보다는 커야된다)
    List<Article> findAllByIdGreaterThan(Long id);


    // 나와 같거나 나보다 먼저 작성한 글
    // SELECT * FROM article WHERE <= ?;
    List<Article> findAllByIdLessThanEqual(Long id);

    // SELECT * FROM article WHERE id < ? ORDER BY id DESC;
    List<Article> findAllByIdLessThanOrderByIdDesc(Long id);


    // 제목에 'Lorem' 이라는 문구가 포함된 글의 목록을 조회
    // SELECT * FROM article WHERE title LIKE '%Lorem%';
    List<Article> findAllByTitleContaining(String title);


    // SELECT * FROM article WHERE id > ? LIMIT 1;
    Optional<Article> findFirstByIdAfter(Long id);

    // SELECT * FROM article WHERE id > ? ORDER BY id DESC;
    // LIMIT 1;
    Optional<Article> findFirstByIdLessThanOrderByIdDesc(Long id);
}

// findById - CREATE
// findAll - PK를 기분으로 READ
// save - 전체 READ
// deleteById - PK를 기준으로 DELETE
// delete - Entity를 기준으로 DELETE

/*
SELECT * FROM articles;
// ID의 역순으로 정렬하고싶다면
SELECT * FROM articles ORDER BY id DESC;
 */
