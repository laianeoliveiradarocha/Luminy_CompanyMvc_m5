package mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Compras;
import mvc.repository.ComprasRepository;
import mvc.repository.PassagemRepository;
import mvc.repository.ClienteRepository;

@Controller
@RequestMapping("/compras")
public class ComprasController {
	
	@Autowired
	private ComprasRepository comprasRepository; 
	@Autowired
	private ClienteRepository clienteRepository; 
	@Autowired 
	private PassagemRepository passagemRepository;

	@GetMapping
	public ModelAndView compras() {
		ModelAndView modelAndView = new ModelAndView("views/compras/index.html");

		modelAndView.addObject("listaCliente", clienteRepository.findAll());
		modelAndView.addObject("listaPassagem", passagemRepository.findAll());
		modelAndView.addObject("compras", comprasRepository.findAll());
		modelAndView.addObject("compra", new Compras());

		return modelAndView;
	}

	
	@PostMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("compras") Compras compras) {

		// Logica provisoria para salvar o preço da passagem em compras.
		double preco = passagemRepository.findById(compras.getPassagem().getId()).get().getPreco();
		compras.setTotal_compra(preco);

        comprasRepository.save(compras);

		return "redirect:/compras";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable long id) {
		comprasRepository.deleteById(id);

		return "redirect:/compras";
	}
}