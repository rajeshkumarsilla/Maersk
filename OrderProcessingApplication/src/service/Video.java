package service;

public class Video extends NonPhysicalProduct
{
	private String videoName;
    public Video(String videoName)
    {
    	this.videoName = videoName;
    	super.generatePackingSlip();
    	validateVideoandAdd();
    }
	public void validateVideoandAdd() {
		if (this.videoName.equalsIgnoreCase("learning to ski"))
        {
			getOperations().add("First Aid video added to the packing slip");
        }
	}
}
