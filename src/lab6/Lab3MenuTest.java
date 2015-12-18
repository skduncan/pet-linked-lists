package lab6;

/**
 * @author sduncan
 *
 */

// Modification history:
// Created Lab3MenuTest (02/05/2014)
// added methods menuAdd, menuRemove, menuRemoveAll, menuSize, getChoice, displayMenu, and menuQuit methods. (02/07/2014)
// added methods menuPopulate, menuView, and menuPetCheck. (02/08/2014).
// modified all methods except main, menuChoice, getChoice, and displayMenu. (02/11/2014)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab3MenuTest
{
	public static void main (String args[])
	{
		HousePetList myList = new HousePetListImpl();
		char choice = ' ';
		do
			{
			System.out.println("Please enter one of the following options.");
			displayMenu();
			choice = getChoice();
			switch(choice)
				{
				case 'a':  menuPopulate(myList);
							break;
				case 'b':	menuAdd(myList);
							break;
				case 'c':	menuRemove(myList);
							break;
				case 'd':	menuRemoveAll(myList);
							break;
				case 'e':	menuView(myList);
							break;
				case 'f':	menuPetCheck(myList);
							break;
				case 'g':	menuSize(myList);
							break;
				case 'h':	menuFindByName(myList);
							break;
				case 'i':	menuModifyAge(myList);
							break;
				case 'j':	menuSave(myList);
							break;
				case 'k':	menuVisitAdd(myList);
							break;
				case 'l':	menuVisitRemove(myList);
							break;
				case 'q':	menuQuit(myList);
							break;
				} //end of switch
			} //end of do
			while(choice != 'q');
	} //end of main
	
	public static void displayMenu()
	{	
		System.out.println("a. Populate the list.");
		System.out.println("b. Add a housepet to the list.");
		System.out.println("c. Remove a housepet from the list.");
		System.out.println("d. Remove all housepets from the list.");
		System.out.println("e. View housepets.");
		System.out.println("f. Check account.");
		System.out.println("g. Check size of list.");
		System.out.println("h. Find housepets by a specific name.");
		System.out.println("i. Modify the age of a housepet.");
		System.out.println("j. Save the current list.");
		System.out.println("k. Add a vet visit for a housepet.");
		System.out.println("l. remove a vet visit for a house pet.");
		System.out.println(" ");
		System.out.println("q. Quit");
	}
	
	public static void menuPopulate(HousePetList myList)
	{
		Scanner inputSource = new Scanner(System.in);
		System.out.println("Please enter a file name.");
		
		String filename = inputSource.nextLine();
		File inFile = new File(filename);
		if (!inFile.exists()) // file does not exist
			{
				System.out.println("File " + filename + " does not exist.");
			}
		else // file opened
			{
			try{
			Scanner fscan = new Scanner(inFile);
			System.out.println("Opened file " + filename);
			myList.readFromScanner(fscan);
			fscan.close(); //file closed
			System.out.println("Populated the list.");
			}catch(FileNotFoundException e)
			{
				System.out.println("Cannot open file " + filename);
			}
			}
		
		return;
	}
	
	public static void menuAdd(HousePetList myList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the information of the new pet.");
		
		System.out.println("The Chip Identifier: ");
		int chipID = input.nextInt();
		System.out.println("The Name: ");
		String name = input.next();
		System.out.println("The Type: ");
		String type = input.next();
		System.out.println("The Age: ");
		double age = input.nextDouble();
		
		HousePet housepet = new HousePet();
		housepet.setChipId(chipID);
		housepet.setName(name);
		housepet.setPetType(type);
		housepet.setAge(age);
		
		boolean result = myList.add(housepet);
		if (result = true)
		{
			System.out.println("Successfully added: " + housepet +  " to the list.");
		}
		else
		{
			System.out.println("Unable to add: " + housepet + " to list.");
		}
		return;
	} //end of menuAddhousepet
	
	public static void menuRemove(HousePetList myList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the information of the pet to be removed.");
		
		System.out.println("The Chip Identifier: ");
		int chipID = input.nextInt();
		System.out.println("The Name: ");
		String name = input.next();
		System.out.println("The Type: ");
		String type = input.next();
		System.out.println("The Age: ");
		double age = input.nextDouble();
		
		HousePet housepet = new HousePet();
		housepet.setChipId(chipID);
		housepet.setName(name);
		housepet.setPetType(type);
		housepet.setAge(age);
		
		HousePet pet = myList.remove(housepet);
		if(pet == null)
		{
			System.out.println("Housepet could not be removed or did not exist.");
		}
		else
		{
			System.out.println("Removed the housepet from the list.");
		}
		
		return;
	} //end of menuRemove
	
	public static void menuRemoveAll(HousePetList myList)
	{
		myList.removeAll();
		System.out.println("");
		System.out.println("Removed all housepets from the list.");
		System.out.println("");
		return;
	} //end of menuRemoveAll
	
	public static void menuView(HousePetList myList)
	{
		System.out.println("");
		System.out.println("The current list is:\n" + myList);
		System.out.println("");
		return;
	} //end of menuView
	
	public static void menuPetCheck(HousePetList myList)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the pet information");
		HousePet choicePet = new HousePet();
		choicePet.readFromScanner(input);
		boolean result = myList.contains(choicePet);
		if(result = true)
		{
			System.out.println("");
			System.out.println("This pet exists.");
			System.out.println("");
		}
		else
		{
			System.out.println("");
			System.out.println("This pet does not exist.");
			System.out.println("");
		}
	}
	
	public static void menuSize(HousePetList myList)
	{
		int size = myList.size();
		System.out.println("");
		System.out.println("This list contains: " + size + " housepet(s).");
		System.out.println("");
		return;
	}
	
	public static void menuQuit(HousePetList myList)
	{
		Scanner check = new Scanner(System.in);
		System.out.println("Now exiting the menu.");
		boolean save = myList.isSaved();
		if(save == false)
		{
			System.out.println("Your list is not saved. Do you want to save?");
			char answer = ' ';
			String answerString = "";
			answerString = check.nextLine();
			answer = answerString.charAt(0);
			while (answer != 'y' && answer != 'n')
			{
				System.out.println("Response not understood. Please try again. (Enter either y or n.)");
				answerString = check.nextLine();
				answer = answerString.charAt(0);
			}
			if (answer == 'y')
			{
				menuSave(myList);
				System.out.println("Thank you for using this menu.");
			}
			else
			{
				System.out.println("Your list is not saved.");
				System.out.println("Thank you for using this menu.");
			}
		}
		return;
	}
	
	public static void menuFindByName(HousePetList myList)
	{
		Scanner petName = new Scanner(System.in);
		System.out.println("Please enter the name of the pet.");
		String name = " ";
		String nameList = " ";
		name = petName.nextLine();
		nameList = myList.getHousePetsByName(name);
		System.out.println("Here are the housepets from the list with the name " + nameList);
	}
	
	public static void menuModifyAge(HousePetList myList)
	{
		Scanner pet = new Scanner(System.in);
		System.out.println("Please enter the Chip ID of the pet you wish to modify and its new age.");
		int chipIdentifier = 0;
		chipIdentifier = pet.nextInt();
		double newAge = 0.0;
		newAge = pet.nextDouble();
		while(newAge <= 0)
		{
			System.out.println("Your pet's age cannot be 0 or below. Please enter the new age.");
			newAge = pet.nextDouble();
		}
		boolean change = myList.modifyAge(chipIdentifier, newAge);
		if(change = true)
		{
			System.out.println("Your pet's age has been changed.");
			myList.isSaved();
		}
		else
		{
			System.out.println("The pet did not exist or the age could not be changed.");
		}
	}
	
	public static void menuSave(HousePetList myList)
	{
		Scanner fileName = new Scanner(System.in);
		System.out.println("Please give a filename to save to.");
		String filename = " ";
		filename = fileName.nextLine();
		boolean save = myList.saveToFile(filename);
		
		if(save = true)
		{
			System.out.println("List has been saved.");	
		}
		else
		{
			System.out.println("List has failed to save.");
		}
	}
	
	public static void menuVisitAdd(HousePetList myList)
	{
		Scanner details = new Scanner(System.in);
		System.out.println("Please enter a chip identifier:");
		int chipIdDetail = details.nextInt();
		details.nextLine();
		System.out.println("Enter S or U to indicate a Standard or Urgent visit.");
		String answer = details.nextLine();
//		while(answer != "S" || answer != "U")
//		{
//			System.out.println("S or U was not entered. Please enter S or U to indicate a Standard or Urgent visit.");
//			answer = details.nextLine();
//		}
		VetVisit visit = null;
		if(answer.equals("S"))
		{
			
			System.out.println("Please add in the details of the vist: the visit ID, the date, the doctor, the location, the vaccines, the city license, and the other care.");
			System.out.println("*NOTICE*: Only the city license is a number.");
			String theVisitId = details.nextLine();
			String theDate = details.nextLine();
			String theDoctor = details.nextLine();
			String theLocation = details.nextLine();
			String theVaccines = details.nextLine();
			int theCityLicense = details.nextInt();
			details.nextLine();
			String theOtherCare = details.nextLine();
			visit = new VetVisitStandard(theVisitId, theDate, theDoctor, theLocation, theVaccines, theCityLicense, theOtherCare);
		}
		else
		{
			System.out.println("Please add in the details of the vist: the visit ID, the date, the doctor, the location, the diagnosis, and the treatment.");
			String theVisitId = details.nextLine();
			String theDate = details.nextLine();
			String theDoctor = details.nextLine();
			String theLocation = details.nextLine();
			String theDiagnosis = details.nextLine();
			String theTreatment = details.nextLine();
			visit = new VetVisitUrgent(theVisitId, theDate, theDoctor, theLocation, theDiagnosis, theTreatment);
		}
		
		boolean result = myList.addVetVisit(chipIdDetail, visit);
		if(result = false)
		{
			System.out.println("There was no housepet found with that chip ID.");
		}
		else
		{
			System.out.println("The visit was successfully added to the list.");
			return;
		}
		
	}
	
	public static void menuVisitRemove(HousePetList myList)
	{
		Scanner details = new Scanner(System.in);
		System.out.println("Please enter a chip identifier:");
		int chipId = details.nextInt();
		System.out.println("Enter S or U to indicate a Standard or Urgent visit.");
		String answer = details.next();
//		while(answer != "S" || answer != "U")
//		{
//			System.out.println("S or U was not entered. Please enter S or U to indicate a Standard or Urgent visit.");
//			answer = details.nextLine();
//		}
		VetVisit visit = null;
		if(answer.equals("S"))
		{
			visit = new VetVisitStandard();
			System.out.println("Please add in the details of the vist to be removed: the visit ID and the Date.");
			String theVisitId = details.nextLine();
			details.nextLine();
			String theDate = details.nextLine();
			visit.setVisitId(theVisitId);
			visit.setDate(theDate);
		}
		else
		{
			visit = new VetVisitUrgent();
			System.out.println("Please add in the details of the vist to be removed: the visit ID and the Date.");
			String theVisitId = details.nextLine();
			details.nextLine();
			String theDate = details.nextLine();
			visit.setVisitId(theVisitId);
			visit.setDate(theDate);
		}
		
		VetVisit result = myList.removeVetVisit(chipId, visit);
		if(result == null)
		{
			System.out.println("There was no housepet found with that chip ID.");
		}
		else
		{
			System.out.println("The visit was successfully removed the list.");
		}
		
	}
	
	public static char getChoice()
	   {  
	      char choice;
	      String answer; // holds the user's selection
	      Scanner input = new Scanner (System.in);
	      
	     do {
	      System.out.print("Enter your selection: ");
	      answer = input.nextLine();
	      choice = Character.toLowerCase(answer.charAt(0));
	     } while ( choice !='a' && choice !='b' && choice !='c' && choice !='d' && choice !='e'
	    		 && choice != 'f' && choice != 'g' && choice != 'h' && choice != 'i' && choice != 'j' && choice != 'k' && choice != 'l' && choice != 'q'); 
	        // assuming a-j are good and k is quit.
	    return choice;
	   } //end of getChoice
} //end of class
