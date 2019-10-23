package model;
public class Residue
{
	public final String INDUSTRIAL="Industrial";
	public final String DOMICILIARY="Domiciliary";
	public final String MUNICIPAL="Municipal";
	public final String BUILDING="Building";
	public final String HOSPITABLE="Hospitable";
	
	public final double FACTOR_INDUSTRIAL=0.1;
	public final double FACTOR_DOMICILIARY=0.05;
	public final double FACTOR_MUNICIPAL=0.12;
	public final double FACTOR_BUILDING=0.08;
	public final double FACTOR_HOSPITABLE=0.15;
	
	public final int DESTIME_MAX_FOR_BE_USEBLE=365;
	
	private String id;
	private String name;
	private String origin;
	private String color;
	private int desTime;
	private double harmfulEffect;
	private Product producter;
	
	public Residue(String id, String name, String origin, String color, int desTime)
	{
		this.id=id;
		this.name=name;
		this.origin=origin;
		this.color=color;
		this.desTime=desTime;
	}
	
	public String getId(){return id;}
	public String getName(){return name;}
	
	public String addProducter(String id, String name, String description)
	{
		Product producter = new Product(id, name, description);
		this.producter= producter;
		return "product added";
	}
	
	public String addProducter(Product producter)
	{
		this.producter= producter;
		return "product added";
	}
	
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
		}
		return harmfulEffect;
	}
	
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
		return super.toString()+"Id: "+id+" Name: "+name+"\nOrigin: "+origin+"\nColor: "+color+"\nDescomposition Time (days): "+desTime+producter.toString();
	}
}