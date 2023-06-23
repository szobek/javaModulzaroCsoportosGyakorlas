package feladat1;

import java.util.random.RandomGenerator;

public class Versenyzo implements IChampionShot {
	RandomGenerator rg = RandomGenerator.getDefault();
	private String name;
	private String startNum;
	private int record;
	//private int[] lovesek = new int[5];
	private int[] lovesek = {80,85,90,rg.nextInt(80,200),rg.nextInt(1,100)};
	
	public Versenyzo(String name, String startNum, int record) {
		this.name = name;
		this.startNum = startNum;
		this.record = record;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	public String getName() {
		return name;
	}
	public String getStartNum() {
		return startNum;
	}
	public int[] getLovesek() {
		return lovesek;
	}
	@Override
	public int loves() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String rekordEllenorzes(int hanyadikKor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int countAllPoints() {
		int eddigiPont = 0;
		for (int loves : lovesek) {
			eddigiPont += loves;
		}
		return eddigiPont;
		
	}

	
	
	
	
}
