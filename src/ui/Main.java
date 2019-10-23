package ui;
import java.util.Scanner;
import model.*;
public class Main
{
	public static final String INDUSTRIAL="Industrial";
	public static final String DOMICILIARY="Domiciliary";
	public static final String MUNICIPAL="Municipal";
	public static final String BUILDING="Building";
	public static final String HOSPITABLE="Hospitable";
	
	private static final String PAPER="Paper";
	private static final String PAPERBOARD="Paperboard";
	private static final String GLASS="Glass";
	private static final String METAL="Metal";
	
	private static Scanner reader= new Scanner(System.in);
	private static Reciclamos reciclamos = new Reciclamos();
	
	public static void main(String[]args)
	{
		//Variables
		int option=0;
		String varSearching="";
		String varResidueName="";
		String varProductName="";
		
		//Instancias predeterminadas.
		inIt();
		
		//Inicio.
		System.out.println("Welcome to Reciclamos ");
		do
		{
			//Menu
			System.out.print("\n1.Waste \n2.Products \n3.Add residue \n4.Add product \n5.Generate waste report \n6.Search Residue Information \n7.Calculate harmful effect \n8.Determinate useability \n9.Sort harmful waste \n10.Exit \nSelect an option: ");
			option=reader.nextInt();
			reader.nextLine();
			
			switch(option)
			{
				
				//Muestra una lista de residuos
				case 1:
				System.out.println("\nWaste list:\n\n"+reciclamos.showWasteList());
				break;
				
				//Muestra una lista de productos
				case 2:
				System.out.println("\nProducts list: \n\n"+reciclamos.showProductsList());
				break;
				
				//Agrega un residuo
				case 3:
				createResidue();
				break;
				
				//Agreaga un producto
				case 4:
				createProduct();
				break;
				
				//Genera un reporte de los residuos agregados
				case 5:
				System.out.println(reciclamos.gerateWasteReport());
				break;
				
				//Busca información de un residuo en específico
				case 6:
				System.out.println(reciclamos.showWasteList()+"\n\nType a residue id or a residue name to search.");
				varSearching=reader.nextLine();
				System.out.println(reciclamos.searchInformationResidue(varSearching));
				break;
				
				//Calcula el efecto nocivo de un residuo en específico
				case 7:
				System.out.println(reciclamos.showWasteList()+"\n\n Type the residue name to calculate its harmful effect");
				varResidueName=reader.nextLine();
				if(!reciclamos.existingResidue(varResidueName))
				{
					System.out.println("This residue does not exist");
					break;
				}
				System.out.println("Harmful effect of "+varResidueName+": "+reciclamos.calculateHarmfulEffect(varResidueName));
				break;
				
				//Determina si un resdiduo específico es aprovechable o no.
				case 8:
				System.out.println(reciclamos.showWasteList()+"\n\nRemember that thos function only is allowed for Biodegradables waste and Recyclables wasted\nType the residue name to determinate its useability");
				varResidueName=reader.nextLine();
				if(!reciclamos.existingResidue(varResidueName))
				{
					System.out.println("This residue does not exist");
					break;
				}
				System.out.println(reciclamos.determinateUseability(varResidueName));
				break;
				
				//Ordenar la lista de residuos de un producto en especifico de mayor a menor efecto nocivo
				case 9:
				System.out.println(reciclamos.showProductsList()+"\n\n Type the product name to sort its harmful waste");
				varProductName=reader.nextLine();
				if(!reciclamos.existingProduct(varProductName))
				{
					System.out.println("This product does not exist");
					break;
				}
				System.out.println(reciclamos.sortHarmfulWaste(varProductName));
				break;
				
				case 10:
				break;
				default:
				System.out.println("Invalided Option");
				break;
			}
			
		}while(option!=10);
	}
	
	public static void inIt()
	{
		Product banano = new Product("01", "Banano", "Fruta");
		reciclamos.addProduct(banano);
		Product cuaderno = new Product("02", "cuaderno", "Util escolar");
		reciclamos.addProduct(cuaderno);
		
		Biodegradable cascaraBanano= new Biodegradable("01", "Cascara de banano", DOMICILIARY, "Verde", 10, true);
		reciclamos.addResidue(cascaraBanano);
		reciclamos.addProductToResidue(banano, "Cascara de banano");
		reciclamos.addResidueToProduct(cascaraBanano, "Banano");
		
		Recyclable hojasCuaderno = new Recyclable("02", "Hojas de cuaderno", INDUSTRIAL, "blanco", 1576, PAPER, "El mejor uso lo puede dar la industria al reutilizarlas en nuevos cuadernos.");
		reciclamos.addResidue(hojasCuaderno);
		reciclamos.addProductToResidue(cuaderno, "Hojas de cuaderno");
		reciclamos.addResidueToProduct(hojasCuaderno, "cuaderno");
	}
	
