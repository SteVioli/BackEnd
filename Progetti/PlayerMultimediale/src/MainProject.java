import java.util.Scanner;

public class MainProject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Progetto Elemento Multimediale
		Audio a1 = new Audio("Audio Prova", 4,3);
		Audio a2 = new Audio("Audio Prova", 4,3);
		Video v1 = new Video("Video Prova", 4, 5, 3);
		Video v2 = new Video("Video Prova", 4, 5, 3);
		Immagine i1 = new Immagine("Immagine Prova", 2);
	
		a1.abbassaVolume();
		a1.abbassaVolume();
		a2.play();
		a1.play();
		v1.alzaVolume();
		v1.abbassaVolume();
		v1.play();
		v1.setVolume(6,v1);
		System.out.println(v1.getVolume(v1));
		v1.abbassaVolume();
		System.out.println(v1.getVolume(v1));
		
		i1.show();
		
		
		
		
		ElementoMultimediale[] mieiElementi = new ElementoMultimediale[5];
		
		while(true) {
			System.out.println("Scegli che operazione effettuare : crea - esegui - esci");
			String a = sc.nextLine();
			switch (a) {
			case "crea": {
				for(int i = 0; i< mieiElementi.length ; i++ ) {
					if(mieiElementi[i] == null) {
						System.out.println("Cosa vuoi creare? video - audio - immagine // esci");
						String aa1 = sc.nextLine();
						switch (aa1) {
						case "video": {
							System.out.println("titolo video");
							String titoloVideo = sc.nextLine();
							System.out.println("durata video");
							int durataVideo = Integer.parseInt(sc.nextLine());
							System.out.println("luminosità video");
							int lumVideo = Integer.parseInt(sc.nextLine());
							System.out.println("volume video");
							int volVideo = Integer.parseInt(sc.nextLine());
							mieiElementi[i] = new Video(titoloVideo, durataVideo, lumVideo, volVideo);
							break;
						}case "audio": {
							System.out.println("titolo audio");
							String titoloAudio = sc.nextLine();
							System.out.println("durata video");
							int durataAudio = Integer.parseInt(sc.nextLine());
							System.out.println("volume video");
							int volAudio = Integer.parseInt(sc.nextLine());
							mieiElementi[i] = new Audio(titoloAudio, durataAudio, volAudio);
							break;
						}
						case "immagine": {
							System.out.println("titolo immagine");
							String titoloImmagine = sc.nextLine();
							System.out.println("luminosità immagine");
							int volImmagine = Integer.parseInt(sc.nextLine());
							mieiElementi[i] = new Immagine(titoloImmagine, volImmagine);
							break;
						}
						default:
							System.out.println("errore comando non valido");
							break;
						}
					}
				}
				break;
			}case "esegui":{
					boolean wh = true;
					while(wh) {
					System.out.println("Quale traccia vuoi eseguire? 1-5 // 0 per uscire");
					String es = sc.nextLine();
					switch (es) {
					case "1": {
							if(mieiElementi[0] instanceof Video) {
								((Video) mieiElementi[0]).play();
							}else if(mieiElementi[0] instanceof Audio) {
								((Audio) mieiElementi[0]).play();
							}else if(mieiElementi[0] instanceof Immagine) {
								((Immagine) mieiElementi[0]).show();
							}
						break;
					}
					case "2": {
						if(mieiElementi[1] instanceof Video) {
							((Video) mieiElementi[1]).play();
						}else if(mieiElementi[1] instanceof Audio) {
							((Audio) mieiElementi[1]).play();
						}else if(mieiElementi[1] instanceof Immagine) {
							((Immagine) mieiElementi[1]).show();
						}
					break;
					}case "3": {
						if(mieiElementi[2] instanceof Video) {
							((Video) mieiElementi[2]).play();
						}else if(mieiElementi[2] instanceof Audio) {
							((Audio) mieiElementi[2]).play();
						}else if(mieiElementi[2] instanceof Immagine) {
							((Immagine) mieiElementi[2]).show();
						}
					break;
					}case "4": {
						if(mieiElementi[3] instanceof Video) {
							((Video) mieiElementi[3]).play();
						}else if(mieiElementi[3] instanceof Audio) {
							((Audio) mieiElementi[3]).play();
						}else if(mieiElementi[3] instanceof Immagine) {
							((Immagine) mieiElementi[3]).show();
						}
					break;
					}case "5": {
						if(mieiElementi[4] instanceof Video) {
							((Video) mieiElementi[4]).play();
						}else if(mieiElementi[4] instanceof Audio) {
							((Audio) mieiElementi[4]).play();
						}else if(mieiElementi[4] instanceof Immagine) {
							((Immagine) mieiElementi[4]).show();
						}
					break;
					}case "0":{
						System.out.println("Sei tornato al menu principale");
						wh = false;
						break;
					}
						
					default:
						System.out.println("errore comando non valido");
						break;
					}
					
				}
					break;
			}
				
			case "esci":{
				System.out.println("Uscito dall'app");
				return;
			}
			default:
				break;
			}
		}
	}
	}

		
		
		
		
		
		
		
		
