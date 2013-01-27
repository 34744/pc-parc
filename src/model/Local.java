package model;

public class Local {
	private int idLocal;
	private String nomLocal, fkService;

	public Local(int idLocal, String nomLocal, String fkService) {
		super();
		this.idLocal = idLocal;
		this.nomLocal = nomLocal;
		this.fkService = fkService;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

	public String getFkService() {
		return fkService;
	}

	public void setFkService(String fkService) {
		this.fkService = fkService;
	}

}
