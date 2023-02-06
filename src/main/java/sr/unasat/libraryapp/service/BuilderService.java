package sr.unasat.libraryapp.service;

import sr.unasat.libraryapp.builder.Director;
import sr.unasat.libraryapp.builder.Membership;
import sr.unasat.libraryapp.builder.MembershipBuilder;

public class BuilderService {

    public void builderApp(){
        Director director = new Director();
        MembershipBuilder membershipBuilder = new MembershipBuilder();
        director.constructIndividualMembership(membershipBuilder);

        Membership membership = membershipBuilder.getResult();
        System.out.println("Membership built: " + membership.getMembershipType() + "\n" +
                "Membership fee:  "+ membership.getFee() + "\n" +
                "Privilege membership: " + membership.getPrivilege());
    }
}