	public static void createResidue()
	{
		//Variables
		int optionOrigin=0;
		String optionProducto="";
		int optionComposted=0;
		int optionRecyclableType=0;
		int varResidueType=0;
		int varDesTime=0;
		boolean varCanBeComposted=false;
		
		String varResidueId="";
		String varResidueName="";
		String varOrigin="";
		String varColor="";
		String varDescription="";
		String varTypeRecyclable="";
		String varProperUse="";
		String varTips="";
		String varProductName="";
		String varProductId="";
		
		Product varProduct;
		Residue varResidue;
		Biodegradable varBiodegradable;
		Inert varInert;
		Recyclable varRecyclable;
		
		do
		{
			//Pedir un id
			System.out.print("\nType the residue id: ");
			varResidueId=reader.nextLine();
			
			//Pedir un nombre
			System.out.print("\nType the residue name: ");
			varResidueName=reader.nextLine();
			
			if(reciclamos.existingResidue(varResidueId, varResidueName))
			{
				System.out.println("\nError name or id denied: There are a residue with id "+varResidueId+" or name "+ varResidueName+". Try again: ");
			}
		
		}while(reciclamos.existingResidue(varResidueId, varResidueName));
		
		//Pedir una procedencia
		do
		{
			System.out.print("\n1.Industrial \n2.Domiciliary \n3.Municipal \n4.Building \n5.Hospitable \nSelect the residue origin: ");
			optionOrigin=reader.nextInt();
			reader.nextLine();
			
			switch(optionOrigin)
			{
				case 1:
				varOrigin=INDUSTRIAL;
				break;
				case 2:
				varOrigin=DOMICILIARY;
				break;
				case 3:
				varOrigin=MUNICIPAL;
				break;
				case 4:
				varOrigin=BUILDING;
				break;
				case 5:
				varOrigin=HOSPITABLE;
				break;
				default:
				System.out.println("\nInvalided Option");
				continue;
			}
		}while(false);
		
		//Pedir un color
		System.out.print("\nType the residue color: ");
		varColor=reader.nextLine();
		
		//Pedir un tiempo de descomposición
		System.out.print("\nType the residue descomposition time (days): ");
		varDesTime=reader.nextInt();
		reader.nextLine();
		
		//Pedir un producto
		do
		{
			System.out.print(reciclamos.showProductsList()+"\n\nType the product name that produce this residue, or Type 'new' for create a new product: ");
			optionProducto=reader.nextLine();
			
			//Si el usuario escribe new
			if(optionProducto.equalsIgnoreCase("new"))
			{
				
				//Pedir nombre del producto
				System.out.print("\nType the product name: ");
				varProductName=reader.nextLine();
				
				//Pedir id del producto
				System.out.print("\nType an Id for this product: ");
				varProductId=reader.nextLine();
				
				//Si el producto que se está creando ya existía vuelve al menu.
				if(reciclamos.existingProduct(varProductId, varProductName))
				{
					System.out.println("This product is already created.");
					continue;
				}
				//Pedir una descripción del producto
				System.out.print("\nType a description for this product: ");
				varDescription=reader.nextLine();
				
				//Añadir producto a la lista de productos
				System.out.println(reciclamos.addProduct(varProductId, varProductName, varDescription));
			}
			
			//Si se trabaja con un producto ya existente
			else
			{
				//Si el producto que me pide no existe, vuelve al menu.
				if(!reciclamos.existingProduct(optionProducto))
				{
					System.out.println("\nThis product does not exist");
					continue;			
				}
				//Se obtiene el producto existente
				varProductName=reciclamos.getProduct(optionProducto).getName();
				varProductId=reciclamos.getProduct(optionProducto).getId();
				varDescription=reciclamos.getProduct(optionProducto).getDescription();
			}
		}while((optionProducto.equalsIgnoreCase("new") && !reciclamos.existingProduct(varProductId, varProductName))|(!optionProducto.equalsIgnoreCase("new") && !reciclamos.existingProduct(varProductId, varProductName)));
		
		//Pedir el tipo de residuo
		do
		{
			System.out.println("\nResidue type. \n1.Biodegradable \n2.Inert \n3.Recyclable");
			varResidueType=reader.nextInt();
			reader.nextLine();
		}while(varResidueType<1 && varResidueType>3);
		
		//Añadir un residuo con los datos ingresados dependiendo el tipo.
		switch(varResidueType)
		{
			//Biodegradable
			case 1:
			System.out.println("\nThis residue can be composted? \n1.Yes \n2.No");
			optionComposted= reader.nextInt();
			reader.nextLine();
			if(optionComposted==1)
				varCanBeComposted=true;
			else
				varCanBeComposted=false;
			
			//Agregar Residuo a la lista de residuos
			varBiodegradable = new Biodegradable(varResidueId, varResidueName, varOrigin, varColor, varDesTime, varCanBeComposted);
			System.out.println(reciclamos.addResidue(varBiodegradable));
			//Agregar residuo a la lista de residuos del producto correspondiente
			System.out.println(reciclamos.addResidueToProduct(varBiodegradable, varProductName));
			break;
			
			//Inert
			case 2:
			System.out.println("Write some tips for reduce its use. (You can leave this space blank)");
			varTips=reader.nextLine();
			
			//Agregar Residuo a la lista de residuos
			varInert = new Inert(varResidueId, varResidueName, varOrigin, varColor, varDesTime, varTips);
			System.out.println(reciclamos.addResidue(varInert));
			
			//Agregar residuo a la lista de residuos del producto correspondiente
			System.out.println(reciclamos.addResidueToProduct(varInert, varProductName));
			break;
			
			//Recyclable
			case 3:
			do
			{
				System.out.println("\n1.Paper \n2.Paperboard \n3.Glass \n4.Metal");
				optionRecyclableType= reader.nextInt();
				reader.nextLine();
				{
					switch(optionRecyclableType)
					{
						case 1:
						varTypeRecyclable = PAPER;
						break;
						case 2:
						varTypeRecyclable = PAPERBOARD;
						break;
						case 3:
						varTypeRecyclable = GLASS;
						break;
						case 4:
						varTypeRecyclable = METAL;
						break;
						default:
						System.out.println("Invalided Option");
						continue;
					}
				}
			}while(false);
			System.out.println("Type the proper use of this residue in the homes and in the industry");
			varProperUse= reader.nextLine();
			
			//Agregar Residuo a la lista de residuos
			varRecyclable = new Recyclable(varResidueId, varResidueName, varOrigin, varColor, varDesTime, varTypeRecyclable, varProperUse);
			System.out.println(reciclamos.addResidue(varRecyclable));
			
			//Agregar residuo a la lista de residuos del producto correspondiente
			System.out.println(reciclamos.addResidueToProduct(varRecyclable, varProductName));
			
			break;
		}
		//Agregar producto al residuo creado
		varProduct = new Product(varProductId, varProductName, varDescription);
		System.out.println(""+reciclamos.addProductToResidue(varProduct, varResidueName));
	}
	
