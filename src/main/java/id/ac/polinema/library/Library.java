package id.ac.polinema.library;

import java.util.Arrays;

public class Library {
    private String name;
    private LibraryItem[] items = new LibraryItem[20];
    private int itemCount = 0;
    private Member[] members = new Member[10];
    private int memberCount = 0;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addItem(LibraryItem item) {
        if (item == null || itemCount == items.length) {
            return false;
        }
        items[itemCount] = item;
        itemCount++;
        return true;
    }

    public boolean addMember(Member member) {
        if (member == null || memberCount == members.length) {
            return false;
        }
        if (findMember(member.getMemberId()) != null) {
            return false;
        }
        members[memberCount] = member;
        memberCount++;
        return true;
    }

    public LibraryItem[] getItems() {
        return Arrays.copyOf(items, itemCount);
    }

    public Member[] getMembers() {
        return Arrays.copyOf(members, memberCount);
    }

    public LibraryItem findItemByTitle(String title) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {
                return items[i];
            }
        }
        return null;
    }

    public Member findMember(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }

    public LibraryItem[] searchByKeyword(String keyword) {
        LibraryItem[] temp = new LibraryItem[itemCount];
        int found = 0;
        String key = keyword.toLowerCase();
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().toLowerCase().contains(key)) {
                temp[found] = items[i];
                found++;
            }
        }
        return Arrays.copyOf(temp, found);
    }

    public boolean lend(String memberId, String title) {
        Member member = findMember(memberId);
        LibraryItem item = findItemByTitle(title);
        if (member == null || item == null) {
            return false;
        }
        if (member.canBorrow() && item.isAvailable()) {
            item.checkOut();
            member.addLoan();
            return true;
        }
        return false;
    }

    public boolean receive(String memberId, String title) {
        Member member = findMember(memberId);
        LibraryItem item = findItemByTitle(title);
        if (member == null || item == null) {
            return false;
        }
        if (!item.isAvailable() && member.getLoanCount() > 0) {
            item.returnItem();
            member.returnLoan();
            return true;
        }
        return false;
    }
}