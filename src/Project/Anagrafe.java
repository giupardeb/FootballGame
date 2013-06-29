package Project;
public class Anagrafe{
	/**
	 * @uml.property  name="cognome"
	 */
	private String cognome;
	/**
	 * @uml.property  name="eta"
	 */
	private byte eta;
	/**
	 * @uml.property  name="provenienza"
	 */
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