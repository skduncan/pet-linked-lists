package lab6;

public class VetVisitStandard extends VetVisit
{
	private String vaccines;
	private int cityLicense;
	private String otherCare;
	
	public VetVisitStandard()
	{
		super();
		this.setVaccines("**empty**");
		this.setCityLicense(0);
		this.setOtherCare("**empty**");
	}
	
	public VetVisitStandard(String theVisitId, String theDate, String theDoctor, String theLocation, String theVaccines, int theCityLicense, String theOtherCare)
	{
		super(theDate, theDoctor, theLocation);
		this.setVaccines(theVaccines);
		this.setCityLicense(theCityLicense);
		this.setOtherCare(theOtherCare);
	}
	
	public String getVaccines()
	{
		return this.vaccines;
	}
	
	public int getCityLicense()
	{
		return this.cityLicense;
	}
	
	public String getOtherCare()
	{
		return this.otherCare;
	}
	
	public void setVaccines(String theVaccines)
	{
		if(theVaccines.length() == 0)
		{
			this.vaccines = "**empty**";
		}
		else
		{
			this.vaccines = theVaccines;
		}
	}
	
	public void setCityLicense(int theCityLicense)
	{
		if(theCityLicense < 0)
		{
			this.cityLicense = 0;
		}
		else
		{
			this.cityLicense = theCityLicense;
		}
	}
	
	public void setOtherCare(String theOtherCare)
	{
		if(theOtherCare.length() == 0)
		{
			this.otherCare = "**empty**";
		}
		else
		{
			this.otherCare = theOtherCare;
		}
	}
	
	public String toString()
	{
		String temp = " ";
		temp = super.toString() + " " + this.vaccines + " " + this.cityLicense + " " + this.otherCare;
		return temp;
	}
}
