package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	
		@Test
		public void initBanco() {
			UserPosDAO userPosDAO = new UserPosDAO();
			Userposjava userposjava = new Userposjava();
			
			userposjava.setNome("Robson");
			userposjava.setEmail("robson.francisco@gmail.com");
			
			userPosDAO.salvar(userposjava);
		}
		
		@Test
		public void initListar() {
			UserPosDAO dao = new UserPosDAO();
			try {
				List<Userposjava> list = dao.listar();
				
				for (Userposjava userposjava : list) {
					System.out.println(userposjava);
					System.out.println("----------------------------------------");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void initBuscar() {
			UserPosDAO dao = new UserPosDAO();
			try {
				Userposjava userposjava = dao.buscar(6L);
				System.out.println(userposjava);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void InitAtualizar() {
			try {
				UserPosDAO dao = new UserPosDAO();
				
				Userposjava objetoBanco = dao.buscar(5L);
				
				objetoBanco.setNome("Nome com metodo atualizar");
				
				dao.atualizar(objetoBanco);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void initDeletar() {
			
			try {
				UserPosDAO dao = new UserPosDAO();
				dao.deletar(5L);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
		@Test
		public void testeInsertTelefone() {
			
			Telefone telefone = new Telefone();
			telefone.setNumero("(22) 3312-4896 ");
			telefone.setTipo("Residencial");
			telefone.setUsuario(2L);
			
			UserPosDAO dao = new UserPosDAO();
			dao.salvarTelefone(telefone);
			
		}
		
		@Test
		public void testeCarregaFoneUser () {
			UserPosDAO dao = new UserPosDAO();
			
			List<BeanUserFone> beanUserFones = dao.listaUserFone(1L);
			
			for (BeanUserFone beanUserFone : beanUserFones) {
				System.out.println(beanUserFone);
				System.out.println("-------------------------------------");
			}
			
			
		}
		
}
