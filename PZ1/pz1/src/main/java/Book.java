public class Book {
    private String title;
    private String author;
    private int year;

    // Конструктор
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Геттер для title
    public String getTitle() {
        return title;
    }

    // Сеттер для title
    public void setTitle(String title) {
        this.title = title;
    }

    // Геттер для author
    public String getAuthor() {
        return author;
    }

    // Сеттер для author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Геттер для year
    public int getYear() {
        return year;
    }

    // Сеттер для year
    public void setYear(int year) {
        this.year = year;
    }

    // Метод для виведення інформації про книгу
    public void printInfo() {
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Рік видання: " + year);
    }
    public static void main(String[] args) {
        Book book = new Book("Шість багряних журавлів", "Елізабет Лім", 2024);
        book.printInfo();

        // Змінимо назву книги
        book.setTitle("Шість багряних журавлів(оновлене видання)");
        System.out.println("\nПісля оновлення:");
        book.printInfo();
    }
}


