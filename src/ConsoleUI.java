public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running){
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast dit valg"));
            switch (choice){
                case 1 -> IO.println("Lån bog");
                case 2 -> IO.println("Aflever bog");
                case 3 -> IO.println("Vis alle lån");
                case 0 -> running=false;
                default -> IO.println("Ugyldig indtastning, prøv igen");
            }
        }

    }

    public void showMenu() {
IO.println("""
        Velkommen til biblioteket´s selvbetjening
        
        1. Lån
        2. Aflever bog
        3. Vis alle lån
        0. Afslut
        """);
    }
}
