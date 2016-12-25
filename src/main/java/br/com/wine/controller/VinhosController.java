package br.com.wine.controller;

import java.util.List;

import br.com.wine.model.TipoVinho;
import br.com.wine.service.CadastroVinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.wine.model.Vinho;
import br.com.wine.repository.VinhosRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

    @Autowired
    private CadastroVinhoService cadastroVinhoService;

	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/vinho/ListagemVinhos");
		mv.addObject("vinhos", cadastroVinhoService.buscar());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("/vinho/CadastroVinho");
		mv.addObject("tipos", TipoVinho.values());
		return mv;
	}

@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(vinho);
        }
        cadastroVinhoService.salvar(vinho);
        attributes.addFlashAttribute("mensagem", "Vinho salvo com sucesso!");
        return new ModelAndView("redirect:/vinhos/novo");
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView visualizar(@PathVariable("codigo") Vinho vinho) {
	    ModelAndView mv = new ModelAndView("/vinho/VisualizacaoVinho");
        mv.addObject("vinho", vinho);
        return mv;

    }
}
