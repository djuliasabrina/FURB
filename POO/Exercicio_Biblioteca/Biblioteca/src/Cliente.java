import javax.swing.JOptionPane;

public class Cliente {

    private String nome;
    private int cdCliente;
    private String email;

    // Construtor
    public Cliente(String nome, int cdCliente, String email) {
        setNome(nome);
        setCdCliente(cdCliente);
        setEmail(email);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getCdCliente() {
        return cdCliente;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setNome(String nome) {
        if (nome != null && !nome.isBlank() && nome.length() >= 3) {
            this.nome = nome;
        } else {
            JOptionPane.showMessageDialog(null, "Nome do cliente inválido...", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setCdCliente(int cdCliente) {
        if (cdCliente > 0) {
            this.cdCliente = cdCliente;
        } else {
            JOptionPane.showMessageDialog(null, "Código do cliente deve ser maior que ZERO!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank() && email.length() >= 5) {
            this.email = email;
        } else {
            JOptionPane.showMessageDialog(null, "Email inválido...", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }


    // public String imprimirDados(){
    //     return getCdCliente() + " - " + getNome() + " (" + getEmail() + "). ";
    // }

    public String imprimirDados(){
        return "\nCódigo: " + getCdCliente() + "\nNome: " + getNome() + "\nE-mail: " + getEmail() + "\n";
    }
}
