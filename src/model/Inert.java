package model;
public class Inert extends Residue
{
	private String tips;
	
	public Inert(String id, String name, String origin, String color, int desTime, String tips)
	{
		super(id, name, origin, color, desTime);
		this.tips=tips;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+"\nTips: "+tips;
	}
}