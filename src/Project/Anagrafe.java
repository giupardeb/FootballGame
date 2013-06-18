package Project;
public class Anagrafe{
	private String cognome;
	private byte eta;
	private String provenienza;

	public Anagrafe (String cognome, byte eta, String provenienza){
		this.cognome = cognome;
		this.eta = eta;
		this.provenienza = provenienza;
	}


	public String GetCognome(){
		return cognome;
	}

	public byte GetEta(){
		return eta;
	}

	public String GetProvenienza(){
		return provenienza;
	}

	public String toString(){
		return "Cognome: "+cognome+ "eta: "+eta+"Provenienza: "+provenienza;
	}
}