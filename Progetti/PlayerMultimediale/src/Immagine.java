
public class Immagine extends ElementoMultimediale implements Luminosità {

	int luminosità;

	public Immagine(String titolo, int luminosità) {
		super(titolo);
		this.luminosità = luminosità;
	}

	public int getLuminosità() {
		return luminosità;
	}

	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
	}
	public void show() {
		
			String x = "";
			for(int a= 0;a<luminosità;a++) {
				x += "*";
			}
			System.out.println(titolo + " immagine con : "+ x);
		
	}

	@Override
	public String toString() {
		return "Immagine [luminosità=" + luminosità + ", titolo=" + titolo + "]";
	}
	
}
