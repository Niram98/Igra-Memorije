
public class Polje {

	int vrednost;
	boolean vidljivost;
	
	
	public Polje(int vrednost, boolean vidljivost) {
		super();
		this.vrednost = vrednost;
		this.vidljivost = vidljivost;
	}
	
	/**
	 * @return the vrednost
	 */
	public int getVrednost() {
		return vrednost;
	}
	/**
	 * @param vrednost the vrednost to set
	 */
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	/**
	 * @return the vidljivost
	 */
	public boolean isVidljivost() {
		return vidljivost;
	}
	/**
	 * @param vidljivost the vidljivost to set
	 */
	public void setVidljivost(boolean vidljivost) {
		this.vidljivost = vidljivost;
	}
	
	
}
