package id.ac.polinema.library;

/**
 * Bagian 2 dan 3: buku perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setAuthor, getAuthor, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas constructor:
 *   public String isbn;
 *   public ____ title;
 *   public ____ year;
 *   public ____ available;
 */
public class Book extends LibraryItem {
    private String isbn;
    private Author author;

    public Book(String isbn, String title, int year) {
        super(title, year);
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("isbn tidak boleh kosong");
        }
        this.isbn = isbn;
    }

    public Book(String isbn, String title, int year, Author author) {
        this(isbn, title, year);
        setAuthor(author);
    }

    public String getIsbn() {
        return isbn ;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor(){
        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    @Override
        public int loanDays() {
            return 14;
    }

    @Override
        public String describe(){
            String authorName;
            if (author == null) {
                authorName = "Unknown";
            } else {
                authorName = author.getName();
            }   
            return super.describe() + " by " + authorName;   
        }
}
