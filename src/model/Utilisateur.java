package model;

public class Utilisateur {

	private String codeUser, nomUser, mdpUser, fonctionUser;

	public Utilisateur(String codeUser, String nomUser, String mdpUser,
			String fonctionUser) {
		super();
		this.codeUser = codeUser;
		this.nomUser = nomUser;
		this.mdpUser = mdpUser;
		this.fonctionUser = fonctionUser;
	}

	public Utilisateur() {
		super();
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getMdpUser() {
		return mdpUser;
	}

	public void setMdpUser(String mdpUser) {
		this.mdpUser = mdpUser;
	}

	public String getFonctionUser() {
		return fonctionUser;
	}

	public void setFonctionUser(String fonctionUser) {
		this.fonctionUser = fonctionUser;
	}

}
