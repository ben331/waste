package model;
import java.util.ArrayList;
public class Reciclamos
{
	//Atributos
	private ArrayList<Residue> waste;
	private ArrayList<Product> products;
	
	//Constructor
	public Reciclamos()
	{
		waste = new ArrayList<Residue>();
		products = new ArrayList<Product>();
	}
	
	//Getters
	public Residue getResidue(String residueName)
	{
		int index =-1;
		for(int i=0; i<waste.size();i++)
		{
			if(waste.get(i).getName().equals(residueName))
			{
				index=i;
			}
		}
		return waste.get(index);
	}
	
	public Product getProduct(String productName)
	{
		int index =-1;
		for(int i=0; i<products.size();i++)
		{
			if(products.get(i).getName().equals(productName))
			{
				index=i;
			}
		}
		return products.get(index);
	}
	
	/**
	*<b>DES: </b>Este método añade un objeto Residuo al arraylist waste.<br>
	*<b>PRE: </b>El dato recibido es de tipo Residue no nulo. Debe tener visibilidad a la clase Residue del paquete model<br>
	*<b>POST: </b>El residuo recibido se añade al arrayList waste, el cual aumenta en un elemento.<br>
	*@param residue Es un objeto de tipo Residue. residue!=null;
	*@return message Es un texto que confirma que se ha añadido el residuo al arrayList waste. message!=null
	*/
	public String addResidue(Residue residue)
	{
		String message="";
		waste.add(residue);
		message= "Residue "+residue.getName()+" added correctly";
		return message;
	}
	
	//BIODEGRADABLE
	/**
	*<b>DES: </b>Dados los atributos de un residuo Biodegradable, este método crea un residuo biodegradable y lo añade al arraylist.<br>
	*<b>PRE: </b>Debe tener visibilidad a la clase Residue y la clase Biodegradable del paquete model<br>
	*<b>POST: </b>El residuo creado se añade al arrayList waste, el cual aumenta en un elemento.<br>
	*@param id Es un texto que representa el id del residuo. id!=null
	*@param name Es un texto que representa el nombre del residuo. name!=null
	*@param origin Es un texto que representa la procedencia del residuo. origin!=null origin debe tomar un valor de su dominio definido.
	*@param color Es un texto que representa el color del residuo. color!=null
	*@param desTime Es un entero que representa el tiempo de descomposición del residuo. desTime!=null
	*@param canBeComposted Es un valor lógico que representa si el residuo es apto para compostaje. canBeComposted!=null
	*@return message Es un texto que confirma que se ha añadido el residuo. message!=null
	*/
	public String addResidue(String id, String name, String origin, String color, int desTime, boolean canBeComposted)
	{
		String message="\nThis residue is already added";
		Biodegradable biodegradable = new Biodegradable(id, name, origin, color, desTime, canBeComposted);
		waste.add(biodegradable);
		message="\nResidue "+name+" added correctly";
		return message;
	}
	
	//INERTE
	/**
	*<b>DES: </b>Dados los atributos de un residuo Inerte, este método crea un residuo Inerte y lo añade al arraylist.<br>
	*<b>PRE: </b>Debe tener visibilidad a la clase Residue y la clase inerte del paquete model<br>
	*<b>POST: </b>El residuo creado se añade al arrayList waste, el cual aumenta en un elemento.<br>
	*@param id Es un texto que representa el id del residuo. id!=null
	*@param name Es un texto que representa el nombre del residuo. name!=null
	*@param origin Es un texto que representa la procedencia del residuo. origin!=null origin debe tomar un valor de su dominio definido.
	*@param color Es un texto que representa el color del residuo. color!=null
	*@param desTime Es un entero que representa el tiempo de descomposición del residuo. desTime!=null
	*@param tips Es un texto que representa los consejos para reducir el uso la generación del residuo. canBeComposted!=null
	*@return message Es un texto que confirma que se ha añadido el residuo. message!=null
	*/
	public String addResidue(String id, String name, String origin, String color, int desTime, String tips)
	{
		String message="\nThis residue is already added";
		Inert inert = new Inert( id,  name,  origin,  color, desTime,  tips);
		waste.add(inert);
		message="\nResidue "+name+" added correctly";
		return message;
	}
	
