📝 Spring Boot 블로그 프로젝트

📌 프로젝트 개요

이 프로젝트는 Spring Boot 기반 블로그 애플리케이션으로, 사용자들이 게시글을 작성, 조회, 수정, 삭제(CRUD)할 수 있도록 설계되었습니다. Spring Boot와 JPA를 활용하여 데이터베이스를 관리하며, REST API를 통해 프론트엔드와 통신합니다.

✅ 주요 기능

1. 게시글 관리

게시글 작성 (AddArticleRequest.java)

게시글 수정 (UpdateArticleRequest.java)

게시글 삭제 (BlogApiController.java)

전체 게시글 목록 조회 (ArticleListViewResponse.java)

2. 사용자 관리

사용자 엔티티 (User.java)

사용자 저장소 (UserRepository.java)

3. 서비스 레이어 및 로직 처리

비즈니스 로직 처리 (BlogService.java): 게시글의 생성, 조회, 수정, 삭제를 처리하며, 데이터 무결성을 보장하기 위해 JPA 트랜잭션을 사용합니다.

사용자 인증 (UserDetailService.java): Spring Security를 활용하여 사용자 인증 및 권한 부여를 처리합니다.

예외 처리 (GlobalExceptionHandler.java): 공통 예외 처리 로직을 적용하여 일관된 에러 메시지를 제공합니다.

4. 컨트롤러

BlogApiController.java: REST API 엔드포인트 제공 (게시글 CRUD)

BlogViewController.java: Thymeleaf 기반 뷰 렌더링 담당

5. 테스트 코드

BlogApiControllerTest.java: 블로그 API의 단위 테스트 포함

UserRepositoryTest.java: JPA 저장소의 CRUD 테스트 포함

🛠️ 사용된 기술 스택

언어 : JAVA, HTML, JS

프레임워크: Spring Boot

데이터베이스: H2 Database (테스트용)

ORM: Spring Data JPA

빌드 도구: Gradle

템플릿 엔진: Thymeleaf

보안: Spring Security + JWT 인증

테스트: JUnit 5, Mockito
