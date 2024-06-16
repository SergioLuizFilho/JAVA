public class Visualizacao {
	private Gafanhoto espectador;
	private Video filme;
	
	public Visualizacao(Gafanhoto espectador, Video filme) {
		this.setEspectador(espectador);
		this.setFilme(filme);
		this.getEspectador().setTotAssistidos(this.getEspectador().getTotAssistidos() + 1);
		this.getFilme().setViews(this.getFilme().getViews() + 1);
	}
	
	public Gafanhoto getEspectador() {
		return espectador;
	}
	public void setEspectador(Gafanhoto espectador) {
		this.espectador = espectador;
	}
	public Video getFilme() {
		return filme;
	}
	public void setFilme(Video filme) {
		this.filme = filme;
	}
	
	public void avaliar() {
		this.getFilme().setAvaliacao(5);
	}
	
	public void avaliar(int nota) {
		this.getFilme().setAvaliacao(nota);
	}
	
	public void avaliar(double nota) {
		int tot = 0;
		if (nota <= 20) {
			tot = 3;
		} else if(nota <= 50) {
			tot = 5;
		} else if(nota <= 90) {
			tot = 8;
		} else {
			tot = 10;
		}
		this.getFilme().setAvaliacao(tot);
	}

	@Override
	public String toString() {
		return "Visualizacao [espectador=" + espectador + ", filme=" + filme + "]";
	}
	
	
}
