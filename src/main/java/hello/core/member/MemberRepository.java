package hello.core.member;

public interface MemberRepository { //most important == interface

    void save(Member member);

    Member findById(Long memberID);
}
