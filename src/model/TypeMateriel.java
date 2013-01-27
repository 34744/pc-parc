package model;

public class TypeMateriel {

	private int idTypeMateriel;
	private String nomTypeMateriel;

	public TypeMateriel(int idTypeMateriel, String nomTypeMateriel) {
		super();
		this.idTypeMateriel = idTypeMateriel;
		this.nomTypeMateriel = nomTypeMateriel;
	}

	public int getIdTypeMateriel() {
		return idTypeMateriel;
	}

	public void setIdTypeMateriel(int idTypeMateriel) {
		this.idTypeMateriel = idTypeMateriel;
	}

	public String getNomTypeMateriel() {
		return nomTypeMateriel;
	}

	public void setNomTypeMateriel(String nomTypeMateriel) {
		this.nomTypeMateriel = nomTypeMateriel;
	}

}
