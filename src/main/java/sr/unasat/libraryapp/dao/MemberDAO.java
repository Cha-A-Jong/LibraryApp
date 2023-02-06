package sr.unasat.libraryapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.unasat.libraryapp.config.JPAConfig;
import sr.unasat.libraryapp.entities.Book;
import sr.unasat.libraryapp.entities.Member;

import java.util.List;

public class MemberDAO {
    private EntityManager entityManager;
    public MemberDAO(EntityManager entityManager){this.entityManager = entityManager;}

    public List<Member> retrieveMemberList() {
        entityManager.getTransaction().begin();
        String jpql = "select m from Member m";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);
        List<Member> memberList = query.getResultList();
        entityManager.getTransaction().commit();
        return memberList;
    }

    public Member insertMember(Member member) {
        entityManager.getTransaction().begin();
        entityManager.persist(member);
        entityManager.getTransaction().commit();
        return member;
    }

    public Member updateMember(Member member) {
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Member.class, member.getId());
            entityManager.merge(member);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return member;
    }

    public boolean deleteMember(long id) {
        try{
            entityManager.getTransaction().begin();
            Member m = entityManager.find(Member.class, id);
            entityManager.remove(m);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return false;
    }

    public Member findMemberByLastName(String lastName) {
        entityManager.getTransaction().begin();
        String query = "select m from Member m where m.lastName = :lastName";
        TypedQuery<Member> typedQuery = entityManager.createQuery(query, Member.class);
        Member member = typedQuery.setParameter("lastName", lastName).getSingleResult();
        entityManager.getTransaction().commit();
        return member;
    }

    public Member findMemberById(Long memberId){
        String sqlquery = "SELECT m FROM Member m where m.id = :memberId";
        TypedQuery<Member> query = entityManager.createQuery(sqlquery, Member.class);
        query.setParameter("memberId", memberId);
        Member member = query.getSingleResult();
        return member;
    }
}
