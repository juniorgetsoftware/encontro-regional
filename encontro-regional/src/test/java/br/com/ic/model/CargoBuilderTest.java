package br.com.ic.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ic.model.Cargo;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CargoBuilderTest {

	@Test
	public void deveTestarFuncionamentoDoPadraoBuilderDoLombok() {
		Cargo cargo = Cargo.builder().id(1l).nome("Presidente").descricao("Descrição do cargo").build();
		Assert.assertEquals("Campo id", 1l, cargo.getId().longValue());
		Assert.assertEquals("Campo nome", "Presidente", cargo.getNome());
		Assert.assertEquals("Campo descrição", "Descrição do cargo", cargo.getDescricao());
	}

}