	//RECYCLABLE
	/**
	*<b>DES: </b>Dados los atributos de un residuo Recyclable, este método crea un residuo Recyclable y lo añade al arraylist.<br>
	*<b>PRE: </b>Debe tener visibilidad a la clase Residue y la clase Recyclable del paquete model<br>
	*<b>POST: </b>El residuo creado se añade al arrayList waste, el cual aumenta en un elemento.<br>
	*@param id Es un texto que representa el id del residuo. id!=null
	*@param name Es un texto que representa el nombre del residuo. name!=null
	*@param origin Es un texto que representa la procedencia del residuo. origin!=null origin debe tomar un valor de su dominio definido.
	*@param color Es un texto que representa el color del residuo. color!=null
	*@param desTime Es un entero que representa el tiempo de descomposición del residuo. desTime!=null
	*@param type Es un texto que representa el material principal del residuo. type!=null. type debe tomar un valor de su dominio definido.
	*@param properUse Es un texto contiene el uso apropiado del residuo. properUse!=null.
	*@return message Es un texto que confirma que se ha añadido el residuo. message!=null
	*/
	public String addResidue(String id, String name, String origin, String color, int desTime, String type, String properUse)
	{
		String message="\nThis residue is already added";
		Recyclable recyclable = new Recyclable( id, name,  origin,  color, desTime,  type, properUse);
		waste.add(recyclable);
		message="\nResidue "+name+" added correctly";
		return message;
	}
	
	/**
	*<b>DES: </b>Este método añade un objeto Product al arraylist products.<br>
	*<b>PRE: </b>El dato recibido es de tipo Product no nulo. Debe tener visibilidad a la clase Product del paquete model<br>
	*<b>POST: </b>El producto recibido se añade al arrayList products, el cual aumenta en un elemento.<br>
	*@param product Es un objeto de tipo Product. product!=null
	*@return message Es un texto que confirma que se ha añadido el producto a el arrayList products. message!=null
	*/
	public String addProduct(Product product)
	{
		String message="\nThis product is already added";
		if(!existingProduct(product.getId(), product.getName()))
		{
			products.add(product);
			message="\nResidue "+product.getName()+" added correctly";
		}
		return message;
	}
	
	/**
	*<b>DES: </b>Dados los atributos de un obgejto Product, este método añade crea un objeto Product y lo agrega al arraylist products.<br>
	*<b>PRE: </b>Debe tener visibilidad a la clase Product del paquete model<br>
	*<b>POST: </b>El producto creado se añade al arrayList products, el cual aumenta en un elemento.<br>
	*@param id Es un texto que representa el id del producto. id!=null
	*@param name Es untexto que representa el nombre del producto. name!=null
	*@param description Es un texto que representa la descripción del producto. description!=null
	*@return message Es un texto que confirma que se ha añadido el producto a el arrayList products. message!=null
	*/
	public String addProduct(String id, String name, String description)
	{
		Product product = new Product(id, name, description);
		products.add(product);
		return "\nProduct "+name+" added correctly";
	}
	
	/**
	*<b>DES: </b>Este método devuelve una cadena de texto el cual contiene una lita con los nombres de los residuos agregados, si no hay métodos agergados la cadena de testo lo informará.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado<br>
	*@return wasteList Es una lista con los nombres de los residuos agregados al arrayList waste. wasteList!=null
	*/
	public String showWasteList()
	{
		String wasteList="";
		for(int i=0;i<waste.size();i++)
		{
			wasteList+="\nId: "+waste.get(i).getId()+" Name: "+waste.get(i).getName();
		}
		if(wasteList.equals(""))
			wasteList="\nThere are not waste";
		
		return wasteList;
	}
	
	/**
	*<b>DES: </b>Este método devuelve una cadena de texto el cual contiene una lita con los nombres de los productos agregados, si no hay productos agergados la cadena de testo lo informará.<br>
	*<b>PRE: </b>El arrayList products debe estar inicializado<br>
	*@return productsList Es una lista con los nombres de los residuos agregados al arrayList products. productsList!=null
	*/
	public String showProductsList()
	{
		String productsList="";
		for(int i=0;i<products.size();i++)
		{
			productsList+="\nId: "+products.get(i).getId()+" Name: "+products.get(i).getName();
		}
		if(productsList.equals(""))
			productsList="\nThere are not products";
		
		return productsList;
	}
	