/*TEST DI PROVA (PROTOTIPO, VOLEVO IMPLEMENTARE LO SWITCH CASE DI SOPRA PER I VARI CASI MA IL TEMPO NON E' SUFFICIENTE)
 * while(true) {
	System.out.println("Vuoi creare un programma? si/no ");
	String crea = sc.nextLine();
	switch(crea) {
	case "si":{
	
	
System.out.println("Ciao! Hai 5 slot di memoria disponibili! ");
System.out.println("Seleziona da 1 a 5 quale slot occupare per la tua creazione, digita 0 per uscire dal programma");
String r = sc.nextLine();
switch(r) {
case "1":{
	System.out.println("Slot 1 selezionato");
	System.out.println("1-Crea un video // 2-crea un audio // 3-crea un'immagine // 0-esci");
	String r1 = sc.nextLine();
	switch(r1) {
	case "1":{
		Video video1 = new Video(null, 0, 0, 0);
		System.out.println("Dai un titolo al tuo video");
		String titVid1 = sc.nextLine();
		video1.setTitolo(titVid1);
		System.out.println("Digita la durata del tuo video");
		int durVid1 = Integer.parseInt(sc.nextLine());
		video1.setDurata(durVid1);
		System.out.println("Luminosità impostata di base a 3");
		video1.luminosita = 3;
		System.out.println("Volume impostato di base a 4");
		video1.volume =4;
		mieiElementi[0] = video1;
		System.out.println(video1);
		System.out.println("Le impostazioni sono ok?");
		System.out.println("Vuoi creare un programma? si/no ");
		String set = sc.nextLine();
		
		}
		break;
		
	case "2":{
		Audio audio1 = new Audio(null, 0, 0);
		System.out.println("Dai un titolo al tuo audio");
		String titAud1 = sc.nextLine();
		audio1.setTitolo(titAud1);
		System.out.println("Digita la durata del tuo audio");
		int durVid1 = Integer.parseInt(sc.nextLine());
		audio1.setDurata(durVid1);
		System.out.println("Volume impostato di base su muto");
		mieiElementi[0] = audio1;
		System.out.println(audio1);
		break;
		}
	case "3":{
		Immagine img1 = new Immagine(null, 0);
		System.out.println("Dai un titolo alla tua immagine");
		String tidImg1 = sc.nextLine();
		img1.luminosità = 3;
		System.out.println("Luminosità settata di base a 3");
		mieiElementi[0] = img1;
		System.out.println(img1);
		break;
		}
	case "0":{
		System.out.println("Uscito dal programma");
		return;
	}
	}break;
	
}		case "2":{
	System.out.println("Slot 2 selezionato");
	System.out.println("1-Crea un video // 2-crea un audio // 3-crea un'immagine //0-esci");
	String r1 = sc.nextLine();
	switch(r1) {
	case "1":{
		Video video2 = new Video(null, 0, 0, 0);
		System.out.println("Dai un titolo al tuo video");
		String titVid1 = sc.nextLine();
		video2.setTitolo(titVid1);
		System.out.println("Digita la durata del tuo video");
		int durVid1 = Integer.parseInt(sc.nextLine());
		video2.setDurata(durVid1);
		System.out.println("Luminosità impostata di base a 3");
		video2.luminosita = 3;
		System.out.println("Volume impostato di base a 4");
		video2.volume =4;
		mieiElementi[1] = video2;
		System.out.println(video2);
		break;
		}
	case "2":{
		Audio audio2 = new Audio(null, 0, 0);
		System.out.println("Dai un titolo al tuo audio");
		String titAud1 = sc.nextLine();
		audio2.setTitolo(titAud1);
		System.out.println("Digita la durata del tuo audio");
		int durVid1 = Integer.parseInt(sc.nextLine());
		audio2.setDurata(durVid1);
		System.out.println("Volume impostato di base su muto");
		mieiElementi[1] = audio2;
		System.out.println(audio2);
		break;
		}
	case "3":{
		Immagine img2 = new Immagine(null, 0);
		System.out.println("Dai un titolo alla tua immagine");
		String tidImg1 = sc.nextLine();
		img2.luminosità = 3;
		System.out.println("Luminosità settata di base a 3");
		mieiElementi[1] = img2;
		System.out.println(img2);
		break;
		}
	case "0":{
		System.out.println("Uscito dal programma");
		return;
	}
	}break;
	
}
case "3":{
	System.out.println("Slot 3 selezionato");
	System.out.println("1-Crea un video // 2-crea un audio // 3-crea un'immagine // 0-esci");
	String r1 = sc.nextLine();
	switch(r1) {
	case "1":{
		Video video3 = new Video(null, 0, 0, 0);
		System.out.println("Dai un titolo al tuo video");
		String titVid1 = sc.nextLine();
		video3.setTitolo(titVid1);
		System.out.println("Digita la durata del tuo video");
		int durVid1 = Integer.parseInt(sc.nextLine());
		video3.setDurata(durVid1);
		System.out.println("Luminosità impostata di base a 3");
		video3.luminosita = 3;
		System.out.println("Volume impostato di base a 4");
		video3.volume =4;
		mieiElementi[2] = video3;
		System.out.println(video3);
		
		break;
		}
	case "2":{
		Audio audio3 = new Audio(null, 0, 0);
		System.out.println("Dai un titolo al tuo audio");
		String titAud1 = sc.nextLine();
		audio3.setTitolo(titAud1);
		System.out.println("Digita la durata del tuo audio");
		int durVid1 = Integer.parseInt(sc.nextLine());
		audio3.setDurata(durVid1);
		System.out.println("Volume impostato di base su muto");
		mieiElementi[2] = audio3;
		System.out.println(audio3);
		break;
		}
	case "3":{
		Immagine img3 = new Immagine(null, 0);
		System.out.println("Dai un titolo alla tua immagine");
		String tidImg1 = sc.nextLine();
		img3.luminosità = 3;
		System.out.println("Luminosità settata di base a 3");
		mieiElementi[2] = img3;
		System.out.println(img3);
		break;
		}
	case "0":{
		System.out.println("Uscito dal programma");
		return;
	}
	}break;
	
}		case "4":{
	System.out.println("Slot 4 selezionato");
	System.out.println("1-Crea un video // 2-crea un audio // 3-crea un'immagine // 0-esci");
	String r1 = sc.nextLine();
	switch(r1) {
	case "1":{
		Video video4 = new Video(null, 0, 0, 0);
		System.out.println("Dai un titolo al tuo video");
		String titVid1 = sc.nextLine();
		video4.setTitolo(titVid1);
		System.out.println("Digita la durata del tuo video");
		int durVid1 = Integer.parseInt(sc.nextLine());
		video4.setDurata(durVid1);
		System.out.println("Luminosità impostata di base a 3");
		video4.luminosita = 3;
		System.out.println("Volume impostato di base a 4");
		video4.volume =4;
		mieiElementi[3] = video4;
		System.out.println(video4);
		break;
		}
	case "2":{
		Audio audio4 = new Audio(null, 0, 0);
		System.out.println("Dai un titolo al tuo audio");
		String titAud1 = sc.nextLine();
		audio4.setTitolo(titAud1);
		System.out.println("Digita la durata del tuo audio");
		int durVid1 = Integer.parseInt(sc.nextLine());
		audio4.setDurata(durVid1);
		System.out.println("Volume impostato di base su muto");
		mieiElementi[3] = audio4;
		System.out.println(audio4);
		
		break;
		}
	case "3":{
		Immagine img4 = new Immagine(null, 0);
		System.out.println("Dai un titolo alla tua immagine");
		String tidImg1 = sc.nextLine();
		img4.luminosità = 3;
		System.out.println("Luminosità settata di base a 3");
		mieiElementi[3] = img4;
		System.out.println(img4);
		break;
		}
	case "0":{
		System.out.println("Uscito dal programma");
		return;
		}
	}break;
	
}
case "5":{
	System.out.println("Slot 5 selezionato");
	System.out.println("1-Crea un video // 2-crea un audio // 3-crea un'immagine // 0-esci");
	String r1 = sc.nextLine();
	switch(r1) {
	case "1":{
		Video video5 = new Video(null, 0, 0, 0);
		System.out.println("Dai un titolo al tuo video");
		String titVid1 = sc.nextLine();
		video5.setTitolo(titVid1);
		System.out.println("Digita la durata del tuo video");
		int durVid1 = Integer.parseInt(sc.nextLine());
		video5.setDurata(durVid1);
		System.out.println("Luminosità impostata di base a 3");
		video5.luminosita = 3;
		System.out.println("Volume impostato di base a 4");
		video5.volume =4;
		mieiElementi[4] = video5;
		System.out.println(video5);
		break;
		}
	case "2":{
		Audio audio5 = new Audio(null, 0, 0);
		System.out.println("Dai un titolo al tuo audio");
		String titAud1 = sc.nextLine();
		audio5.setTitolo(titAud1);
		System.out.println("Digita la durata del tuo audio");
		int durVid1 = Integer.parseInt(sc.nextLine());
		audio5.setDurata(durVid1);
		System.out.println("Volume impostato di base su muto");
		mieiElementi[4] = audio5;
		System.out.println(audio5);
		break;
		}
	case "3":{
		Immagine img5 = new Immagine(null, 0);
		System.out.println("Dai un titolo alla tua immagine");
		String tidImg5 = sc.nextLine();
		img5.luminosità = 3;
		System.out.println("Luminosità settata di base a 3");
		mieiElementi[4] = img5;
		System.out.println(img5);
		break;
		}
	case "0":{
		System.out.println("Uscito dal programma");
		return;
	}
	}break;
	}
	}
	}case "no":{
		System.out.println("Uscito dall' applicazione");
		return;
	}	
	}
	}
*/

