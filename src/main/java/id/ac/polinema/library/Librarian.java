package id.ac.polinema.library;

public class Librarian {
    public boolean lend(Member member, Book book){
        if(member.canBorrow() && book.isAvailable()){
            book.checkOut();
            member.addLoan();
            return true;
        }
        return false;
    }

    public boolean receive(Member member, Book book){
        if(member.getLoanCount() > 0 && !book.isAvailable()){
            book.returnItem();
            member.returnLoan();
            return true;
        }
        return false;
    }
}
