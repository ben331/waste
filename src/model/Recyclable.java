package model;
public class Recyclable extends Residue
{
	//Constantes del dominio del atributo type
	private final String PAPER="Paper";
	private final String PAPERBOARD="Paperboard";
	private final String GLASS="Glass";
	private final String METAL="Metal";
	
	//Atributos
	private String type;
	private String properUse;
	
	//Cosntructor
	public Recyclable(String id, String name, String origin, String color, int desTime, String type, String properUse)
	{
		super(id, name, origin, color, desTime);
		this.type=type;
		this.properUse=properUse;
	}
	
	/**
	*<b>DES: </b>Este método calcula el efecto nocivo del residuo teniendo en cuenta su procedencia y su tiempo de descomposición disminuído en un 2%.<br>
	*<b>PRE: </b>El método para calcula el efecto nocivo del residuo teniendo en cuenta su procedencia y su tiempo de descomposición (calculateHarmfulEffect) debe estar definido en la super clase.<br>
	*<b>POST: </b>Se obtiene un valor que representa el efecto nocivo del residuo.<br>
	*@return harmfulEffect Es un número real que representa los días de efecto nocivo del residuo. harmfulEffect!=null
	*/
	
	@Override
	public double calculateHarmfulEffect()
	{
		double harmfulEffect;
		harmfulEffect=super.calculateHarmfulEffect()*0.98;
		return harmfulEffect;
	}
	
	/**
	*<b>DES: </b>Este método determina si un residuo reciclable es aprovechable con base en su tiempo de descomposición, y si tiene definido su uso adecuado.<br>
	*<b>PRE: </b>El método que determina si un residuo es aprovechable con base en su tiempo de descomposición (isUseble) debe estar definido en su super clase<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa si el residuo puede ser aprovechable.<br>
	*@return useble Es un un valor lógico que representa si el residuo puede ser aprovechable. useble!=null
	*/
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
		return super.toString()+"\n\nType: "+type+"\nProper use: \n\n"+properUse;
	}
}