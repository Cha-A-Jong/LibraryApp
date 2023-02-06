package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.dao.MemberDAO;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.Member;

import java.time.LocalDate;
import java.util.List;

public class MemberService {

private final MemberDAO memberDAO;

public MemberService(){this.memberDAO = new MemberDAO(JPAConfig.getEntityManager());}

    public List<Member> retrieveMemberlist(){return memberDAO.retrieveMemberList();}

    public Member insertMember(Member member) {return memberDAO.insertMember(member);}

    public Member updateMember(Member member) {return memberDAO.updateMember(member);}

    public boolean deleteMember(long id){return memberDAO.deleteMember(id);}

    public Member findMemberById(Long memberId) {return memberDAO.findMemberById(memberId);}

    public Member findMemberByLastName(String lastName) {return memberDAO.findMemberByLastName(lastName);}

}
