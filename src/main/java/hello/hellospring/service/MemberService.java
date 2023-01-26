package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
    }

    public Optional<Member> findOne(Long memberId) { //특정 회원 검색 메서드
        return memberRepository.findById(memberId);
    }
}
