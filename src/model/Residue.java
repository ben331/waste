package model;
public class Residue
{
	//CONSTANTES
	
	//Dominio del atributo ORIGIN
	private final String INDUSTRIAL="Industrial";
	private final String DOMICILIARY="Domiciliary";
	private final String MUNICIPAL="Municipal";
	private final String BUILDING="Building";
	private final String HOSPITABLE="Hospitable";
	
	//Psibles factores de efecto nocivo
	private final double FACTOR_INDUSTRIAL=0.1;
	private final double FACTOR_DOMICILIARY=0.05;
	private final double FACTOR_MUNICIPAL=0.12;
	private final double FACTOR_BUILDING=0.08;
	private final double FACTOR_HOSPITABLE=0.15;
	
	//Tiempo máximo de descomposición para que un producto sea aprovechable.
	private final int DESTIME_MAX_FOR_BE_USEBLE=365;
	
	//Atributos
	private String id;
	private String name;
	private String origin;
	private String color;
	private int desTime;  //Tiempo en días
	private Product producter;
	
	
	//Constructor
	public Residue(String id, String name, String origin, String color, int desTime)
	{
		this.id=id;
		this.name=name;
		this.origin=origin;
		this.color=color;
		this.desTime=desTime;
	}
	
	//Getters
	public String getId(){return id;}
	public String getName(){return name;}
	
	//Setters
	public String setProducter(String id, String name, String description)//Con sobre carga
	{
		Product producter = new Product(id, name, description);
		this.producter= producter;
		return "product added";
	}
	
	public String setProducter(Product producter)//Con sobre carga
	{
		this.producter= producter;
		return "product added";
	}
	
	/**
	*<b>DES: </b>Este método calcula el efecto nocivo del residuo teniendo en cuenta su procedencia y su tiempo de descomposición.<br>
	*<b>PRE: </b>Las constantes FACTOR_INDUSTRIAL, FACTOR_DOMICILIARY, FACTOR_BUILDING, FACTOR_HOSPITABLE, FACTOR_MUNICIPAL de tipo double, están declarada e inicializadas en la clase.<br>
	*<b>POST: </b>Se obtiene un valor que representa el efecto nocivo del residuo.<br>
	*@return harmfulEffect Es un número real que representa los días de efecto nocivo del residuo. harmfulEffect!=null
	*/
	public double calculateHarmfulEffect()
	{
		double harmfulEffect=0;
		switch(origin)
		{
			case INDUSTRIAL:
			harmfulEffect=desTime*FACTOR_INDUSTRIAL;
			break;
			case DOMICILIARY:
			harmfulEffect=desTime*FACTOR_DOMICILIARY;
			break;
			case MUNICIPAL:
			harmfulEffect=desTime*FACTOR_MUNICIPAL;
			break;
			case BUILDING:
			harmfulEffect=desTime*FACTOR_BUILDING;
			break;
			case HOSPITABLE:
			harmfulEffect=desTime*FACTOR_HOSPITABLE;
			break;
			default:
			System.out.println("Invalided option");
			break;
		}
		return harmfulEffect;
	}
	
	/**
	*<b>DES: </b>Este método determina si un residuo es aprovechable con base en su tiempo de descomposición y un valor máximo para ser aprovechable.<br>
	*<b>PRE: </b>La constante inmutable DESTIME_MAX_FOR_BE_USEBLE debe estar declarada e inicializada<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa si el residuo puede ser aprovechable.<br>
	*@return useble Es un un valor lógico que representa si el residuo puede ser aprovechable. useble!=null
	*/
	public boolean isUseble()
	{
		boolean useble=false;
		if(desTime<DESTIME_MAX_FOR_BE_USEBLE)
			useble=true;
		return useble;
	}
	
	@Override
	public String toString()
	{
		return "Id: "+id+" Name: "+name+"\nOrigin: "+origin+"\nColor: "+color+"\nDescomposition Time (days): "+desTime+"\n\nInformation of producter: \n"+producter.toString();
	}
}