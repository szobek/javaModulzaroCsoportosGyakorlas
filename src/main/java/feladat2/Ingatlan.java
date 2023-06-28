package feladat2;

public class Ingatlan {
	private String tulajdonos;
	private int alapterulet;
	private int becsultErtek;
	
	
	public Ingatlan(String tulajdonos, int alapterulet, int becsultErtek) {
		this.tulajdonos = tulajdonos;
		this.alapterulet = alapterulet;
		this.becsultErtek = becsultErtek;
	}
	
	


	public String getTulajdonos() {
		return tulajdonos;
	}




	public int getAlapterulet() {
		return alapterulet;
	}




	public int getBecsultErtek() {
		return becsultErtek;
	}




	@Override
	public String toString() {
		return "Ingatlan [tulajdonos=" + tulajdonos + ", alapterulet=" + alapterulet + ", becsultErtek=" + becsultErtek
				+ "]";
	}
	
	
}
