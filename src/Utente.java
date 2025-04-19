public class Utente {
    private String username;
    private String email;
    private String nome;
    private String cognome;

    public Utente(String username,String email, String nome, String cognome) {
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Utente(String email, String nome, String cognome) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