	/**
	*<b>DES: </b>Dado un nombre y un id, este método determina si hay un residuo en el arrayList waste que tenga en su atributo name el nombre dado o en su atributo id el id dado.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado<br>
	*@param id Es un texto que representa el id del producto. id!=null
	*@param name Es untexto que representa el nombre del producto. name!=null
	*@return validation Es un valor lógico que determina si existe un residue con el nombre o el id dado. validation!=null
	*/
	public boolean existingResidue(String id, String name)
	{
		boolean validation=false;
		for(int i=0;i<waste.size();i++)
		{
			if((waste.get(i).getName().equals(name)) || (waste.get(i).getId().equals(id)))
			{
				validation=true;
				break;
			}
		}
		return validation;
	}
	
	/**
	*<b>DES: </b>Dado un nombre, este método determina si hay un residuo en el arrayList waste que tenga en su atributo name el nombre dado.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado<br>
	*@param name Es untexto que representa el nombre del producto. name!=null
	*@return validation Es un valor lógico que determina si existe un residuo con el nombre dado. validation!=null
	*/
	public boolean existingResidue(String name)
	{
		boolean validation=false;
		for(int i=0;i<waste.size();i++)
		{
			if(waste.get(i).getName().equals(name))
				validation=true;
		}
		return validation;
	}
	
