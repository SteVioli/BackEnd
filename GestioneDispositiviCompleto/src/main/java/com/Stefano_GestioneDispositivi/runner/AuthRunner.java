package com.Stefano_GestioneDispositivi.runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Stefano_GestioneDispositivi.models.DispositivoAziendale;
import com.Stefano_GestioneDispositivi.models.ERole;
import com.Stefano_GestioneDispositivi.models.Laptop;
import com.Stefano_GestioneDispositivi.models.Role;
import com.Stefano_GestioneDispositivi.models.Smartphone;
import com.Stefano_GestioneDispositivi.models.StatoDispositivo;
import com.Stefano_GestioneDispositivi.models.Tablet;
import com.Stefano_GestioneDispositivi.models.User;
import com.Stefano_GestioneDispositivi.payload.RegisterDto;
import com.Stefano_GestioneDispositivi.repository.RoleRepository;
import com.Stefano_GestioneDispositivi.repository.UserRepository;
import com.Stefano_GestioneDispositivi.service.AuthService;
import com.Stefano_GestioneDispositivi.service.DispositivoService;


@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	@Autowired DispositivoService dispoService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	private Set<DispositivoAziendale> dispositivoAziendaleTest;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("*************RUNNER OPERATIVO*************");
		
		//per creare una sorta di STOCK fittizio aziendale di partenza
		//eventualmente nel dispoService, si possono creare dei nuovi dispositivi singoli per poi associarli 
		//all utente in un secondo momento
		
//		popolaDbTablet();
//		popolaDbSmartphone();
//		popolaDbLaptop();
		
//		setRoleDefault();
//		setUserDefault();
//		
		
		// breve prova per verificare che un dispositivo non possa essere associato a 2 utenti differenti 
		// (per fare i check modificare chiavi univoche, consiglio modifica della parola prova1 --> prova2)
		// check validato del set di dispositivi
		
//		User u = new User();
//		u.setEmail("prova1@example.com");
//		u.setName("Stefano Prova1");
//		u.setPassword(passwordEncoder.encode("123123"));
//		u.setUsername("Prova1");
//		dispositivoAziendaleTest = new HashSet<>();
//		DispositivoAziendale d = dispoService.getDispositivoById(2l);
//		DispositivoAziendale d1 = dispoService.getDispositivoById(5l);
//		DispositivoAziendale d2 = dispoService.getDispositivoById(9l);
//		dispositivoAziendaleTest.add(d);
//		dispositivoAziendaleTest.add(d1);
//		dispositivoAziendaleTest.add(d2);
//		u.setDispositivi(dispositivoAziendaleTest);
//		
//		userRepository.save(u);
		

		
		
	}
/////////////// Metodo per creare n laptop fittizi per fare prove /////////////////
	private void popolaDbLaptop() {
		
			DispositivoAziendale l1 = new Laptop();
			l1.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
			dispoService.saveDispositivo(l1);
		
		
			DispositivoAziendale l2 = new Laptop();
			l2.setStatoDispositivo(StatoDispositivo.DISMESSO);
			dispoService.saveDispositivo(l2);
		
		
			DispositivoAziendale l3 = new Laptop();
			l3.setStatoDispositivo(StatoDispositivo.DISPONIBILE);
			dispoService.saveDispositivo(l3);
		
		
			DispositivoAziendale l4 = new Laptop();
			l4.setStatoDispositivo(StatoDispositivo.IN_MANUTENZIONE);
			dispoService.saveDispositivo(l4);
		
	}
	
/////////////// Metodo per creare n smartphone fittizi per fare prove /////////////////
	private void popolaDbSmartphone() {
		
			DispositivoAziendale s1 = new Smartphone();
			s1.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
			dispoService.saveDispositivo(s1);
		
		
			DispositivoAziendale s2 = new Smartphone();
			s2.setStatoDispositivo(StatoDispositivo.DISMESSO);
			dispoService.saveDispositivo(s2);
		
		
			DispositivoAziendale s3 = new Smartphone();
			s3.setStatoDispositivo(StatoDispositivo.DISPONIBILE);
			dispoService.saveDispositivo(s3);
		
		
			DispositivoAziendale s4 = new Smartphone();
			s4.setStatoDispositivo(StatoDispositivo.IN_MANUTENZIONE);
			dispoService.saveDispositivo(s4);
		
	}
	
	
	/////////////// Metodo per creare n tablet fittizi per fare prove /////////////////
	private void popolaDbTablet() {
		
			DispositivoAziendale d1 = new Tablet();
			d1.setStatoDispositivo(StatoDispositivo.DISMESSO);
			dispoService.saveDispositivo(d1);
		
		
			DispositivoAziendale d2 = new Tablet();
			d2.setStatoDispositivo(StatoDispositivo.DISPONIBILE);
			dispoService.saveDispositivo(d2);
		
		
			DispositivoAziendale d3 = new Tablet();
			d3.setStatoDispositivo(StatoDispositivo.IN_MANUTENZIONE);
			dispoService.saveDispositivo(d3);
			
			DispositivoAziendale d4 = new Tablet();
			d4.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
			dispoService.saveDispositivo(d4);
	}
	
	
	private void setRoleDefault() {
		
		
		
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		userRole = new HashSet<Role>();
		userRole.add(user);
	}
	
	private void setUserDefault() {
		
		
		Set<String> roleAdmin = new HashSet<>(
				adminRole.stream()
						.map(r -> r.getRoleName().toString())
						.collect(Collectors.toList())
				);
		Set<String> roleModerator = new HashSet<>(
				moderatorRole.stream()
						.map(r -> r.getRoleName().toString())
						.collect(Collectors.toList())
				);
		Set<String> roleUser = new HashSet<>(
				userRole.stream()
						.map(r -> r.getRoleName().toString())
						.collect(Collectors.toList())
				);
		
	
		
		
		RegisterDto userAdmin = new RegisterDto();
		userAdmin.setName("Admino Stretor");
		userAdmin.setUsername("admin");
		userAdmin.setEmail("admin@example.com");
		userAdmin.setPassword(passwordEncoder.encode("admin"));
		userAdmin.setRoles(roleAdmin);
		System.out.println(authService.register(userAdmin));
		
		RegisterDto simpleUser = new RegisterDto();
		simpleUser.setName("Mario Rossi");
		simpleUser.setUsername("mariorossi");
		simpleUser.setEmail("m.rossi@example.com");
		simpleUser.setPassword(passwordEncoder.encode("12345"));
		simpleUser.setRoles(roleUser);
		System.out.println(authService.register(simpleUser));
		
		RegisterDto userModerator = new RegisterDto();
		userModerator.setName("Giuseppe Verdi");
		userModerator.setUsername("giuver");
		userModerator.setEmail("g.verdi@example.com");
		userModerator.setPassword(passwordEncoder.encode("qwerty"));
		userModerator.setRoles(roleModerator);
		System.out.println(authService.register(userModerator));
	}

}
