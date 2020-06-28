package javaproject;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            try {
                choice = reader.nextInt();
                if (choice == 0) {
                    throw new InputMismatchException();
                }
                reader.nextLine();
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.print("ERROR: INVALID INPUT. Please try again: ");
            }
        }
        return choice;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        int choice;
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("=================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("\nPlease select an option or Enter -1 to quit: ");
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> mems) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.print("Enter the member's name: ");
        name = reader.nextLine();

        printClubOptions();

        System.out.print("Enter the member's club access: ");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("Please enter a valid value between 1 and 4: ");
            club = getIntInput();
        }

        if (mems.size() > 0) {
            memberID = mems.getLast().getMemberID() + 1;
        } else {
            memberID = 1;
        }

        if (club != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            mems.add(mbr);
            mem = mbr.toString();

            System.out.println("\nSTATUS: Single Club Member added\n");
        } else {
            cal = (n) -> {
                if (n == 4) {
                    return 1200;
                } else {
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            mems.add(mbr);
            mem = mbr.toString();

            System.out.println("\nSTATUS: Multi Club Member added\n");
        }

        return mem;
    }

    public void removeMember(LinkedList<Member> mems) {
        int memberID = 0;
        while (memberID < 1 || memberID > mems.size()) {
            System.out.println("Please enter a member ID to remove. There are " + mems.size() + " members.");
            memberID = getIntInput();
        }

        for (int i = 0; i < mems.size(); i++) {
            if (mems.get(i).getMemberID() == memberID) {
                mems.remove(i);
                System.out.println("The member " + memberID + " has been removed.");
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public void printMemberInfo(LinkedList<Member> mems) {
        int memberID = 0;
        while (memberID < 1 || memberID > mems.size()) {
            System.out.println(
                    "Please enter a member ID to get information about. There are " + mems.size() + " members.");
            memberID = getIntInput();
        }
        for (int i = 0; i < mems.size(); i++) {
            if (mems.get(i).getMemberID() == memberID) {
                String[] memStringArr = mems.get(i).toString().split(", ");
                System.out.println("Member Type: " + memStringArr[0]);
                System.out.println("Member ID: " + memStringArr[1]);
                System.out.println("Member Name: " + memStringArr[2]);
                System.out.println("Membership Fees: " + memStringArr[3]);
                if (memStringArr[0].equals("S")) {
                    System.out.println("Club ID: " + memStringArr[4]);
                } else {
                    System.out.println("Membership Points: " + memStringArr[4]);
                }
                return;
            }
        }
        System.out.println("Member not found.");
    }
}