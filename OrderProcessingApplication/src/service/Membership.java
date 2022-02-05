package service;

public class Membership extends NonPhysicalProduct
{
    public Membership(String membershipType)
    {
    	if(membershipType.equalsIgnoreCase("activate"))
    	{
    		getOperations().add("activate that membership");
    		sendEMail();
    	}
    	else if(membershipType.equalsIgnoreCase("upgrade"))
    	{
    		getOperations().add("apply the upgrade");
    		sendEMail();
    	}
    }
	public void sendEMail() {
		getOperations().add("email sent");
	}
}
