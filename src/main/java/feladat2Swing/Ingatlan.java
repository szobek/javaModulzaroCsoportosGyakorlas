package feladat2Swing;

public class Ingatlan {
	private String tulajdonos;
	private int alapterulet;
	private int becsultErtek;
	private String helyrajziSzam;

	


	public Ingatlan(String tulajdonos, int alapterulet, int becsultErtek, String helyrajziSzam) {
		super();
		this.tulajdonos = tulajdonos;
		this.alapterulet = alapterulet;
		this.becsultErtek = becsultErtek;
		this.helyrajziSzam = helyrajziSzam;
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




	public void setBecsultErtek(int becsultErtek) {
		this.becsultErtek = becsultErtek;
	}




	public String getHelyrajziSzam() {
		return helyrajziSzam;
	}




	@Override
	public String toString() {
		return "Ingatlan [tulajdonos=" + tulajdonos + ", alapterulet=" + alapterulet + ", becsultErtek=" + becsultErtek
				+ ", helyrajziSzam=" + helyrajziSzam + "]";
	}


	
}
