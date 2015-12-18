//Sam Duncan
//Modification History:
//01/14/2014: Created HousePet class with default constructor, fulls constructor, get and set methods, toString method, and readFromScanner method.


package lab6;

import java.io.PrintWriter;
import java.util.*;

public class HousePet implements Comparable <HousePet>
{
	private int chipId;
	private String name;
	private String petType;
	private double age;
	private VetVisitList visitList = new VetVisitListImpl();  
	
	// Pre: None
	// Post: Creates default HousePet with 0, **no name**, **no type**, and 0.0 as its attributes
	public HousePet()
	{
		chipId = 0;
		name = "**no name**";
		petType = "**no type**";
		age = 0.0;
	} //end of HousePet default constructor
	
	public int compareTo(HousePet housepet)
	{
		int result = 0;
		if(this.getChipId() < housepet.getChipId())
		{
			result = -1;
		}
		if(this.getChipId() > housepet.getChipId())
		{
			result = 1;
		}
		return result;
	}
	
	public int compareByName(HousePet housepet)
	{
		int result = this.getName().compareTo(housepet.getName());
		if(result == 0)
		{
			result = this.compareTo(housepet);
		}
		return result;
	}
	
	// Pre: None
	// Post: Creates HousePet with attributes chipID, name, petType, and age.
	public HousePet (int theChipId, String theName, String thePetType, double theAge)
	{
		if(theChipId < 0)
		{
			chipId = 0;
		}
		else
		{
			chipId = theChipId;
		}
		
		if(theName.length() == 0)
		{
			name = "**no name**";
		}
		else
		{
			name = theName;
		}
		
		if(thePetType.length() == 0)
		{
			petType = "**no type88";
		}
		else
		{
			petType = thePetType;
		}
		
		if(theAge < 0)
		{
			age = 0.0;
		}
		else
		{
			age = theAge;
		}
	} //end of HousePet constructor
	
	
	
	// Pre: None
	// Post: Returns chipID
	public int getChipId()
	{
		return chipId;
	} //end of getChipID
	
	// Pre: None
	// Post: Returns name
	public String getName()
	{
		return name;
	} //end of getName
	
	// Pre: None
	// Post: Returns petType
	public String getPetType()
	{
		return petType;
	} //end of getPetType
	
	// Pre: None
	// Post: Returns
	public double getAge()
	{
		return age;
	} //end of getAge
	
	//Pre: None
	//Post: Returns VetVisitList
	public VetVisitList getList()
	{
		return visitList;
	} //end of getList
	
	
	// Pre: int
	// Post: Sets chipID
	public void setChipId(int theChipId)
	{
		if(theChipId < 0)
		{
			chipId = 0;
		}
		else
		{
			chipId = theChipId;
		}
		return;
	} //end of setChipID

	// Pre: String
	// Post: Sets name
	public void setName(String theName)		
	{
		if(theName.length() == 0)
		{
			name = "**no name**";
		}
		else
		{
			name = theName;
		}
		return;
	} //end of setName
	
	// Pre: String
	// Post: Sets petType
	public void setPetType(String thePetType)
	{
		if(petType.length() == 0)
		{
			petType = "**no type**";
		}
		else
		{
			petType = thePetType;
		}
		return;
	} //end of setPetType

	// Pre: double
	// Post: Sets age
	public void setAge(double theAge)
	{
		if(age < 0)
		{
			age = 0.0;
		}
		else
		{
			age = theAge;
		}
		return;
	} //end of setAge


	
	// Pre: None
	// Post: Returns a readable string containing HousePet instance variables
	public String toString()
	{
		String housePetData = " ";
		housePetData = (chipId + " " + name + " " + petType + " " + age + " " + visitList);
		
		return housePetData;
	} //end of toString


	// Pre: Reads and stores data from Scanner
	// Post: Returns true if successful, false if unsuccessful
	public boolean readFromScanner(Scanner inputSource)
	{
		int aChipId = 0;
		String aName = " ";
		String aPetType = " ";
		double aAge = 0.0;
		
		try 
		{
			aChipId = inputSource.nextInt(); 
			inputSource.nextLine();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid ChipId entered.");
			inputSource.nextLine(); //skips bad ChipId
		}
		catch (NoSuchElementException e)
		{
			System.out.println("No ChipId found when expected. Error.");
			return false;
		}
		
		try
		{
			aName = inputSource.nextLine();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Cannot find name after ChipId. Error.");
			return false;
		}
		
		try
		{
			aPetType = inputSource.nextLine();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Cannot find petType after Name. Error.");
			return false;
		}
		
		try
		{
			aAge = inputSource.nextDouble();
			inputSource.nextLine();
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid Age entered.");
			inputSource.nextLine();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("No Age found when expected. Error.");
			return false;
		}
		
		MyUtils.vetVisitListReadFromScanner(inputSource, this.visitList);
		
		setChipId(aChipId);
		setName(aName);
		setPetType(aPetType);
		setAge(aAge);
		return true;
	} //end of readFromScanner
	
        public void writeToFile(PrintWriter outFile)
	{
 
            outFile.println(this.getChipId());
            outFile.println(this.getName());
            outFile.println(this.getPetType());
            outFile.println(this.getAge());
            this.visitList.writeToFile(outFile);

	}


} //end of class

