package captchaGenerator;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStringGen {
	public String s;
	public String AlphanumericStringGen() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
							  "abcdefghijklmnopqrstuvwxyz" +
							  "1234567890"; // fix and use string builder later
		StringBuilder sBuild = new StringBuilder(); 
		while (sBuild.length() < 5) {
			int index = ThreadLocalRandom.current().nextInt(allowedChars.length());
			sBuild.append(allowedChars.charAt(index));
		}
		s = sBuild.toString();
		return s;
	}
	
	public String getS(){
		return s;
	}
	

}
