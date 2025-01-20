import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Loginfenster extends JFrame implements ActionListener{
    JPanel hauptPanel;
    JButton loginbtn;
    JTextField benutzernameFeld;
    JPasswordField passwortFeld;
    private JLabel willkommensText;
    private JLabel titelBenutzername;
    private JLabel titelPasswort;


    public Loginfenster(String titel){
        super(titel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        hauptPanel = new JPanel();
        willkommensText = new JLabel("Willkommen beim BFW Ticketsystem", SwingConstants.CENTER);
        loginbtn = new JButton("Login");
        benutzernameFeld = new JTextField(16);
        passwortFeld = new JPasswordField(16);
        titelBenutzername = new JLabel("Benutzername:");
        titelPasswort = new JLabel("Passwort:");
    
        hauptPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Elemente füllen die Spaltenbreite aus
    
        // Willkommens-Text über zwei Spalten
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        hauptPanel.add(willkommensText, gbc);
    
        // Benutzername Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        hauptPanel.add(titelBenutzername, gbc);
    
        // Benutzername Textfeld mit fixer Breite
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0; // Priorisiert die Breite
        hauptPanel.add(benutzernameFeld, gbc);
    
        // Passwort Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        hauptPanel.add(titelPasswort, gbc);
    
        // Passwort Textfeld mit fixer Breite
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        hauptPanel.add(passwortFeld, gbc);
    
        // Login-Button mittig setzen
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        hauptPanel.add(loginbtn, gbc);

        loginbtn.addActionListener(this);
    
        this.add(hauptPanel);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a) {
        String benutzername = benutzernameFeld.getText();
        char[] passwort = passwortFeld.getPassword();
    
        if (Datenbank.authenticate(benutzername, passwort)) {
            JOptionPane.showMessageDialog(null, "Login erfolgreich!");
            dispose(); // Login-Fenster schließen
            new DashboardFenster(); // Nächstes Fenster öffnen
        } else {
            JOptionPane.showMessageDialog(null, "Falscher Benutzername oder Passwort!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
}
