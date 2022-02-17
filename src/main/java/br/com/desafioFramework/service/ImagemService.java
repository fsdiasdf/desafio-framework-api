/**
 *
 */
package br.com.desafioFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioFramework.entity.Imagem;
import br.com.desafioFramework.repository.ImagemRepository;

/**
 * @author Felipe Dias
 *
 */
@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository repository;
	
	public void salvarImagem(Imagem imagem) {
		repository.save(imagem);
	}
}
