package mvc_security.service.impl;

import java.util.List;

import mvc_security.dto.ClienteDto;
import mvc_security.entity.Cliente;

public interface ClienteService {
    void saveCliente(ClienteDto clienteDto);

    Cliente findClienteByEmail(String email);

    List<ClienteDto> findAllCliente();
}