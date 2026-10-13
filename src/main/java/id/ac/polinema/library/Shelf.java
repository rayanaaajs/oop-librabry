package id.ac.polinema.library;

public class Shelf {
    private String code; 
    private Book[] books = new Book[5];
    private int count;

    public Shelf(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public int getBookCount(){
        return count; 
    }

    public boolean addBook(Book book){
        if(book == null || count == 5){
            return false;
        }
        books[count] = book;
        count++;
        return true; 
    }

    public Book findByIsbn(String isbn){
        for(int i = 0; i < count; i++){
            if(books[i].getIsbn().equals(isbn)){
                return books[i];
            }
        }
        return null;
    }

    public int countAvailable(){
        int availableCount = 0;
        for(int i = 0; i < count; i++){
            if(books[i].isAvailable()){
                availableCount++;
            }
        }
        return availableCount;
    }


}
