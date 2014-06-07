package DesignPattern.ProxyPattern2;

public class ProxyImage implements Image {

	private RealImage image = null;
	private String filename = null;
	
	public ProxyImage(final String filename){
		this.filename = filename;
	}
	
		
	@Override
	public void displayImage() {
		System.out.println("------------------------------");
		if(image == null){
			image = new RealImage(filename);
		}
		image.displayImage();
	}

}
