package feladat1;

public class Versenyzo {

	private String name;
	private String startNum;
	private int record;
	private int[] lovesek = new int[5];
	
	public Versenyzo(String name, String startNum, int record) {
		super();
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
	
	
}
