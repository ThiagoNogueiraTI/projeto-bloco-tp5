package br.edu.infnet.pb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PbApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbApplication.class, args);
        Scanner in = new Scanner(System.in);
        Usuario usuario = new Usuario();
        List<Noticia> listaNoticias = new ArrayList<Noticia>();
        int opcaoConta = -1;
        do {
            System.out.println("Digite um número inteiro:");
            System.out.println("1 - Entrar");
            System.out.println("2 - Criar conta");
            System.out.println(" ");
            System.out.println("0 - Sair");
            System.out.println(" ");
            System.out.println("----------------");
            System.out.println(" ");
            System.out.print("Digite o número: ");
            try {
                opcaoConta = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro!");
            }
        } while (opcaoConta != 1 && opcaoConta != 2 && opcaoConta != 0);
        switch (opcaoConta) {
            case 1:
                    System.out.println("Entrar");
                    System.out.println("----------------");
                    System.out.print("Digite seu email: ");
                    String inputEmail = in.nextLine();
                    System.out.println(" ");
                    System.out.print("Digite sua senha: ");
                    String inputSenha = in.nextLine();
                    break;
            case 2:
                    System.out.println("Criar conta");
                    System.out.println("----------------");
                    String inputEmailCriarConta;
                    do {
                        System.out.println(" ");
                        System.out.print("Digite seu email: ");
                        inputEmailCriarConta = in.nextLine();
                        usuario.setEmail(inputEmailCriarConta);
                        if (inputEmailCriarConta.isBlank()) {
                            System.out.println(" ");
                            System.out.println("Erro: Campo vazio!");
                        }
                    } while (inputEmailCriarConta.isBlank());
                    String inputSenhaCriarConta;
                    do {
                        System.out.println("");
                        System.out.print("Digite sua senha: ");
                        inputSenhaCriarConta = in.nextLine();
                        usuario.setSenha(inputSenhaCriarConta);
                        if (inputSenhaCriarConta.length() < 8) {
                            System.out.println("");
                            System.out.println("Erro: A senha deve ter mais de 7 digitos!");
                        }
                        if (inputSenhaCriarConta.isBlank()) {
                            System.out.println("");
                            System.out.println("Erro: Campo vazio!");
                        }
                    } while (inputSenhaCriarConta.length() < 8);
                usuario.gerarId();
                System.out.println("Conta criada!");
                break;
            case 0:
                System.out.println("Sair");
                return;
        }
        int opcaoAvancar = -1;
        do {
            System.out.println(" ");
            System.out.println("Digite um número inteiro:");
            System.out.println("1 - Perfil");
            System.out.println("2 - Criar Notícia");
            System.out.println("3 - Listar Notícia(Interagir com Like e Comentário)");
            System.out.print("Digite o número: ");
            try {
                opcaoAvancar = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro!");
            }
        //} while (opcaoAvancar < 0 && opcaoAvancar > 4);
        switch (opcaoAvancar) {
            case 1:
                int opcaoPerfil = -1;
                do {
                    System.out.println(" ");
                    System.out.println("Digite um número inteiro:");
                    System.out.println("1 - Digitar nome");
                    System.out.println("2 - Escolher plano");
                    System.out.print("Digite o número: ");
                    try {
                        opcaoPerfil = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro!");
                    }
                } while (opcaoPerfil != 1 && opcaoPerfil != 2);
                switch (opcaoPerfil){
                    case 1:
                        System.out.print("Digite seu nome: ");
                        String nome = in.nextLine();
                        usuario.setNome(nome);
                        System.out.print("Nome alterado com sucesso!");
                        break;
                    case 2:
                        int opcaoPlano = -1;
                        do {
                            System.out.print("Escolha seu plano:");
                            System.out.println("Digite um número inteiro:");
                            System.out.println("1 - Grátis - permanecer");
                            System.out.println("2 - Pago");
                            System.out.print("Digite o número: ");
                            try {
                                opcaoPlano = Integer.parseInt(in.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Erro!");
                            }
                        } while (opcaoPlano != 1 && opcaoPlano != 2);
                        switch (opcaoPlano){
                            case 1:
                                System.out.println("Plano grátis");
                                usuario.setPlano(Usuario.Plano.Gratis);
                                break;
                            case 2:
                                int opcaoPagamento = -1;
                                do {
                                    System.out.print("Escolha a forma de pagamento:");
                                    System.out.println("Digite um número inteiro:");
                                    System.out.println("1 - Boleto");
                                    System.out.println("2 - Cartão");
                                    System.out.println("3 - Pix");
                                    System.out.print("Digite o número: ");
                                    try {
                                        opcaoPagamento = Integer.parseInt(in.nextLine());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Erro!");
                                    }
                                } while (opcaoPagamento != 1 && opcaoPagamento != 2 && opcaoPagamento != 3);
                                if (opcaoPagamento == 1){
                                    System.out.println("Gerando boleto...");
                                } else if(opcaoPagamento == 2){
                                    System.out.println("Digite os dados do seu cartão...");
                                } else {
                                    System.out.println("Gerando qr code e código pix...");
                                }
                                break;
                        }
                        break;
                }
                break;
            case 2:
            Noticia noticia = new Noticia();
            System.out.println("2 -- Criar Notícia");
            System.out.print("Digite o título: ");
            String inputTitulo = in.nextLine();
            noticia.setTitulo(inputTitulo);
            System.out.print("Digite o conteúdo: ");
            String inputConteudo = in.nextLine();
            noticia.setConteudo(inputConteudo);
            listaNoticias.add(noticia);
            //List<String> vazio = new ArrayList<>();
            noticia.setComentarios(new ArrayList<>());
            System.out.print("Notícia cadastrada com sucesso!");
            break;
            case 3:
               System.out.println("3 -- Listar Notícia(Interagir com Like e Comentário)");
               int j = 1;
        	   System.out.println(" ");
        	   System.out.println("---------------------------------------");
        	   System.out.println(" ");
               for(Noticia i : listaNoticias) {
            	   System.out.println(j + " - Titulo: " + i.getTitulo() + " - Conteúdo: " + i.getConteudo());
            	   //System.out.println("---------------------------------------");
            	   System.out.println("Curtidas: " + i.getCurtidas());
            	   //System.out.println("---------------------------------------");
            	   if(i.getComentarios().size() == 0) {
            		   System.out.println("Sem comentários");
            	   }else {
            		   System.out.println("Comentários: ");
                	   System.out.println(" ");
					 for (int k = 0; k < i.getComentarios().size(); k++) {
            		   System.out.println(usuario.getNome() != null ? usuario.getNome() : "Visitante" + " - " + i.getComentarios().get(k));
					 }
            	   }
            	   System.out.println(" ");
            	   System.out.println("---------------------------------------");
            	   System.out.println(" ");
            	   j++;
               }
               int opcaoInteragir = -1;
               do {
                   System.out.print("Escolha o número da notícia que deseja interagir: ");
                   try {
                	   opcaoInteragir = Integer.parseInt(in.nextLine());
                   } catch (NumberFormatException e) {
                       System.out.println("Erro!");
                   }
			} while (opcaoInteragir > listaNoticias.size() || opcaoInteragir < 0);
               int opcaoCurtirComentar = -1;
               System.out.println("Escolha o número da opção que deseja efetuar: ");
               System.out.println("1 - Curtir");
               System.out.println("2 - Comentar");
               try {
            	   opcaoCurtirComentar = Integer.parseInt(in.nextLine());
               } catch (NumberFormatException e) {
                   System.out.println("Erro!");
               }               
               switch (opcaoCurtirComentar) {
	               case 1:
	            	Noticia objetoNoticia = listaNoticias.get(opcaoInteragir -1);
					objetoNoticia.setCurtidas(objetoNoticia.getCurtidas()+1);
					System.out.println("Quantidade de curtidas: " + objetoNoticia.getCurtidas());
					listaNoticias.set(opcaoInteragir-1, objetoNoticia);
					break;
					case 2:
		            Noticia objetoComentar = listaNoticias.get(opcaoInteragir -1);
		            String comentario;
					System.out.print("Escreva seu comentário: ");
					comentario = in.nextLine();
					List<String> listaComentarios = objetoComentar.getComentarios();
					listaComentarios.add(comentario);
					objetoComentar.setComentarios(listaComentarios);
					listaNoticias.set(opcaoInteragir-1, objetoComentar);					
					break;
			}
               break;
        }
  }while (opcaoAvancar != 0);
}}

