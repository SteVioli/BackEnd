
public class Audio extends ElementoMultimediale implements Volume{

	private int durata;
	private int volume;

	public Audio(String titolo, int durata,int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}
	
	//PLAY
	public void play() {
		for(int i=0;i<durata;i++) {
			String x = "";
			for(int a= 0;a<volume;a++) {
				x += "!";
			}
			System.out.println(titolo + x);
		}
	}

	@Override
	public String toString() {
		return "Audio [durata=" + durata + ", volume=" + volume + ", titolo=" + titolo + "]";
	}

	//GET AND SET
	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	@Override
	public int alzaVolume() {
		if(volume < 10) {
			volume++;
			System.out.println("Volume audio: " + volume);
		}else if(volume >=10) {
			volume = 10;
			System.out.println("Volume settato a "+ volume + " al massimo!!");
		}else if(volume < 0) {
			volume = 1;
			System.out.println("Volume audio: " + volume);
		}
		return volume;
	}

	@Override
	public int abbassaVolume() {
		if(volume <= 10 && volume >0) {
			volume--;
			System.out.println("Volume audio: " + volume);
		}else if(volume >=10) {
			volume=10;
			volume--;
			System.out.println("Volume audio: "+ volume );
		}else if(volume == 0) {
			System.out.println("Volume audio settato su muto: " + volume);
		}
		return volume;
	}

	
	
	
}
	

