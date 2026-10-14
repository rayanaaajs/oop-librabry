package id.ac.polinema.library;

public class LibraryItem {
    protected String title;
    protected int year;
    private boolean available;
    private int extraDays = 0;

    LibraryItem(String title, int year){
        setTitle(title);
        setYear(year);
        this.available = true;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("title tidak boleh kosong");
        }
        this.title = title;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        if(year <= 0){
            throw new IllegalArgumentException("tahun harus lebih dari 0");
        }
        this.year = year;
    }

    public boolean isAvailable(){
        return available;
    }

    public boolean checkOut(){
        if(!available){
            return false;
        }
        available = false;
        return true;
    }

    public void returnItem(){
        available = true;
    }

    public int loanDays(){
        return 7;
    }

    public String describe(){
        return title + " (" + year + ")";
    }

    @Override 
    public String toString(){
        return describe();
    }

    public void extendLoan(){
        extendLoan(7);
    }

    public void extendLoan(int days){
        if (days <= 0) {
            throw new IllegalArgumentException("hari perpanjangan harus lebih dari 0");
        }
        extraDays += days;
    }

    public int getTotalLoanDay(){
        return loanDays() + extraDays;
    }
    




}
