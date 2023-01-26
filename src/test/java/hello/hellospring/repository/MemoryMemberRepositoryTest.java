package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //각각의 Test 메소드가 실행될 때 호출된다.
    public void afterEach() { //테스트는 각각 독립적으로 실행되어야 한다. 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member= new Member();
        member.setName("spring"); //따옴표 닫지 않고 Ctrl + Shift + Enter 단축키를 사용하여 쉽게 탈출할 수 있다.

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertThat(member).isEqualTo(result); 대신에
        assertThat(result).isEqualTo(member); //Assertions 클래스를 Add on-demand static import하여 사용할 수 있다.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); //Shift + F6 단축키 사용
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
