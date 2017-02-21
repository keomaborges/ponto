package Sistema;

public class Funcionario {
	protected int id;
    protected String nome;
 
    public Funcionario() {
    }
 
    public Funcionario(int id) {
        this.id = id;
    }
 
    public Funcionario(int id, String nome) {
        this.nome = nome;
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public Funcionario (String nome){
    	this.nome = nome;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
}
