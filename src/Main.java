void main() {
    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);

    Book book1 = new Book("9781492072508", "Think Java", "Allan B. Downey");
    Book book2 = new Book("9788763851664", "Omrids", "Rachel Cusk");
    Book book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari");

    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Lise Andersen", 222);
    Member member3 = new Member("Peter Larsen", 333);
    AudioBook audioBook1 = new AudioBook("972938282","Smølferne", "Mikkel Kjølbye Sørensen", 489);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);
    library.addResource(book1);
    library.addResource(book2);
    library.addResource(book3);
    library.addResource(audioBook1);

    consoleUI.run();



}
