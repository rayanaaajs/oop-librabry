package id.ac.polinema.library;

public class LibraryItem {
    protected String title;
    protected int year;
    private boolean available;

    LibraryItem(String title, int year){
        this.title = title;
        this.year = year;
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




}
