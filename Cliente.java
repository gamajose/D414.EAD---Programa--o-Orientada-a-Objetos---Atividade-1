import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum CategoriaCliente {
    NORMAL,
    VIP
}

public class Cliente {
    private String numeroCPF;
    private String nome;
    private String email;
    private String endereco;
    private CategoriaCliente categoria;

    public Cliente(String numeroCPF, String nome, String email, String endereco, CategoriaCliente categoria) {
        this.numeroCPF = numeroCPF;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.categoria = categoria;
    }

    public String getNumeroCPF() {
        return numeroCPF;
    }

    public void setNumeroCPF(String numeroCPF) {
        this.numeroCPF = numeroCPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public CategoriaCliente getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCliente categoria) {
        this.categoria = categoria;
    }

    public boolean validarCPF() {
        String regex = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numeroCPF);
        return matcher.matches();
    }

    public double calcularValorComDesconto(double valorProduto) {
        if (categoria == CategoriaCliente.VIP) {
            return valorProduto * 0.9;
        } else {
            return valorProduto;
        }
    }

    public String imprimir() {
        return "Número CPF: " + numeroCPF + ", Nome: " + nome + ", E-mail: " + email + ", Endereço: " + endereco + ", Categoria: " + categoria;
    }
}
