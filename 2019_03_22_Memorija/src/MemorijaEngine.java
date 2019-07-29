import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemorijaEngine 
{
	Polje polja[][] = new Polje[5][6];
	Polje prviPotez = null;
	Polje drugiPotez = null;
	
	int brojOtvorenih = 0; //broj otvorenih polja u n-tom pokusaju
	int brojPogodjenih = 0;
	int brojPokusaja = 0;
	
	public MemorijaEngine()
	{
		newGame();
	}
	
	
	public int getVrednostPolja(int i, int j)
	{
		if(polja[i][j].vidljivost)
			return polja[i][j].vrednost;
		return -1;
	}
	
	/**
	 * @return the brojOtvorenih
	 */
	public int getBrojOtvorenih() {
		return brojOtvorenih;
	}

	/**
	 * @return the brojPogodjenih
	 */
	public int getBrojPogodjenih() {
		return brojPogodjenih;
	}

	/**
	 * @return the brojPokusaja
	 */
	public int getBrojPokusaja() {
		return brojPokusaja;
	}

	private void odigrajPrviPotez(int i, int j)
	{
		polja[i][j].setVidljivost(true);
		prviPotez = polja[i][j];
		brojOtvorenih++;
	}
	
	void odograjPotez(int i, int j) 
	{
		if(polja[i][j].vidljivost)
			return;
		
		if(brojOtvorenih == 0)
		{
			odigrajPrviPotez(i, j);
			return;
		}
		
		if(brojOtvorenih == 1)
		{
			polja[i][j].setVidljivost(true);
			drugiPotez = polja[i][j];
			brojOtvorenih++;
			
			if(prviPotez.vrednost == drugiPotez.vrednost)
			{
				brojPogodjenih++;
			}
			brojPokusaja++;
					
			return;
		}
		
		if(brojOtvorenih == 2)
		{
			// zatvori prethodna ili ne
			if(prviPotez.vrednost == drugiPotez.vrednost )
			{
				prviPotez = null;
				drugiPotez = null;				
			}
			else
			{
				prviPotez.setVidljivost(false);
				drugiPotez.setVidljivost(false);
			}
			brojOtvorenih = 0;
			
			// sada za novi klik
			odigrajPrviPotez(i, j);
		}
	}
	
	
	public void newGame()
	{
		brojOtvorenih = 0;
		brojPogodjenih = 0;
		brojPokusaja = 0;
		
		
		// vrednosti 0 - 14
		// svaka vrednost po 2 polja
		// slucajan raspored
		List<Integer> vrednosti = new ArrayList<Integer>();
		for (int i = 0; i < 15; i++) 
		{
			vrednosti.add(i);
			vrednosti.add(i);
		}
		Random random = new Random();
		for (int i = 0; i < polja.length; i++) {
			for (int j = 0; j < polja[i].length; j++) 
			{
				int index = random.nextInt(vrednosti.size()); // 50
				polja[i][j] = new Polje(vrednosti.get(index), false);
				vrednosti.remove(index);
			}
		}
	}
	
	
	void stampajMatricu()
	{
		
		for (int i = 0; i < polja.length; i++) {
			String s = "";
			for (int j = 0; j < polja[i].length; j++) 
			{
				s += " " + getVrednostPolja(i, j) + " ";
			}
			System.out.println(s);
		}
	}
}
