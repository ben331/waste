package model;
public class Biodegradable extends Residue
{
	//Atributos
	private boolean canBeComposted;
	
	//Constructor
	public Biodegradable(String id, String name, String origin, String color, int desTime, boolean canBeComposted)
	{
		super(id, name, origin, color, desTime);
		this.canBeComposted=canBeComposted;
	}
	
	//Getters
	public boolean getCanBeComposted()
	{
		return canBeComposted;
	}
	
	/**
	*<b>DES: </b>Este método calcula el efecto nocivo del residuo teniendo en cuenta su procedencia y su tiempo de descomposición disminuído en un 1%.<br>
	*<b>PRE: </b>El método para calcula el efecto nocivo del residuo teniendo en cuenta su procedencia y su tiempo de descomposición (calculateHarmfulEffect) debe estar definido en la super clase.<br>
	*<b>POST: </b>Se obtiene un valor que representa el efecto nocivo del residuo.<br>
	*@return harmfulEffect Es un número real que representa los días de efecto nocivo del residuo. harmfulEffect!=null
	*/
	@Override
	public double calculateHarmfulEffect()
	{
		double harmfulEffect;
		harmfulEffect=super.calculateHarmfulEffect();
		if(canBeComposted==true)
			harmfulEffect*=0.99;
		return harmfulEffect;
	}
	
	/**
	*<b>DES: </b>Este método determina si un residuo biodegradable es aprovechable con base en su tiempo de descomposición, y si es apto para compostaje.<br>
	*<b>PRE: </b>El método que determina si un residuo es aprovechable con base en su tiempo de descomposición (isUseble) debe estar definido en su super clase<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa si el residuo puede ser aprovechable.<br>
	*@return useble Es un un valor lógico que representa si el residuo puede ser aprovechable. useble!=null
	*/
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
		String cadena=canBeComposted?"\n\nThis residue can be composted":"\n\nthis residue cannot be composted";
		return super.toString()+cadena;
	}
}