package model;
public class Biodegradable extends Residue
{
	private boolean canBeComposted;
	
	public Biodegradable(String id, String name, String origin, String color, int desTime, boolean canBeComposted)
	{
		super(id, name, origin, color, desTime);
		this.canBeComposted=canBeComposted;
	}
	
	public boolean getCanBeComposted()
	{
		return canBeComposted;
	}
	
	@Override
	public double calculateHarmfulEffect()
	{
		double harmfulEffect;
		harmfulEffect=super.calculateHarmfulEffect();
		if(canBeComposted==true)
			harmfulEffect*=0.99;
		return harmfulEffect;
	}
	
	@Override
	public boolean isUseble()
	{
		boolean useble;
		useble=super.isUseble() && canBeComposted;
		return useble;
	}
	
	@Override
	public String toString()
	{
		String cadena=canBeComposted?"\nThis residue can be composted":"\nthis residue cannot be composted";
		return super.toString()+cadena;
	}
}