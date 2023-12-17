package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Passagem;
import mvc.repository.PassagemRepository;

@Controller
@RequestMapping("/passagem")
public class PassagemController {
    
	@Autowired
	private PassagemRepository passagemRepository;

	@GetMapping
	public ModelAndView passagem() {
		ModelAndView modelAndView = new ModelAndView("views/passagem/index.html");
		
		modelAndView.addObject("passagem", passagemRepository.findAll());
		modelAndView.addObject("passagem", new Passagem());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Passagem passagem) {
		passagemRepository.save(passagem);

		return "redirect:/passagem";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable long id) {
		passagemRepository.deleteById(id);

		return "redirect:/passagem";
	}

}