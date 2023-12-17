package crud;

import java.util.Scanner;

import dao.PassagemDAO;
import modelos.Passagem;

public class PassagemCRUD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PassagemDAO passagemDAO = new PassagemDAO();
		
		int opcao = 0, id = 0;
		
		String destino;
		float preco;
				
		do {
			
			System.out.println("\n========================= Passagem =============================\n");
			System.out.println("1-CRIAR 2-CONSULTAR 3- ATUALIZAR 4-DELETAR 5-CONSULTAR POR ID 0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			
			case 1:
				
				System.out.println("Digite o destino");
				destino = s.nextLine();
				System.out.println("Digite a preco");
				preco = s.nextFloat();
				
				Passagem passagem1 = new Passagem(destino, preco);
				
				passagemDAO.create(passagem1); 
				break;
			case 2:
				
				for(Passagem p : passagemDAO.read()) {
					System.out.println(p.toString());
				}
				passagemDAO.read();
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();			
				System.out.println("Digite o destino");
				destino = s.nextLine();
				System.out.println("Digite a preco");
				preco = s.nextFloat();
				s.nextLine();
				
				Passagem passagem2 = new Passagem(id, destino, preco);
				
				passagemDAO.update(passagem2); 
				break;
			case 4:
				
				System.out.println("Digite um id");
				id = s.nextInt();
				s.nextLine();
				
				passagemDAO.delete(id);
				break;
			case 5:
				
				System.out.println("Digite um id");
				id = s.nextInt();
				s.nextLine();
				
				Passagem passagem3 = passagemDAO.readById(id);
				
				System.out.println(passagem3.toString());
				
				passagemDAO.readById(id);
				break;
			default:
				
				break;
			}
			
		}while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}



	}
