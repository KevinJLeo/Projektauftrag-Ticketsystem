public class Anwendung {
    public static void main(String[] args){
        try {
            // Datenbank starten
            Datenbank.getConnection();

            // GUI starten
            Loginfenster loginfenster = new Loginfenster("BFW Ticketsystem Loginfenster");
            loginfenster.start();


        } catch (Exception e) {
            System.err.println("Fehler beim Starten der Anwendung: " + e.getMessage());
        } finally {
            // Datenbankverbindung schließen
            Datenbank.closeConnection();
        }
    }
}
