public abstract class Pessoa {
	protected String nome, sexo;
	protected int idade;
	protected double experiencia;
	
	public Pessoa(String nome, String sexo, int idade) {
		this.setNome(nome);
		this.setSexo(sexo);
		this.setIdade(idade);
		this.setExperiencia(0.0);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public double getExperiencia() {
		return experiencia;
	}
	
	public void setExperiencia(double experiencia) {
		this.experiencia = experiencia;
	}
	
	protected abstract void ganharExp(double experiencia);
	
}
