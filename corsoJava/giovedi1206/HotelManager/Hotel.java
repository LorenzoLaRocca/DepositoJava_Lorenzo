package giovedi1206.HotelManager;

/* SQL
 * CREATE DATABASE IF NOT EXISTS hotel;
USE hotel;

CREATE TABLE utenti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50)
);

CREATE TABLE camere (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    tipo VARCHAR(20)
);

CREATE TABLE prenotazioni (
    id INT AUTO_INCREMENT PRIMARY KEY,
    utente_id INT,
    camera_id INT,
    data_prenotazione DATE,
    FOREIGN KEY (utente_id) REFERENCES utenti(id),
    FOREIGN KEY (camera_id) REFERENCES camere(id)

    INSERT INTO camere (numero, tipo) VALUES (101, 'Singola');
    INSERT INTO camere (numero, tipo) VALUES (102, 'Doppia');
    INSERT INTO camere (numero, tipo) VALUES (103, 'Matrimoniale');
    INSERT INTO camere (numero, tipo) VALUES (104, 'Suite');
    INSERT INTO camere (numero, tipo) VALUES (105, 'Doppia');
);
 */


import java.sql.*;
import java.util.Scanner;

public class Hotel {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Benvenuto nel gestore di hotel!");

        try (Connection conn = DBManager.getConnection()) {
            while (true) {
                System.out.println("Scegli un'opzione:");
                System.out.println("1. Aggiungi un ospite");
                System.out.println("2. Effettua una prenotazione");
                System.out.println("3. Visualizza prenotazioni");
                System.out.println("4. Esci");

                int scelta = scanner.nextInt();
                scanner.nextLine(); // Consuma newline

                switch (scelta) {
                    case 1:
                        aggiungiOspite(conn);
                        break;
                    case 2:
                        effettuaPrenotazione(conn);
                        break;
                    case 3:
                        visualizzaPrenotazioni(conn);
                        break;
                    case 4:
                        System.out.println("Arrivederci!");
                        return;
                    default:
                        System.out.println("Opzione non valida, riprova.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Errore durante la connessione al database.");
            e.printStackTrace();
        }
    }
    private static void aggiungiOspite(Connection conn) throws SQLException {
        System.out.println("Inserisci il nome dell'ospite: ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome dell'ospite: ");
        String cognome = scanner.nextLine();

        String sql = "INSERT INTO utenti (nome, cognome) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.executeUpdate();
            System.out.println("Ospite aggiunto con successo!");
        }
    }

    private static void effettuaPrenotazione(Connection conn) throws SQLException {
        System.out.println("Inserisci l'ID dell'ospite: ");
        int utenteId = scanner.nextInt();
        System.out.println("Inserisci l'ID della camera: ");
        int cameraId = scanner.nextInt();
        scanner.nextLine(); // Conversione dello scanner per evitare problemi con la lettura della riga successiva
        System.out.println("Inserisci la data di prenotazione (YYYY-MM-DD): ");
        String dataPrenotazione = scanner.nextLine();

        String sql = "INSERT INTO prenotazioni (utente_id, camera_id, data_prenotazione) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, utenteId);
            pstmt.setInt(2, cameraId);
            pstmt.setDate(3, Date.valueOf(dataPrenotazione));
            pstmt.executeUpdate();
            System.out.println("Prenotazione effettuata con successo!");
        }
    }

    private static void visualizzaPrenotazioni(Connection conn) throws SQLException {
        String sql = "SELECT p.id, u.nome, u.cognome, c.numero, c.tipo, p.data_prenotazione " +
                     "FROM prenotazioni p " +
                     "JOIN utenti u ON p.utente_id = u.id " +
                     "JOIN camere c ON p.camera_id = c.id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                int numeroCamera = rs.getInt("numero");
                String tipoCamera = rs.getString("tipo");
                Date dataPrenotazione = rs.getDate("data_prenotazione");

                System.out.printf("Prenotazione ID: %d, Ospite: %s %s, Camera: %d (%s), Data: %s%n",
                                  id, nome, cognome, numeroCamera, tipoCamera, dataPrenotazione);
            }
        }
    }
    
}
