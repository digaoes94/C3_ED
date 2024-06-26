package application;

import java.util.Random;
import java.util.Scanner;

import presidiario.ArvorePS;
import presidiario.ItemPS;
import presidiario.NoPS;
import presidio.ArvorePR;
import presidio.ItemPR;
import presidio.NivelSEG;
import presidio.NoPR;

public class MainSistema {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();

	public static void main(String[] args) {
		boolean run = true;
		ArvorePS arvPS = new ArvorePS();
		ArvorePR arvPR = new ArvorePR();
		
		System.out.println("Sistema de Prisões Estaduais");
		
		do {
			run = Menu(arvPS, arvPR);
		} while (run);
	}
	
	public static boolean Menu(ArvorePS arvPS, ArvorePR arvPR) {
		//  System.out.println("");
		int opcao, codigoPS, codigoPR, idadePS;
		String nomePS, nomePR, cidadePR, quebra, nivelPR;
		String[] presidios;
		NoPS noPS;
		NoPR noPR;
		NivelSEG nivel;
		boolean resultado;
		
		System.out.println("\nInforme procedimento a realizar:");
		System.out.println("1. Registrar presidiário");
		System.out.println("2. Registrar presídio");
		System.out.println("3. Pesquisar presidiário");
		System.out.println("4. Pesquisar presídio");
		System.out.println("5. Excluir presidiário");
		System.out.println("6. Excluir presídio");
		System.out.println("7. Quantidade de idosos encarcerados");
		System.out.println("8. Listar todos os presidiários");
		System.out.println("9. Procurar presídios por cidade");
		System.out.println("10. Procurar presídios por nível de segurança");
		System.out.println("11. Encerrar programa");
		
		opcao = scan.nextInt();
		quebra = scan.nextLine();
		
		if (opcao == 11) {
			return false;
		}
		else {
			switch (opcao) {
			case 1:
				codigoPS = codPS();
				System.out.println("\nInforme nome do presidiário:");
				nomePS = scan.nextLine();
				System.out.println("Informe idade do presidiário:");
				idadePS = scan.nextInt();
				quebra = scan.nextLine();
				System.out.println("Informe em qual presídio será alocado:");
				nomePR = scan.nextLine();
				
				if (arvPS.inserir(new ItemPS(codigoPS, idadePS, nomePS, nomePR))) {
					System.out.println("\nPresidiário registrado.");
				}
				else {
					System.out.println("\nPresidiário não registrado.");
				}
				return true;
				
			case 2:
				codigoPR = codPR();
				System.out.println("\nInforme nome do presídio:");
				nomePR = scan.nextLine();
				System.out.println("Informe a cidade do presídio:");
				cidadePR = scan.nextLine();
				
				System.out.println("Informe o nível de segurança do presídio:");				
				System.out.println("OBS: MI para Mínima, MO para Moderada, MA para Máxima.");
				nivelPR = scan.nextLine();
				if (nivelPR == "MI") {
					nivel = NivelSEG.MÍNIMA;
				}
				else if (nivelPR == "MO") {
					nivel = NivelSEG.MODERADA;
				}
				else if (nivelPR == "MA") {
					nivel = NivelSEG.MÁXIMA;
				}
				else {
					System.out.println("Opção inválida, o programa retornará ao menu.");
					return true;
				}
				
				if (arvPR.inserir(new ItemPR(codigoPR, nomePR, cidadePR, nivel))) {
					System.out.println("Presídio registrado.");
				}
				else {
					System.out.println("Presídio não registrado.");
				}			
				return true;
				
			case 3:
				System.out.println("\nInforme o código do presidiário:");
				codigoPS = scan.nextInt();
				noPS = arvPS.pesquisar(codigoPS);
				System.out.println(noPS.toString());
				return true;
				
			case 4:
				System.out.println("\nInforme o código do presídio:");
				codigoPR = scan.nextInt();
				noPR = arvPR.pesquisar(codigoPR);
				System.out.println(noPR.toString());
				return true;
				
			case 5:
				System.out.println("\nInforme o código do presidiário:");
				codigoPS = scan.nextInt();
				resultado = arvPS.remover(codigoPS);
				
				if (resultado == true) {
					System.out.println("\nPresidiário removido.");
				}
				else {
					System.out.println("\nPresidiário não foi encontrado.");
				}
				return true;
				
			case 6:
				System.out.println("\nInforme o código do presídio:");
				codigoPR = scan.nextInt();
				resultado = arvPR.remover(codigoPR);
				
				if (resultado == true) {
					System.out.println("\nPresídio removido.");
				}
				else {
					System.out.println("\nPresídio não foi encontrado.");
				}
				return true;
				
			case 7:
				System.out.println("\nA quantidade de presidiários idosos é " + arvPS.ContarIdosos() + ".");
				return true;
				
			case 8:
				System.out.println();
				String[] listaPresos = arvPS.ListaPresos();
				
				for (String x : listaPresos) {
					System.out.println(x + ".\n");
				}
				return true;
				
			case 9:
				System.out.println("\nInforme o nome da cidade:");
				cidadePR = scan.nextLine();
				presidios = arvPR.CidadePresidio(cidadePR);
				
				for (String x : presidios) {
					System.out.println(x + ".\n");
				}
				return true;
				
			case 10:
				System.out.println("\nInforme o nível de segurança da cidade:");
				System.out.println("OBS: MI para Mínima, MO para Moderada, MA para Máxima.");
				nivelPR = scan.nextLine();
				if (nivelPR == "MI") {
					nivel = NivelSEG.MÍNIMA;
				}
				else if (nivelPR == "MO") {
					nivel = NivelSEG.MODERADA;
				}
				else if (nivelPR == "MA") {
					nivel = NivelSEG.MÁXIMA;
				}
				else {
					System.out.println("Opção inválida, o programa retornará ao menu.");
					return true;
				}
				
				presidios = arvPR.PresidioNivel(nivel);
				
				for (String x : presidios) {
					System.out.println(x + ".\n");
				}
				
				return true;
				
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
		}
	}
	
	public static int codPS() {
		return ran.nextInt(500001);
	}
	public static int codPR() {
		return ran.nextInt(101);
	}
}