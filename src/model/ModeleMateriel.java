package model;

public class ModeleMateriel {

	private int idModeleMateriel;
	private String nomModeleMateriel;
	private int fkTypeMateriel;
	private int fkMarque;

	public ModeleMateriel(int idModeleMateriel, String nomModeleMateriel,
			int fkTypeMateriel, int fkMarque) {
		super();
		this.idModeleMateriel = idModeleMateriel;
		this.nomModeleMateriel = nomModeleMateriel;
		this.fkTypeMateriel = fkTypeMateriel;
		this.fkMarque = fkMarque;
	}

	public ModeleMateriel() {
		super();
	}

	public int getIdModeleMateriel() {
		return idModeleMateriel;
	}

	public void setIdModeleMateriel(int idModeleMateriel) {
		this.idModeleMateriel = idModeleMateriel;
	}

	public String getNomModeleMateriel() {
		return nomModeleMateriel;
	}

	public void setNomModeleMateriel(String nomModeleMateriel) {
		this.nomModeleMateriel = nomModeleMateriel;
	}

	public int getFkTypeMateriel() {
		return fkTypeMateriel;
	}

	public void setFkTypeMateriel(int fkTypeMateriel) {
		this.fkTypeMateriel = fkTypeMateriel;
	}

	public int getFkMarque() {
		return fkMarque;
	}

	public void setFkMarque(int fkMarque) {
		this.fkMarque = fkMarque;
	}

}
