package pos_java_jdbc.pos_java_jdbc;


import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;
import java.util.List;


public class TesteBancojdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();

		userPosJava.setNome("João");
		userPosJava.setEmail("joao@teste.com");

		userPosDAO.salvar(userPosJava);
	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("--------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() throws Exception {
		
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava userposjava = dao.buscar(3L);
		
		System.out.println(userposjava);
		
	}
	
	@Test
	public void initAtualizar() {
		
		try {
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava objetoBanco = dao.buscar(5L);
		objetoBanco.setNome("Nome alterado com método atualizar");
		
		dao.atualizar(objetoBanco);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDeletar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(9L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeInsertTelefone(){ 
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(61) 981566489");
		telefone.setTipo("Celular");
		telefone.setUsuario(3L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
				
		
	}	
	
	@Test
	public void testeCarregaFonesUser() {
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(2L);
		
		for(BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("----------------------------------");
		}
	}
	
	@Test
	public void testeDeleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPerUser(2L);
	}
}
