package feladat1;

public class Versenyzo implements IChampionShot {

	private String name;
	private String startNum;
	private int record;
	
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
	
	
}
