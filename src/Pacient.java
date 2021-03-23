
public class Pacient {
	String nume;
	int varsta;
	String insarcinata;
	String motiv;
	String nevoie;
	int scor;
	public Pacient(String nume, int varsta, String insarcinata, String motiv, String nevoie, int scor) {
		super();
		this.nume = nume;
		this.varsta = varsta;
		this.insarcinata = insarcinata;
		this.motiv = motiv;
		this.nevoie = nevoie;
		this.scor=scor;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	public String getInsarcinata() {
		return insarcinata;
	}
	public void setInsarcinata(String insarcinata) {
		this.insarcinata = insarcinata;
	}
	public String getMotiv() {
		return motiv;
	}
	public void setMotiv(String motiv) {
		this.motiv = motiv;
	}
	public String getNevoie() {
		return nevoie;
	}
	public void setNevoie(String nevoie) {
		this.nevoie = nevoie;
	}
	public int getScor() {
		return scor;
	}
	public void setScor(int scor) {
		this.scor = scor;
	}
	@Override
	public String toString() {
		return "Pacient [nume=" + nume + ", varsta=" + varsta + ", insarcinata=" + insarcinata + ", motiv=" + motiv
				+ ", nevoie=" + nevoie + ", scor=" + scor + "]";
	}
	
}
