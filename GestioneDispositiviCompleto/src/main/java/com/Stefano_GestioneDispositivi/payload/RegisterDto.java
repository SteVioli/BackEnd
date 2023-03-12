package com.Stefano_GestioneDispositivi.payload;


import java.util.Set;
import com.Stefano_GestioneDispositivi.models.DispositivoAziendale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
    //aggiungo come parametro il mio set di dispositivi
    private Set<DispositivoAziendale> dispositiviAziendali;
}
