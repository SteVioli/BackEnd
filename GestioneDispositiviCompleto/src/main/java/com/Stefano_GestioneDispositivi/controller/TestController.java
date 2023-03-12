package com.Stefano_GestioneDispositivi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Stefano_GestioneDispositivi.models.DispositivoAziendale;
import com.Stefano_GestioneDispositivi.models.StatoDispositivo;
import com.Stefano_GestioneDispositivi.models.User;
import com.Stefano_GestioneDispositivi.repository.DispositivoDaoRepository;
import com.Stefano_GestioneDispositivi.repository.UserRepository;
import com.Stefano_GestioneDispositivi.service.DispositivoService;
import com.Stefano_GestioneDispositivi.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//mi faccio l autowired dell'user service che ho creato per farmi ritornare o errori specifici oppure liste di utenti o di singoli utenti
	@Autowired UserService userService;
	//stessa cosa per i dispositivi
	@Autowired DispositivoService dispoService;
	@Autowired UserRepository userRepo;
	@Autowired DispositivoDaoRepository dispoRepo;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/auth")
	@PreAuthorize("isAuthenticated()")
	public String autenticatedAccess() {
		return "Autenticated Content.";
	}
	
	// mi sono modificato e creato i get mapping per utenti ( e quindi anche mod e admin)
	// per visualizzarmeli su postman
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers() ,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable Long id){  //per leggere il parametro dell url metto @pathvariable
		
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	////////////////////////////////////////////////////////////////
	
	//il fare vedere tutti i dispositivi aziendali ho scelto di non farli vedere anche agli utenti, perchè mi sono
	//immaginato in una situazione reale, dove sarà un admin o un responsabile a dare un dispositivo, per merito o sotto richiesta
	//da parte di un utente. (es. E' possibile avere uno smartphone? --- Il capo fa le valutazioni e consente o meno il dispositivo in seguito (col metodo put per aggiornare)
	//viceversa aggiungo al preauthorize anche has role ('USER')
	
	@GetMapping("/dispositivi")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<DispositivoAziendale>> getAllDispositivi(){
		return new ResponseEntity<List<DispositivoAziendale>> (dispoService.getAllDispositivi(),HttpStatus.OK);
	}
	
	@GetMapping("/dispositivi/tipo/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<DispositivoAziendale> getDispositivo(@PathVariable Long id){
		return new ResponseEntity<DispositivoAziendale> (dispoService.getDispositivoById(id),HttpStatus.OK);
	}
	
	//per questo metodo se si vuole popolare il db con i dispositivi dal runner per fare prima
	//dalla stessa rotta di dispositivi per ogni slash /  scelgo un utente che esiste e col secondo slash gli associo un dispositivo che esiste SE DISPONIBILE
	@PutMapping("/dispositivi/{id}/{dispo}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<User> aggiungiDispositivo(@PathVariable Long id,@PathVariable Long dispo){
		if(!userRepo.existsById(id)) {
			throw new EntityNotFoundException("ERRORE, UTENTE NON TROVATO!! ");
		}else {
			User u = userService.getUserById(id);
			DispositivoAziendale d = dispoService.getDispositivoById(dispo);
			Set<DispositivoAziendale> setDispo = u.getDispositivi();
			if(d.getStatoDispositivo() != StatoDispositivo.DISPONIBILE) {
				throw new IllegalArgumentException("Dispositivo non disponibile!!!!");
			}
			d.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
			setDispo.add(d);
			u.setDispositivi(setDispo);
			
			return new ResponseEntity<User>(userService.updateUser(u),HttpStatus.OK);
		}
	}
	
	
	//cancella utente solo x ADMIN
	@DeleteMapping("/cancellaUtente/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return new ResponseEntity<String>(userService.removeUserById(id),HttpStatus.OK);
	}
	
	//cancella dispositivo x admin e mod
	@DeleteMapping("/cancellaDispositivo/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteDispositivo(@PathVariable Long id){
		return new ResponseEntity<String>(dispoService.removeDispositivoById(id),HttpStatus.OK);
	}
	
	
	
	
	//faccio creare dei dispositivi NUOVI solo dagli admin
	@PostMapping("/creaDispo")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DispositivoAziendale> creaDispositivo(@RequestBody DispositivoAziendale d){
		return new ResponseEntity<DispositivoAziendale>(dispoService.saveDispositivo(d),HttpStatus.OK);
	}
	
	
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	///////////////////// mapping implementato con dispositivi //////////////////////////
	
	
}
