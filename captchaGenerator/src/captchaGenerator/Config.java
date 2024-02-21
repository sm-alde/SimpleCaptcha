package captchaGenerator;

public  class Config {
	public int width = 200;
	public int height = 150;
	public int length = 5;
	public int noiseValue = 100;
	
	public Config() {
		
	}
	
	public Config(int width, int height, int length, int noiseValue){
		this.width = width;
		this.height = height;
		this.length = length;
		this.noiseValue = noiseValue;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getLength() {
		return length;
	}
	public int getNoisevalue() {
		return noiseValue;
	}
	public void setNoise(int noiseValue) {
		this.noiseValue = noiseValue;
	}
}