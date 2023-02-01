package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링 데이터 JPA가 SpringDataJpaMemberRepository 클래스 객체를 스프링 빈으로 자동 등록해준다.
//스프링 데이터 JPA가 인터페이스를 통한 기본적인 CRUD, findByName() 또는 findByEmail() 등의 메서드, 페이징 기능을 자동 제공해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