	public static void createProduct()
	{
		Product varProduct;
		String varProductId="";
		String varProductName="";
		String varDescription="";
		String varResidueName="";
		int option1=0;
		
		do
		{
			//Pedir un id
			System.out.print("\nType the product id: ");
			varProductId=reader.nextLine();
			
			//Pedir un nombre
			System.out.print("\nType the product name: ");
			varProductName=reader.nextLine();
			
			if(reciclamos.existingProduct(varProductId, varProductName))
			{
				System.out.println("There are a product with id "+varProductId+" or name "+ varProductName);
			}
		}while(reciclamos.existingResidue(varResidueName, varProductName));
		
		System.out.println("\nType the product description: ");
		varDescription=reader.nextLine();
		
		System.out.println(reciclamos.addProduct(varProductId, varProductName, varDescription));
		
		System.out.println("\n\n1.Add waste to this product. \n2.Finish");
		option1=reader.nextInt();
		reader.nextLine();
		
		switch(option1)
		{
			case 1:
			do
			{
				System.out.println(reciclamos.showWasteList());
				
				System.out.println("n\nType the residue name producted by this product or type 'back' to exit");
				varResidueName=reader.nextLine();
				
				if(varResidueName.equalsIgnoreCase("back"))
				{
					break;
				}
				if(reciclamos.existingResidue(varResidueName))
				{
					System.out.println(reciclamos.addResidueToProduct(reciclamos.getResidue(varResidueName), varProductName));
				}
				else
				{
					System.out.println(varResidueName+" does not exist");
					continue;
				}
			}while(!varResidueName.equalsIgnoreCase("back"));
			break;
		}
	}
}