package lab6;

//Sam Duncan
//Modification History:
//Created HousePetListImpl.java (01/21/2014)
//Added sortByChipIdentifier, sortByName, and compareTo methods. (01/23/2014)
//Added add, binSearch, contains, remove, removeAll, and size methods. (02/05/2014)
//Modified binSearch, add, remove, and size methods. (02/11/2014)

import java.util.*;
import java.io.*;



public class HousePetListImpl implements HousePetList
{
	private HousePet list[];
	private int count;
	private boolean saved;
	
	
	public HousePetListImpl()
	{
		this.list = new HousePet[HousePetList.MAX_SIZE];
		this.count = 0;
	}// end of HousePetListImpl

	//pre: nothing
	//post: returns readable String of a HousePet
	public String toString()
	{
		String temp = "";
		if(this.count == 0)
			{
				temp = "Empty List";
			}
		for(int index = 0; index < this.count; index++)
		{
			temp += this.list[index] + "\n";
		}// end of for
		return temp;
	}// end of toString
	
	//pre: input from scanner
	//post: nothing
	public void readFromScanner(Scanner inputSource)
	{
		if(inputSource == null)
		{
			return;
		}
		HousePet pet = new HousePet();
		boolean result = pet.readFromScanner(inputSource);
		while (result == true && this.count < HousePetList.MAX_SIZE)
		{
			if(this.count == HousePetList.MAX_SIZE && result == true)
			{
				this.saved = false;
			}
			this.list[count] = pet;
			for(int i = 0; i <= this.count; i++)
			{
				if(pet == this.list[i])
				{
					HousePet delete = new HousePet();
					delete = this.list[i];
					remove(delete);
					this.saved = false;
				}
			}
			this.count++;
			pet = new HousePet();
			result = pet.readFromScanner(inputSource);
		}
		this.sortByChipIdentifier();
	}// end of readFromScanner
	
	//pre: Nothing
	//post: Nothing
	 public void sortByChipIdentifier()
	 {
		 for(int index = 1; index < count; index++)
		 {
			int k = index;
			while(k > 0)
			{
				if(this.list[k].compareTo(this.list[k-1]) < 0)
				{
					HousePet temp = list[k];
					list[k] = list[k-1];
					list[k-1] = temp;
					k--;
				}
				else
				{
					k = 0;
				}
			} // end of while loop
		 } // end of for loop
	 }
	 
	 //pre: nothing
	 //post: nothing
	 public void sortByName()
	 {
		 for(int index = 1; index < count; index++)
		 {
			 int k = index;
			 while (k > 0)
			 {
				 if(this.list[k].compareByName(this.list[k-1]) < 0)
				 {
					 String temp = list[k].getName();
					 list[k].setName(list[k-1].getName());
					 list[k-1].setName(temp);
					 k--;
				 }
				 else
				 {
					 k = 0;
				 }
			 }//end of while
		 }//end of for
	 }
	 
	 public boolean add(HousePet housepet)
	 {
		 if(this.count >= HousePetList.MAX_SIZE)
		 {
			 return false;
		 }
		 if(this.contains(housepet))
		 {
			 return false;
		 }
		 this.list[this.count] = housepet;
		 this.count++;
		 this.sortByChipIdentifier();
		 this.saved = false;
		 return true;
	 }
	 
	 private int binSearch(HousePet housepet)
	 {
		 int low=0, high=count-1, mid;
		 while ( low <= high)
		 {
		   mid = (low + high ) / 2;
		   int result = list[mid].compareTo(housepet);
		   if (result == 0) 
		      return mid;   // found it at mid point
		   else if (result > 0) // shrink list to low:mid-1
		      high=mid-1;
		   else // shrink list to mid+1:high
		      low = mid + 1;
		 } // end of while
		 return -1;  // not found ever so send back invalid index
	 }
	 
	 public boolean contains(HousePet housepet)
	 {
		 int index = binSearch(housepet);
		 boolean retValue = true;
		 if(index < 0)
		 {
			 retValue = false; 
		 }
		 return retValue;
	 }
	 
	  public HousePet remove(HousePet housepet)
	  {
		  int location = binSearch(housepet);
		  if(location == -1)
		  {
			  return null;
		  }
		  else
		  {
			  HousePet pet = this.list[location];
			  for(int i = location; i < count-1; i++)
			  {
				  this.list[i] = this.list[i+1];
			  }
			  count--;
			  this.saved = false;
			  return pet;
		  }

	  }
	  
	  public void removeAll()
	  {
		  this.count = 0;
		  this.saved = false;
		  return;
	  }
	  
	  public int size()
	  {
		int retValue = this.count;
		return retValue;
	  }

	  public String getHousePetsByName(String housePetName) 
	  {
		  HousePet temp = new HousePet();
		  temp.setName(housePetName);
		  String sameNamesList = "";
		  int tempResult = 0;
		  for(int i = 0; i < this.count; i++)
		  {
			  tempResult = this.list[i].getName().compareTo(housePetName);
			  if(tempResult == 0)
			  {
				  sameNamesList += this.list[i].toString();
			  }
		  }
		  return sameNamesList;
	  }
	  
	  public boolean  modifyAge(int theChipIdNumber, double newAge)
	  {
		  HousePet findPet = new HousePet();
		  findPet.setChipId(theChipIdNumber);
		  int check = binSearch(findPet);
		  if(check == -1)
		  {
			  return false;
		  }
		  else
		  {
			  this.list[check].setAge(newAge);
			  this.saved = false;
			  return true;
		  }
	  }
	  
	  public boolean saveToFile(String filename)
	  {
	      // open a print writer using given filename (requires a try/catch block
		PrintWriter outFile = null;
		try
		{
		outFile = new PrintWriter(new File(filename));
		for(int i = 0; i < this.count; i++)
			{
				this.list[i].writeToFile(outFile);
			}
		outFile.close();
		this.saved = true;
		return true;
		} 
		catch (FileNotFoundException e)
		    {
			this.saved = false;
			return false;
		    }
	  }
		  
	  public boolean isSaved()
	  {
		return this.saved;
	  }

	public boolean addVetVisit(int chipID, VetVisit visit) 
	{
		HousePet temp = new HousePet();
		temp.setChipId(chipID);
		int location = this.binSearch(temp);
		if(location == -1)
		{
			return false;
		}
		else
		{
			VetVisitList aList = this.list[location].getList();
			boolean result = aList.add(visit);
			this.saved = false;
			count++;
			return result;
		}
	}


	public VetVisit removeVetVisit(int chipId, VetVisit visit)
	{
		HousePet removePet = new HousePet();
		removePet.setChipId(chipId);
		int location = this.binSearch(removePet);
		if(location == -1)
		{
			return null;
		}
		else
		{
			VetVisitList aList = this.list[location].getList();
			VetVisit result = aList.remove(visit);
			if(result == null)
			{
				this.saved = true;
				return null;
			}
			else
			{
				PrintWriter out = null;
				try
				{
						out = new PrintWriter(new FileWriter("cancel.txt", true));
				}
				catch(IOException e)
				{
					this.saved = true;
					return null;
				}
				this.saved = false;
				count--;
				return visit;
			}
		}
	}
	 
}// end of class
