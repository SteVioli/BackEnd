
public class Video extends ElementoMultimediale implements Volume{
	 int luminosita;
	 int durata;
	 int volume;

	public Video(String titolo, int durata, int luminosita, int volume) {
		super(titolo);
		this.luminosita = luminosita;
		this.durata = durata;
		this.volume = volume;
	}
	
	//PLAY
	public void play() {
		for(int i=0;i<durata;i++) {
			String x = "";
			String y = "";
			for(int a= 0;a<volume;a++) {
				x += "!";
			}for(int b=0;b<luminosita;b++) {
				y += "*";
			}
			System.out.println(titolo + " " + x + " " + y);
		}
	}
	
	
	//GET AND SET
	public int getLuminosita(Video luminosita) {
		return luminosita.luminosita;
	}

	public void setLuminosita(Video luminosita) {
		this.luminosita = luminosita.luminosita;
	}

	public int getDurata() {
		return durata;
	}
	


	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getVolume(Video volume) {
		return volume.volume;
	}

	public void setVolume(int numero,Video video) {
		this.volume = numero;
		System.out.println("Volume di " + video.titolo + " settata a " + numero);
	}

	//interface methods
	
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
		if(volume <= 10) {
			volume--;
			System.out.println("Volume audio: " + volume);
		}else if(volume >=10) {
			volume=10;
			volume--;
			System.out.println("Volume audio: "+ volume );
		}else if(volume < 0) {
			volume = 0;
			System.out.println("Volume audio settato su muto: " + volume);
		}
		return volume;
	}

	@Override
	public String toString() {
		return "Video [luminosita=" + luminosita + ", durata=" + durata + ", volume=" + volume + ", titolo=" + titolo
				+ "]";
	}
	
	
	
}
