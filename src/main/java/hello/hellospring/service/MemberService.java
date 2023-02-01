package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

//@Service //스프링 빈으로 자동 등록
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    //의존성 주입(Dependency Injection)에는 필드 주입, setter 주입, 생성자 주입 3가지 방법이 있다.
    //생성자 주입 방법이 권장되며, 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입한다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) { //회원 가입 메서드(같은 이름을 가진 회원은 중복 가입 불가능)
        validation(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validation(Member member) { //회원 이름 중복 검사 메서드
        Optional<Member> result = memberRepository.findByName(member.getName()); //Ctrl + Alt + V 단축키 사용
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() { //전체 회원 검색 메서드
        return memberRepository.findAll();
    } //전체 회원 검색 메서드

    public Optional<Member> findOne(Long memberId) { //특정 회원 검색 메서드
        return memberRepository.findById(memberId);
    } //특정 회원 검색 메서드
}
