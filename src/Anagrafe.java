public class Anagrafe{
	private String nome;
	private String cognome;
	private byte età;
	private String provenienza;
	
	public Anagrafe (String nome, String cognome, byte età, String provenienza){
		this.nome = nome;
		this.cognome = cognome;
		this.età = età;
		this.provenienza = provenienza;
	}
	
	public String GetNome(){
		return nome;
	}
	public String GetCognome(){
		return cognome;
	}
	
	public byte GetEta(){
		return età;
	}
	
	public String GetProvenienza(){
		return provenienza;
	}
	
	public String toString(){
		return "Nome: "+ nome + "Cognome: "+cognome+ "Età: "+età+"Provenienza: "+provenienza;
	}
}