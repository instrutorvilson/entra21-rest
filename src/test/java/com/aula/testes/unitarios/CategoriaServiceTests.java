package com.aula.testes.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aula.testes.entidades.Categoria;
import com.aula.testes.repositories.CategoriaRepository;
import com.aula.testes.services.CategoriaService;

@ExtendWith(SpringExtension.class)
public class CategoriaServiceTests {
	@Mock
	CategoriaRepository repository; //recurso mokado
	
	@InjectMocks
	CategoriaService service; //recurso que está sendo testado

	@Test
	public void retornaObjetoQuandoSalvaCategoria() {	
		Categoria newCategoria = new Categoria();
		newCategoria.setDescricao("Cereal");
		Mockito.when(repository.save(newCategoria)).thenReturn(newCategoria);
		
		Assertions.assertNotNull(service.salvar(newCategoria));
		
		Mockito.verify(repository, Mockito.times(1)).save(newCategoria);		
	}
	
	@Test
	public void lancaRuntimeExceptionQuandoSalvaCategoriaSemDescricao() {	
		Categoria newCategoria = new Categoria();
		newCategoria.setDescricao("");
		Mockito.when(repository.save(newCategoria)).thenReturn(newCategoria);
		
		Assertions.assertThrows(RuntimeException.class, ()-> service.salvar(newCategoria));
		Mockito.verify(repository, Mockito.times(0)).save(newCategoria);//não chama porque ocorreu a exceção
    }
	
	@Test
	public void doThrowQuandoSalvaCategoriaSemDescricao() {	
		Categoria newCategoria = new Categoria();
		newCategoria.setDescricao("");
		doThrow(new RuntimeException("Descrição é necessário")).when(repository).save(newCategoria);
		try {
			repository.save(newCategoria);
		}
		catch(RuntimeException e) {
			assertEquals("Descrição é necessário", e.getMessage());
		}
    }
	
	@Test
	public void naoRetornaNadaQuandoExcluiCategoriaExistente() {
		service.excluir(1l);
		Mockito.doNothing().when(repository).deleteById(1L);
		Mockito.verify(repository, Mockito.times(1)).deleteById(1l);
		Assertions.assertDoesNotThrow(()-> service.excluir(1L));
    }
	
	
	
}
