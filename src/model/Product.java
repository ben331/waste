package model;
import java.util.ArrayList;
public class Product
{
	//Atributos
	private String id;
	private String name;
	private String description;
	private ArrayList<Residue> wasteProducted = new ArrayList<Residue>();
	
	//Constructor
	public Product(String id, String name, String description)
	{
		this.id=id;
		this.name=name;
		this.description=description;
	}
	
	//Getters
	public String getId(){return id;}
	public String getName(){return name;}
	public String getDescription(){return description;}
	
	
	/**
	*<b>DES: </b>Este método añade un objeto Residuo al arraylist wasteProducted.<br>
	*<b>PRE: </b>El dato recibido es de tipo Residue no nulo. Debe tener visibilidad a la clase Residue del paquete model<br>
	*<b>POST: </b>El residuo recibido se añade al arrayList wasteProducted, el cual aumenta en un elemento.<br>
	*@param residue Es un objeto de tipo Residue. residue!=null;
	*@return message Es un texto que confirma que se ha añadido el residuo al arrayList wasteProducted. message!=null
	*/
	public String addResidue(Residue residue)
	{
		wasteProducted.add(residue);
		return"Residue added";
	}
	
	
	//Añade un residuo biodegradable
	/**
	*<b>DES: </b>Este método determina si un residuo es aprovechable con base en su tiempo de descomposición.<br>
	*<b>PRE: </b>La constante inmutable DESTIME_MAX_FOR_BE_USEBLE debe estar declarada e inicializada<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa la capacidad de un residuo para compostaje.<br>
	*@param _id Es un texto que representa el id del residuo. _id!=null
	*@param _name Es un texto que representa el nombre del residuo. _name!=null
	*@param origin Es un texto que representa la procedencia del residuo. origin!=null origin debe tomar un valor de su dominio definido.
	*@param color Es un texto que representa el color del residuo. color!=null
	*@param desTime Es un entero que representa el tiempo de descomposición del residuo. desTime!=null
	*@param canBeComposted Es un valor lógico que representa si el residuo es apto para compostaje. canBeComposted!=null
	*@return message Es un texto que confirma que se ha añadido el residuo. message!=null
	*/
	public String addResidue(String _id, String _name, String origin, String color, int desTime, boolean canBeComposted)
	{
		String message="";
		Biodegradable biodegradable = new Biodegradable(_id, _name, origin, color, desTime, canBeComposted);
		wasteProducted.add(biodegradable);
		message="\nResidue "+_name+" added correctly";
		return message;
	}
	
	//Añade un residuo inerte
	
	/**
	*<b>DES: </b>Este método determina si un residuo es aprovechable con base en su tiempo de descomposición.<br>
	*<b>PRE: </b>La constante inmutable DESTIME_MAX_FOR_BE_USEBLE debe estar declarada e inicializada<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa la capacidad de un residuo para compostaje.<br>
	*@param _id Es un texto que representa el id del residuo. _id!=null
	*@param _name Es un texto que representa el nombre del residuo. _name!=null
	*@param origin Es un texto que representa la procedencia del residuo. origin!=null origin debe tomar un valor de su dominio definido.
	*@param color Es un texto que representa el color del residuo. color!=null
	*@param desTime Es un entero que representa el tiempo de descomposición del residuo. desTime!=null
	*@param tips Es un texto que representa los consejos para reducir el uso la generación del residuo. canBeComposted!=null
	*@return message Es un texto que confirma que se ha añadido el residuo. message!=null
	*/
	public String addResidue(String _id, String _name, String origin, String color, int desTime, String tips)
	{
		String message="";
		Inert inert = new Inert( _id,  _name,  origin,  color, desTime,  tips);
		wasteProducted.add(inert);
		message="\nResidue "+_name+" added correctly";
		return message;
	}
	
	//Añadir un residuo recyclable
	
	/**
	*<b>DES: </b>Este método determina si un residuo es aprovechable con base en su tiempo de descomposición.<br>
	*<b>PRE: </b>La constante inmutable DESTIME_MAX_FOR_BE_USEBLE debe estar declarada e inicializada<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa la capacidad de un residuo para compostaje.<br>
	*@param _id Es un texto que representa el id del residuo. _id!=null
	*@param _name Es un texto que representa el nombre del residuo. _name!=null
	*@param origin Es un texto que representa la procedencia del residuo. origin!=null origin debe tomar un valor de su dominio definido.
	*@param color Es un texto que representa el color del residuo. color!=null
	*@param desTime Es un entero que representa el tiempo de descomposición del residuo. desTime!=null
	*@param type Es un texto que representa el material principal del residuo. type!=null. type debe tomar un valor de su dominio definido.
	*@param properUse Es un texto contiene el uso apropiado del residuo. properUse!=null.
	*@return message Es un texto que confirma que se ha añadido el residuo. message!=null
	*/
	public String addResidue(String _id, String _name, String origin, String color, int desTime, String type, String properUse)
	{
		String message="";
		Recyclable recyclable = new Recyclable( _id,  _name,  origin,  color, desTime,  type, properUse);
		wasteProducted.add(recyclable);
		message="\nResidue "+_name+" added correctly";
		return message;
	}
	
	/**
	*<b>DES: </b>Este método ordena los residuo del arraylist wasteProducted de mayor a menor efecto nocivo y luego los guarda en una cadena de texto.<br>
	*<b>PRE: </b>El nombre recibido debe ser<br>
	*<b>POST: </b>Se obtiene un valor lógico que representa la capacidad de un residuo para compostaje.<br>
	*@return  wasteList Es una cadena de texto que resenta una lista de residuos propios ordenados delde mayor residuio
	*/
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
				wasteList+="\n"+(i+1)+"."+wasteProducted.get(i).getName()+" harmful effect: "+(wasteProducted.get(i).calculateHarmfulEffect())+" días";
			}
		}
		return wasteList;
	}
	
	@Override
	public String toString()
	{
		return "\nId: "+id+" name: "+name+"\nDescription: "+description+"\nWaste producted: "+wasteProducted.size();
	}
}