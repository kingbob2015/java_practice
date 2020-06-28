package javaproject;

public class SingleClubMember extends Member {
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberID, pName, pFees);
        club = pClub;
    }

    // Getters and setters
    public int getClub() {
        return club;
    }

    public void setClub(int pClub) {
        club = pClub;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + club;
    }
}