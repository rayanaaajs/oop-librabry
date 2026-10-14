package id.ac.polinema.library;

public class Dvd extends LibraryItem {
    private int durationMinutes;

    public Dvd(String title, int year, int duratioMinutes){
        super(title, year);
        this.durationMinutes = duratioMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override 
    public int loanDays(){
        return 3;
    }

    @Override 
    public String describe(){
        return super.describe() + " [" + durationMinutes + " min]";
    }
}
