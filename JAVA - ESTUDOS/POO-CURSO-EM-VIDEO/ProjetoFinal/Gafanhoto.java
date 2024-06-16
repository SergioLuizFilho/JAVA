
public class Gafanhoto extends Pessoa{
	private String login;
	private int totAssistidos;
	
	public Gafanhoto(String nome, int idade ,String sexo, String login) {
		super(nome, sexo, idade);
		this.setLogin(login);
		this.setTotAssistidos(0);
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getTotAssistidos() {
		return totAssistidos;
	}
	
	public void setTotAssistidos(int totAssistidos) {
		this.totAssistidos = totAssistidos;
	}
	
	public void viuMaisUm() {
		this.setTotAssistidos(this.getTotAssistidos() + 1);
	}

	@Override
	protected void ganharExp(double experiencia) {
		this.setExperiencia(experiencia);
	}

	@Override
	public String toString() {
		return "Gafanhoto [login=" + login + ", totAssistidos=" + totAssistidos + ", nome=" + nome + ", sexo=" + sexo
				+ ", idade=" + idade + ", experiencia=" + experiencia + "]";
	}
	
	
}