	/**
	*<b>DES: </b>Dado un nombre y un id, este método determina si hay un producto en el arrayList products que tenga en su atributo name el nombre dado o en su atributo id el id dado.<br>
	*<b>PRE: </b>El arrayList products debe estar inicializado<br>
	*@param id Es un texto que representa el id del producto. id!=null
	*@param name Es untexto que representa el nombre del producto. name!=null
	*@return validation Es un valor lógico que determina si existe un producto con el nombre o el id dado. validation!=null
	*/
	public boolean existingProduct(String id, String name)
	{
		boolean validation=false;
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getName().equals(name) || products.get(i).getId().equals(id))
				validation=true;
		}
		return validation;
	}
	
	/**
	*<b>DES: </b>Dado un id, este método determina si hay un producto en el arrayList products que tenga en su atributo id el id dado.<br>
	*<b>PRE: </b>El arrayList products debe estar inicializado<br>
	*@param id Es un texto que representa el id del producto. id!=null
	*@return validation Es un valor lógico que determina si existe un producto con el id dado. validation!=null
	*/
	public boolean existingProduct(String id)
	{
		boolean validation=false;
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getName().equals(id))
				validation=true;
		}	
		return validation;
	}
	
	/**
	*<b>DES: </b>Dado el nombre de un producto agregado y un Objeto residue, este método busca un producto con el nombre dado y agrega el residuo dado en el arrayList waste Producted del producto encontrado.<br>
	*<b>PRE: </b>El arrayList products debe estar inicializado<br>
	*<b>POST: </b> El residuo dado se agrega al arrayList waste Producted del producto con el nombre dado, el cual aumenta su tamaño en un elemento.<br>
	*@param residue Es un objeto de tipo Residue. residue!=null
	*@param productName Es el nombre del producto donde se agregará el residuo dado. productName!=null
	*@return message Es un texto que confirma que se ha añadido el residuo al arrayList wasteProduct del determinado producto. message!=null
	*/
	public String addResidueToProduct(Residue residue, String productName)
	{
		String message=productName+" does not exist";
		for(int i=0; i<products.size();i++)
		{
			if(products.get(i).getName().equals(productName))
			{
				products.get(i).addResidue(residue);
				message= "Residue "+residue.getName()+" added to product "+productName;
			}
		}
		return message;
	}
	
	/**
	*<b>DES: </b>Dado el nombre de un residuo agregado y un Objeto product, este método busca un residuo con el nombre dado y asigna el producto dado en el atributo producter del residuo encontrado.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado<br>
	*<b>POST: </b> El producto dado se asigna al atributo producter del residuo con el nombre dado el cual deja de ser null.<br>
	*@param product Es un objeto de tipo Product. product!=null;
	*@param residueName Es el nombre del producto donde se asignará el residuo dado. productName!=null;
	*@return message Es un texto que confirma que se ha asignado el producto al residuo determinado. message!=null
	*/
	public String addProductToResidue(Product product, String residueName)
	{
		String message=residueName+" does not exist";
		for(int i=0; i<waste.size();i++)
		{
			if(waste.get(i).getName().equals(residueName))
			{
				waste.get(i).setProducter(product);
				message= "product "+product.getName()+" added to residue "+residueName;
			}
		}
		return message;
	}
	
	/**
	*<b>DES: </b>Este método llama al método toString de cada residuo del arrayList waste, y los clasifica y concatena en una cadena de texto.<br>
	*<b>PRE: </b>Los arrayList waste y products deben estar inicializado<br>
	*@return message Es un texto que contiene la información de los residuos agregados, esto de manera clasificada para cada clase de residuo. message!=null
	*/
	public String generateWasteReport()
	{
		String report="WASTE REPORT\n\n\n";
		String listBiodegradable="BIODEGRADABLE:\n\n";
		String listRecyclable="RECYCLABLE:\n\n";
		String listInert="INERT: \n\n";
		
		for(int i=0; i<waste.size();i++)
		{
			if(waste.get(i) instanceof Biodegradable)
			{
				listBiodegradable+=waste.get(i).toString()+"\n\n";
			}
			else if(waste.get(i) instanceof Inert)
			{
				listInert+=waste.get(i).toString()+"\n\n";
			}
			else
			{
				listRecyclable+=waste.get(i).toString()+"\n\n";
			}
		}
		report+=listBiodegradable+listInert+listRecyclable;
		return report;
	}
	
	/**
	*<b>DES: </b>Este método llama al método toString del residuo del arrayList waste que contenga el id o el nombre dado.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado.<br>
	*@param searching Es un texto que representa el id del producto o el nombre del producto a buscar. searching!=null
	*@return message Es un texto que contiene la información del residuo buscado. message!=null
	*/
	public String searchInformationResidue(String searching)
	{
		String informationResidue="Residue not found";
		if(existingResidue(searching))
			informationResidue=getResidue(searching).toString();
		else
		{
			for(int i=0; i<waste.size();i++)
			{
				if(waste.get(i).getId().equals(searching))
				{
					informationResidue=waste.get(i).toString();
					break;
				}
			}
		}
		return informationResidue;
	}
	
	/**
	*<b>DES: </b>Este método llama al método calculateHarmfulEffect del residuo del arrayList waste que contenga nombre dado y entrega el valor retornado en foma de texto.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado.<br>
	*@param name Es un texto que representa el nombre del producto. name!=null
	*@return harmFulEffect Es un texto que representa el efecto nocivo del residuo buscado. harmFulEffect!=null
	*/
	public String calculateHarmfulEffect(String name)
	{
		String harmFulEffect;
		harmFulEffect=""+(int)(getResidue(name).calculateHarmfulEffect())+" años";
		return harmFulEffect;
	}
	
	/**
	*<b>DES: </b>Este método determina si un residuo es aprovechable al llamar al método isUseble del residuo del arrayList waste que contenga el nombre dado y entrega el valor retornado en foma de texto.<br>
	*<b>PRE: </b>El arrayList waste debe estar inicializado.<br>
	*@param name Es un texto que representa el nombre del producto. name!=null
	*@return useability Es un texto que representa si el residuo buscado es aprovechable o si no es posible determinarlo por ser inerte. useability!=null
	*/
	public String determinateUseability(String name)
	{
		String useability="This residue is not usable";
		if(getResidue(name) instanceof Inert)
		{
			useability="cannot derminate the useability of Inert Residue";
		}
		else if(getResidue(name).isUseble())
		{
			useability="This residue is usable";
		}
		return useability;
	}
	
	/**
	*<b>DES: </b>Este método genera un reporte de los residuos producidos por un determinado producto ordenados de mayor a menor effecto nocivo.<br>
	*<b>PRE: </b>El arrayList products debe estar inicializado.<br>
	*@param name Es un texto que representa el nombre del producto. name!=null
	*@return harmFulWaste Es un texto que representa si el residuo buscado es aprovechable o si no es posible determinarlo por ser inerte. useability!=null
	*/
	public String sortHarmfulWaste(String name)
	{
		String harmFulWaste=getProduct(name).orderAndShowWasteList();
		return harmFulWaste;
	}
}