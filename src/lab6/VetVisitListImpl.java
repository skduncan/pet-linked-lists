package lab6;

import java.io.PrintWriter;
import java.util.*;

public class VetVisitListImpl implements VetVisitList
{
	private int count;
	private node<VetVisit> first;
	
	public VetVisitListImpl()
	{
		this.first = null;
		this.count = 0;
	} //end of VetvisitListImpl method
	
	public String toString()
	{
		String temp = "";
		if(this.count == 0)
		{
			temp = "**Empty List**";
			return temp;
		}
		for(node<VetVisit>node1 = this.first; node1 != null; node1 = node1.link)
		{
			temp += node1.data + "\n";
		}
		return temp;
	} //end of toString

	public int size() 
	{	
		return this.count;
	} //end of size

	public boolean contains(VetVisit visit) 
	{
		node <VetVisit> current = this.first;
		while (current != null)
		{
			if (current.data.compareTo(visit) == 0)
			{
				return true;
			}
			current = current.link;
		}
		return false;
	} //end of contains

	public boolean add(VetVisit visit) 
	{
		if(this.contains(visit))
		{
			return false;
		}
		
		node <VetVisit> previous = null;
		node <VetVisit> current = this.first;
		while (current != null)
		{
			if(current.data.compareTo(visit) < 0)
			{
				break;
			}
			previous = current;
			current = current.link;
		}//end of while
		
		node <VetVisit> visitData = new node <VetVisit>();
		visitData.data = visit;
		if(previous == null)  //if having problems with code, CHECK HERE
		{
			visitData.link = this.first;
			this.first = visitData;
		}
		else
		{
			visitData.link = previous.link;
			previous.link = visitData;
		}
		this.count++;	
		return true;
	} //end of add

	public VetVisit remove(VetVisit visit) 
	{
		node <VetVisit> previous = null;
		node <VetVisit> current = this.first;
		while (current != null)
		{
			if (current.data.compareTo(visit) == 0)
			{
				break;
			}
			previous = current;
			current = current.link;
		} //end of while
		
		if (current == null)
		{
			return null;
		}
		if (previous == null) //disconnect at first
		{
			this.first = this.first.link;
		}
		else
		{
			previous.link = current.link;
		}
		this.count--;
		return current.data;
	} //end of remove

	public void removeAll() 
	{
		this.first = null;
		this.count = 0;
	} //end of removeAll

	public String getVetVisitListByDate(GregorianCalendar date) 
	{
		String sameDates = "";
		node <VetVisit> node = this.first;
		while (node != null)
		{
			if(node.data.getDateCalendar().compareTo(date) == 0)
			{
				sameDates += node.data + "\n";
			}
			node = node.link;
		}
		return sameDates;
	}
	
	//pre:  out is opened and ready to write to
	//post: this list is written to out in 'readable' format  so output is same form as input file's visit list format
	public void writeToFile(PrintWriter out) {
			node <VetVisit> node= this.first;
			while(node != null)
			{
				out.println(node.data.getDateString() + " " + node.data.getDoctor()+ "  " + node.data.getLocation());
				if(node.data instanceof VetVisitUrgent)
				{
					VetVisitUrgent visit = (VetVisitUrgent) node.data;
					out.println(visit.getDiagnosis());
					out.println(visit.getTreatment());
				}
				else
				{
					VetVisitStandard visit = (VetVisitStandard)node.data;
					out.println(visit.getVaccines());
					out.println(visit.getCityLicense() + "  " + visit.getOtherCare());
				}
				node = node.link;
			}//end while
			out.println("****");
		}  
	// note you will have to call the method above (writeToFile) inside the writeToFile for each HousePet.  Call the method
	// using the HousePet's visit list instance after you output the id, name, pet type and age.  
	//	    ie:  this.visitList.writeToFile(out);  

}
