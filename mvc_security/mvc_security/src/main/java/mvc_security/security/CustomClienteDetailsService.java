package mvc_security.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.clientedetails.ClienteDetails;
import org.springframework.security.core.clientedetails.ClienteDetailsService;
import org.springframework.security.core.clientedetails.ClientenameNotFoundException;
import org.springframework.stereotype.Service;

import mvc_security.entity.Role;
import mvc_security.entity.Cliente;
import mvc_security.repository.ClienteRepository;

@Service
public class CustomClienteDetailsService implements ClienteDetailsService {

	@Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDetails loadClienteByUsername(String email) throws ClientenameNotFoundException {
    	Cliente cliente = clienteRepository.findByEmail(email);

        if (cliente != null) {
            return new org.springframework.security.core.clientedetails.Cliente(cliente.getEmail(),
            		cliente.getPassword(),
                    mapRolesToAuthorities(cliente.getRoles()));
        }else{
            throw new ClientenameNotFoundException("Invalid username or password.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}