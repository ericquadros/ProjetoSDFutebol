package ConexaoMysql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import servidorHttp.Erro;

public class Response {
	private int wins;
	private int losses;
	public Response(int wins, int losses) {
		super();
		this.wins = wins;
		this.losses = losses;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	@Override
	public String toString() {
		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		if(wins == 0 && losses == 0) {
			Erro erro = new Erro();
			erro.setErrorCode(2);
			erro.setErrorDescription("Dados Inexistentes");
			Gson gson = builder.create();
			return gson.toJson(erro);
		}
		Gson gson = builder.create();
		return gson.toJson(this);
	}
}