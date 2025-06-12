package giovedi1206.Negozio;

/* SQL
CREATE SCHEMA Negozio;
 * USE Negozio;

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    data_registrazione DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Prodotto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descrizione TEXT,
    prezzo DECIMAL(10, 2) NOT NULL,
    disponibile BOOLEAN DEFAULT TRUE
);

CREATE TABLE Ordine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_ordine DATETIME DEFAULT CURRENT_TIMESTAMP,
    stato ENUM('In lavorazione', 'Spedito', 'Consegnato', 'Annullato') DEFAULT 'In lavorazione',
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id) ON DELETE CASCADE
);

CREATE TABLE Ordine_Prodotto (
    id_ordine INT NOT NULL,
    id_prodotto INT NOT NULL,
    quantita INT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_ordine, id_prodotto),
    FOREIGN KEY (id_ordine) REFERENCES Ordine(id) ON DELETE CASCADE,
    FOREIGN KEY (id_prodotto) REFERENCES Prodotto(id) ON DELETE CASCADE
);
 */

import java.sql.*;
import java.util.*;


public class Negozio {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Gestione Ordini Negozio ===");

        while (true) {
            System.out.println("\n1. Aggiungi nuovo ordine");
            System.out.println("2. Visualizza storico ordini cliente");
            System.out.println("3. Aggiorna stato ordine");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int scelta = Integer.parseInt(scanner.nextLine());

            try (Connection conn = DBManager.getConnection()) {
                switch (scelta) {
                    case 1: 
                        aggiungiOrdine(conn);
                        break;
                    case 2: 
                        visualizzaStorico(conn);
                        break;
                    case 3: 
                        aggiornaStatoOrdine(conn);
                        break;
                    case 4: 
                        System.out.println("Uscita dal programma.");
                        scanner.close();
                        return;
                    default: System.out.println("Opzione non valida.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void aggiungiOrdine(Connection conn) throws SQLException {
        conn.setAutoCommit(false); // inizio transazione
        try {
            System.out.print("ID Cliente: ");
            int idCliente = Integer.parseInt(scanner.nextLine());

            String sqlOrdine = "INSERT INTO Ordine (id_cliente) VALUES (?)";
            try (PreparedStatement ps = conn.prepareStatement(sqlOrdine, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idCliente);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int idOrdine = rs.getInt(1);
                System.out.println("ID nuovo ordine: " + idOrdine);

                while (true) {
                    System.out.print("ID Prodotto (0 per terminare): ");
                    int idProdotto = Integer.parseInt(scanner.nextLine());
                    if (idProdotto == 0) break;

                    System.out.print("Quantità: ");
                    int quantita = Integer.parseInt(scanner.nextLine());

                    String sqlProdotto = "INSERT INTO Ordine_Prodotto (id_ordine, id_prodotto, quantita) VALUES (?, ?, ?)";
                    try (PreparedStatement ps2 = conn.prepareStatement(sqlProdotto)) {
                        ps2.setInt(1, idOrdine);
                        ps2.setInt(2, idProdotto);
                        ps2.setInt(3, quantita);
                        ps2.executeUpdate();
                    }
                }
            }
            conn.commit(); // commit finale
            System.out.println("Ordine completato.");
        } catch (SQLException e) {
            conn.rollback(); // annulla tutto
            System.out.println("Errore: transazione annullata.");
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private static void visualizzaStorico(Connection conn) throws SQLException {
        System.out.print("ID Cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        String sql = """
            SELECT o.id AS ordine_id, o.data_ordine, o.stato,
                   p.nome, p.prezzo, op.quantita
            FROM Ordine o
            JOIN Ordine_Prodotto op ON o.id = op.id_ordine
            JOIN Prodotto p ON op.id_prodotto = p.id
            WHERE o.id_cliente = ?
            ORDER BY o.data_ordine DESC
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            int ordineCorrente = -1;
            while (rs.next()) {
                int idOrdine = rs.getInt("ordine_id");
                if (idOrdine != ordineCorrente) {
                    ordineCorrente = idOrdine;
                    System.out.println("\nOrdine #" + idOrdine +
                            " | Data: " + rs.getTimestamp("data_ordine") +
                            " | Stato: " + rs.getString("stato"));
                }
                System.out.printf(" - %s x%d (%.2f €)\n",
                        rs.getString("nome"),
                        rs.getInt("quantita"),
                        rs.getDouble("prezzo"));
            }
        }
    }

    private static void aggiornaStatoOrdine(Connection conn) throws SQLException {
        System.out.print("ID Ordine da aggiornare: ");
        int idOrdine = Integer.parseInt(scanner.nextLine());

        System.out.print("Nuovo stato (In lavorazione / Spedito / Consegnato / Annullato): ");
        String nuovoStato = scanner.nextLine();

        String sql = "UPDATE Ordine SET stato = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuovoStato);
            ps.setInt(2, idOrdine);
            int updated = ps.executeUpdate();
            if (updated > 0) {
                System.out.println("Ordine aggiornato.");
            } else {
                System.out.println("Ordine non trovato.");
            }
        }
    }
}
