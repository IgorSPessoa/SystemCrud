package system.DTO;

public class PedidosDTO {

    private int id, criadopor, numcasa;
    private String nome, email, datacriada, datacoleta, tipo, rua, cidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCriadopor() {
        return criadopor;
    }

    public void setCriadopor(int criadopor) {
        this.criadopor = criadopor;
    }

    public int getNumcasa() {
        return numcasa;
    }

    public void setNumcasa(int numcasa) {
        this.numcasa = numcasa;
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

    public String getDatacriada() {
        return datacriada;
    }

    public void setDatacriada(String datacriada) {
        this.datacriada = datacriada;
    }

    public String getDatacoleta() {
        return datacoleta;
    }

    public void setDatacoleta(String datacoleta) {
        this.datacoleta = datacoleta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
