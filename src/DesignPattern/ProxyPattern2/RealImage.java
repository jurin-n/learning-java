package DesignPattern.ProxyPattern2;

public class RealImage implements Image {

	private String filename = null;
	
	public RealImage(final String filename){
		this.filename = filename;
		loadImageFromDisk();
	}
	
	private void loadImageFromDisk(){
		System.out.println("Loading " + filename + " from Disk.");
	}
	
	@Override
	public void displayImage() {
		System.out.println("Displaying " + filename);
	}
}
