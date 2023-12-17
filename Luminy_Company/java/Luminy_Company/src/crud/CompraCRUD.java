package crud;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.PassagemDAO;
import modelos.Clientes;
import modelos.Compras;
import modelos.Passagem;

public class CompraCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		PassagemDAO passagemDAO = new PassagemDAO();
		
		int opcao = 0, id = 0, id_cliente = 0; 
		
		
		do {
			
			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data da compra:");
				String data_compra = s.nextLine();
				System.out.println("Digite o total da compra:");
				double total_compra = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do Passagem:");
				int id_passagem = s.nextInt();
				s.nextLine();
				
				Clientes cliente1 = clienteDAO.readById(id_cliente);
				Passagem passagem1 = passagemDAO.readById(id_passagem);
				
				
				Compras compra1 = new Compras(data_compra, total_compra, cliente1, passagem1);
				
				
				compraDAO.create(compra1);
				break;
			case 2:
				
				for (Compras c : compraDAO.read()) {
					
					System.out.println(c.toString());
					
				}
				
				break;
			case 3:
				System.out.println("Digite o id da compra:");
				id = s.nextInt();
				s.nextLine();				
				System.out.println("Digite a data da compra:");
				data_compra = s.nextLine();
				System.out.println("Digite o total da compra:");
				total_compra = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o id do cliente:");
				int id_cliente2 = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do Passagem:");
				int id_Passagem2 = s.nextInt();
				s.nextLine();
				
				Clientes cliente2 = clienteDAO.readById(id_cliente2);
				Passagem passagem2 = passagemDAO.readById(id_Passagem2);
				
				
				Compras compra2 = new Compras(id, data_compra,total_compra, cliente2, passagem2);
				
				compraDAO.update(compra2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				compraDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Compras compra3 = compraDAO.readById(id);
				
				System.out.println(compra3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();
	}

}
