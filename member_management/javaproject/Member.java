package javaproject;

public class Member {
    private char memberType;
    private int memberID;
    private String name;
    private double fees;

    public Member(char pMemberType, int pMemberID, String pName, double pFees) {
        memberType = pMemberType;
        memberID = pMemberID;
        name = pName;
        fees = pFees;
    }

    // Getters and setters
    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char pMemberType) {
        memberType = pMemberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(char pMemberID) {
        memberID = pMemberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double pFees) {
        fees = pFees;
    }

    @Override
    public String toString() {
        return memberType + ", " + memberID + ", " + name + ", " + fees;
    }

}