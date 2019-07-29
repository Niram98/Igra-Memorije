import javax.swing.JButton;

public class MemorijaButton extends JButton {

	int i, j;
	
	public MemorijaButton(int i, int j) {
		this.i = i;
		this.j = j;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @return the j
	 */
	public int getJ() {
		return j;
	}
	
}
