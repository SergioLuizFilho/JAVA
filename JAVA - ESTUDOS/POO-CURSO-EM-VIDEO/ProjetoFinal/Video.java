public class Video implements AcoesVideo{
	private String titulo;
	private int avaliacao, views, curtidas;
	private boolean reproduzindo;
	
	public Video(String titulo) {
		this.setTitulo(titulo);
		this.avaliacao = 1;
		this.setViews(0);
		this.setCurtidas(0);
		this.setReproduzindo(false);
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		int nova;
		nova = (this.avaliacao + avaliacao)/ this.getViews();
		this.avaliacao = nova;
	}
	
	public int getViews() {
		return views;
	}
	
	public void setViews(int views) {
		this.views = views;
	}
	
	public int getCurtidas() {
		return curtidas;
	}
	
	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}
	
	public boolean isReproduzindo() {
		return reproduzindo;
	}
	
	public void setReproduzindo(boolean reproduzindo) {
		this.reproduzindo = reproduzindo;
	}

	@Override
	public void play() {
		this.setReproduzindo(true);
		
	}

	@Override
	public void pause() {
		this.setReproduzindo(false);		
	}

	@Override
	public void like() {
		this.setCurtidas(this.getCurtidas() + 1);
	}

	@Override
	public String toString() {
		return "Video [titulo=" + titulo + ", avaliacao=" + avaliacao + ", views=" + views + ", curtidas=" + curtidas
				+ ", reproduzindo=" + reproduzindo + "]";
	}
	
	
}
