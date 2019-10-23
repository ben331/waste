package model;
import java.util.ArrayList;
public class Product
{
	private String id;
	private String name;
	private String description;
	private ArrayList<Residue> wasteProducted = new ArrayList<Residue>();
	
	public Product(String id, String name, String description)
	{
		this.id=id;
		this.name=name;
		this.description=description;
	}
	
	public String getId(){return id;}
	public String getName(){return name;}
	public String getDescription(){return description;}
	
	
	//Añadir un residuo general existente
	public String addResidue(Residue residue)
	{
		wasteProducted.add(residue);
		return"Residue added";
	}
	
	
	//Añade un residuo biodegradable
	public String addResidue(String _id, String _name, String origin, String color, int desTime, boolean canBeComposted)
	{
		String message="";
		Biodegradable biodegradable = new Biodegradable(_id, _name, origin, color, desTime, canBeComposted);
		wasteProducted.add(biodegradable);
		message="\nResidue "+_name+" added correctly";
		return message;
	}
	
	//Añade un residuo inerte
	public String addResidue(String _id, String _name, String origin, String color, int desTime, String tips)
	{
		String message="";
		Inert inert = new Inert( _id,  _name,  origin,  color, desTime,  tips);
		wasteProducted.add(inert);
		message="\nResidue "+_name+" added correctly";
		return message;
	}
	
	//Añadir un residuo recyclable
	public String addResidue(String _id, String _name, String origin, String color, int desTime, String type, String properUse)
	{
		String message="";
		Recyclable recyclable = new Recyclable( _id,  _name,  origin,  color, desTime,  type, properUse);
		wasteProducted.add(recyclable);
		message="\nResidue "+_name+" added correctly";
		return message;
	}
	
	public String removeResidue(String _name)
	{
		String message="Residue "+_name+" does not exist";
		for(int i=0; i<wasteProducted.size();i++)
		{
			if(wasteProducted.get(i).getName().equals(_name))
			{
				wasteProducted.remove(i);
				message="Residue "+_name+" removed";
			}
		}
		return message;
	}
	
	public String orderAndShowWasteList()
	{
		String wasteList="";
		Residue temporary;
		
		if(wasteProducted.size()==0)
		{
			wasteList="This product dont have residues assigned";
		}
		
		//Ordenar residuos de mayor a menor efecto nocivo
		else
		{
			
			for(int i=0; i<wasteProducted.size()-1;i++)
			{
				for(int j=0; j<wasteProducted.size()-1;j++)
				{
					if(wasteProducted.get(i).calculateHarmfulEffect()<wasteProducted.get(i+1).calculateHarmfulEffect())
					{
						temporary=wasteProducted.get(j);
						wasteProducted.set(j+1, wasteProducted.get(j));
						wasteProducted.set(j, temporary);
					}
				}
			}
			
			//Generar reporte
			for(int i=0;i<wasteProducted.size();i++)
			{
				wasteList+="\n"+i+"."+wasteProducted.get(i).getName()+" harmful effect: "+wasteProducted.get(i).calculateHarmfulEffect();
			}
		}
		return wasteList;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+"\nId: "+id+" name: "+name+"\nDescription: "+description+"Waste producted: "+wasteProducted.size();
	}
}