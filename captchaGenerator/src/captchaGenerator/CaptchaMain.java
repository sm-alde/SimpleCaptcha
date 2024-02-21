package captchaGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class  CaptchaMain {
	
	public String captchaName;
	public Config config;
	public RandomStringGen randomStringGen;
	
	public Config getConfig(Config config) {
		return config;
	}
	
	public void setConfig(Config config) {
		this.config = config;
	}
	
	 public void setRandomStringGen(RandomStringGen randomStringGen) {
	        this.randomStringGen = randomStringGen;
	}

	public CaptchaMain() {
	        this.setConfig(new Config());
	}

	public CaptchaMain(Config config) {
	        this.setConfig(config);
	}
	public String getCaptchaName() {
		return captchaName;
	}
	
	
	// separation //
	
	public CaptchaImage generate() {
		RandomStringGen gen = new RandomStringGen();
		captchaName = gen.AlphanumericStringGen();
		
		BufferedImage image = new BufferedImage(config.getWidth(), config.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		
		drawCaptcha(graphics, captchaName);
		drawNoise(graphics);
	
		
		return new CaptchaImage(image,captchaName);
		
	}
	    
	
	
	// CAPTCHA IMAGE GENERATION AND NOISE GENERATION //
	
	private void drawCaptcha(Graphics g, String s) {
		g.setColor(Color.WHITE);
        g.fillRect(0, 0, config.getWidth(), config.getHeight());
        
        int charGap = (config.getWidth()/ s.length());
        
        Random random = new Random();
        

        for (int i = 0; i < s.length(); i++) {
        	int fontSize = 40;
            Font font = new Font("Arial", Font.PLAIN, fontSize);
            g.setFont(font);
        	
            g.setColor(Color.BLACK);

            int charX = i* charGap + charGap / 2; // consider omitting
            int angle = random.nextInt(41) - 20;

            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(Math.toRadians(angle), charX, config.getHeight()/2);
            
           
            g.drawString(String.valueOf(s.charAt(i)), charX, config.getHeight()/2);
            g2d.rotate(-Math.toRadians(angle), charX, config.getHeight()/2);   
        }
        
	}
	
	
	// noise
	public void drawNoise(Graphics g) {
		Random random = new Random();
        for (int i = 0; i < config.getNoisevalue(); i++) {
            int x1 = random.nextInt(config.getWidth());
            int y1 = random.nextInt(config.getHeight());
            int x2 = x1 + random.nextInt(50) - 25;
            int y2 = y1 + random.nextInt(50) - 25;
            g.setColor(Color.GRAY);
            g.drawLine(x1, y1, x2, y2);
        }
	}
}