package mvc_security.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mvc_security.dto.ClienteDto;
import mvc_security.entity.Role;
import mvc_security.entity.Cliente;
import mvc_security.repository.RoleRepository;
import mvc_security.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveCliente(ClienteDto clienteDto) {
    	Cliente cliente = new Cliente();
    	cliente.setName(userDto.getFirstName() + " " + userDto.getLastName());
    	cliente.setEmail(userDto.getEmail());
       
    	cliente.setPassword(passwordEncoder.encode(clienteDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null) {
            role = checkRoleExist();
        }
        cliente.setRoles(Arrays.asList(role));
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente findClienteByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public List<ClienteDto> findAllCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        return cliente.stream()
                .map((cliente) -> mapToClienteDto(cliente))
                .collect(Collectors.toList());
    }

    private ClienteDto mapToClienteDto(Cliente cliente){
    	ClienteDto clienteDto = new ClienteDto();
        String[] str = cliente.getName().split(" ");
        clienteDto.setFirstName(str[0]);
        clienteDto.setLastName(str[1]);
        clienteDto.setEmail(cliente.getEmail());
        return clienteDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}