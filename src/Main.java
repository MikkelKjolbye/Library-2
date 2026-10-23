void main() {
    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);

    //Members
    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Lise Andersen", 222);
    Member member3 = new Member("Peter Larsen", 333);

    //Books
    Book book1 = new Book("100", "Think Java", "Allan B. Downey");
    Book book2 = new Book("101", "Omrids", "Rachel Cusk");
    Book book3 = new Book("102", "Sapiens", "Yuval Noah Harari");

    //AudioBooks
    AudioBook audioBook1 = new AudioBook("200","Smølferne", "Mikkel Kjølbye Sørensen", 489);
    AudioBook audioBook2= new AudioBook("201","Flunkerne","Malthe Rasmussen", 420);

    //Movies
    Movie movie1 = new Movie("300", "Lord of the rings; The two towers","Peter Jackson",232);
    Movie movie2 = new Movie("301", "Home alone", "Chris Columbus",103);

    //VideoGames
    VideoGame game1 = new VideoGame("400","GTA 6","Rockstar","Playstation 5");
    VideoGame game2 = new VideoGame("401","Far Cry 8", "Ubisoft", "PC");

    //Addings
    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);
    library.addResource(book1);
    library.addResource(book2);
    library.addResource(book3);
    library.addResource(audioBook1);
    library.addResource(audioBook2);
    library.addResource(movie1);
    library.addResource(movie2);
    library.addResource(game1);
    library.addResource(game2);

    consoleUI.run();



}
