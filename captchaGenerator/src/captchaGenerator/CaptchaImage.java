package captchaGenerator;
import java.awt.image.BufferedImage;


public class CaptchaImage {
	public String s;
	public BufferedImage image;
	
	public CaptchaImage(BufferedImage image, String s) {
		this.image = image;
		this.s = s;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public String getS() {
		return s;
	}
}