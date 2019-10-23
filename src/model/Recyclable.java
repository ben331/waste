package model;
public class Recyclable extends Residue
{
	private final String PAPER="Paper";
	private final String PAPERBOARD="Paperboard";
	private final String GLASS="Glass";
	private final String METAL="Metal";
	
	private String type;
	private String properUse;
	
	public Recyclable(String id, String name, String origin, String color, int desTime, String type, String properUse)
	{
		super(id, name, origin, color, desTime);
		this.type=type;
		this.properUse=properUse;
	}
	
	@Override
	public double calculateHarmfulEffect()
	{
		double harmfulEffect;
		harmfulEffect=super.calculateHarmfulEffect()*0.98;
		return harmfulEffect;
	}
	
	@Override
	public boolean isUseble()
	{
		boolean useble;
		useble=super.isUseble() && (properUse!=null && !properUse.equals(""));
		return useble;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+"Type: "+type+"\nProper use: \n\n"+properUse;
	}
}