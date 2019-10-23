package model;
import java.util.ArrayList;
public class Reciclamos
{
	private ArrayList<Residue> waste = new ArrayList<Residue>();
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Reciclamos(){}
	
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
	
	//Añade un residuo general
	public String addResidue(Residue residue)
	{
		waste.add(residue);
		return "Residue "+residue.getName()+" added correctly";
	}
	
	//Añade un residuo biodegradable
	public String addResidue(String id, String name, String origin, String color, int desTime, boolean canBeComposted)
	{
		String message="\nThis residue is already added";
		Biodegradable biodegradable = new Biodegradable(id, name, origin, color, desTime, canBeComposted);
		waste.add(biodegradable);
		message="\nResidue "+name+" added correctly";
		return message;
	}
	
	//Añade un residuo inerte
	public String addResidue(String id, String name, String origin, String color, int desTime, String tips)
	{
		String message="\nThis residue is already added";
		Inert inert = new Inert( id,  name,  origin,  color, desTime,  tips);
		waste.add(inert);
		message="\nResidue "+name+" added correctly";
		return message;
	}
	
	//Añadir un residuo recyclable
	public String addResidue(String id, String name, String origin, String color, int desTime, String type, String properUse)
	{
		String message="\nThis residue is already added";
		Recyclable recyclable = new Recyclable( id, name,  origin,  color, desTime,  type, properUse);
		waste.add(recyclable);
		message="\nResidue "+name+" added correctly";
		return message;
	}
	
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
	
	public String addProduct(String id, String name, String description)
	{
		Product product = new Product(id, name, description);
		products.add(product);
		return "\nProduct "+name+" added correctly";
	}
	
	public String removeResidue(String name)
	{
		String message="Residue "+name+" does not exist";
		for(int i=0; i<waste.size();i++)
		{
			if(waste.get(i).getName().equals(name))
			{
				waste.remove(i);
				message="Residue "+name+" removed";
			}
		}
		return message;
	}
	
	public String removeProduct(String name)
	{
		String message="Residue "+name+" does not exist";
		for(int i=0; i<products.size();i++)
		{
			if(products.get(i).getName().equals(name))
			{
				products.remove(i);
				message="Residue "+name+" removed";
			}
		}
		return message;
	}
	
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
	
	public boolean existingResidue( String name)
	{
		boolean validation=false;
		for(int i=0;i<waste.size();i++)
		{
			if(waste.get(i).getName().equals(name))
				validation=true;
		}
		return validation;
	}
	
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
	
	public String addResidueToProduct(Residue residue, String productName)
	{
		String message=productName+" does not exist";
		for(int i=0; i<products.size();i++)
		{
			if(products.get(i).getName().equals(productName))
			{
				products.get(i).addResidue(residue);
				message= "";
			}
		}
		return message;
	}
	
	public String addProductToResidue(Product product, String residueName)
	{
		String message=residueName+" does not exist";
		for(int i=0; i<waste.size();i++)
		{
			if(waste.get(i).getName().equals(residueName))
			{
				waste.get(i).addProducter(product);
				message= "product "+product.getName()+" added to residue "+residueName;
			}
		}
		return message;
	}
	
	public String gerateWasteReport()
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
	
	public String calculateHarmfulEffect(String name)
	{
		return ""+(getResidue(name).calculateHarmfulEffect()*100)+"%";
	}
	
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
	
	public String sortHarmfulWaste(String name)
	{
		String harfulWaste=getProduct(name).orderAndShowWasteList();
		return harfulWaste;
	}
}