package hello.core.member;

public class MemberServiceImp implements  MemberRepository{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
