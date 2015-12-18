package lab6;


public class VetVisitUrgent extends VetVisit
{
	private String diagnosis;
	private String treatment;
	
	public VetVisitUrgent()
	{
		super();
		this.setDiagnosis("**no diagnosis**");
		this.setTreatment("**no treatment**");
	}
	
	public VetVisitUrgent(String theVisitId, String theDate, String theDoctor, String theLocation, String theDiagnosis, String theTreatment)
	{
		super(theDate, theDoctor, theLocation);
		this.setDiagnosis(theDiagnosis);
		this.setTreatment(theTreatment);
	}
	
	public String getDiagnosis()
	{
		return this.diagnosis;
	}
	
	public String getTreatment()
	{
		return this.treatment;
	}
	
	public void setDiagnosis(String theDiagnosis)
	{
		if(theDiagnosis.length() == 0)
		{
			this.diagnosis = "**no diagnosis**";
		}
		else
		{
			this.diagnosis = theDiagnosis;
		}
	}
	
	public void setTreatment(String theTreatment)
	{
		if(theTreatment.length() == 0)
		{
			this.treatment = "**no treatment**";
		}
		else
		{
			this.treatment = theTreatment;
		}
	}
	
	public String toString()
	{
		String temp = " ";
		temp = super.toString() + " " + this.diagnosis + " " + this.treatment;
		return temp;
	}
}//end of class
