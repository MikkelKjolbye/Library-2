void main() {
    Book book1 = new Book("Allan B. Downey",
            "Think Java",
            "9781492072508", 1);
    Book book2 = new Book("Rachel Cusk  ",
            "Omrids ",
            "9788763851664", 2);
    Book book3 = new Book("Yuval Noah Harari",
            "Sapiens",
            "9780062316097", 3);
    Member member1 = new Member("Thorkild Hansen",65674);

book1.loanBook(member1);
IO.println(book1);
book1.returnBook();
IO.println(book1);
}