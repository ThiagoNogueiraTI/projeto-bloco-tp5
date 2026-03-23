package br.edu.infnet.pb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PbApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbApplication.class, args);
        Scanner in = new Scanner(System.in);
        Usuario usuario = new Usuario();
        if(usuario.getNoticiaSalva() == null || usuario.getNoticiaSalva().size() == 0) {
            usuario.setNoticiaSalva(new ArrayList<Noticia>());
        }
        EditorChefe editorChefe2 = new EditorChefe();
        Administrador administrador2 = new Administrador();
        Jornalista jornalista2 = new Jornalista();

        // simulando notícia para revisar
        List<Noticia> listaNoticiasParaRevisarTeste = new ArrayList<Noticia>();
        Noticia noticiaParaRevisarTeste = new Noticia();
        noticiaParaRevisarTeste.setTitulo("Cruzeiro");
        noticiaParaRevisarTeste.setConteudo("Cruzeiro é o maior de minas!");
        noticiaParaRevisarTeste.setComentarios(new ArrayList<>());
        listaNoticiasParaRevisarTeste.add(noticiaParaRevisarTeste);
        editorChefe2.setNoticiasParaRevisar(listaNoticiasParaRevisarTeste);
        // fim do teste

        
        //simulando acessos para liberar
        List<String> listaAcessosParaLiberarTeste = new ArrayList<String>();
        Administrador acessoParaLiberarTeste = new Administrador();
        listaAcessosParaLiberarTeste.add("João - ID 123");
        listaAcessosParaLiberarTeste.add("Miguel - ID 234");
        listaAcessosParaLiberarTeste.add("Alberto - ID 345");
        administrador2.setAcessosParaLiberar(listaAcessosParaLiberarTeste);
        //fim do teste
        
        //simulando noticia usuario
        List<Noticia> listaNoticiaUsuarioTeste = editorChefe2.getNoticiasPublicadas() != null ? editorChefe2.getNoticiasPublicadas() : new ArrayList<Noticia>();
        Noticia noticiaUsuarioTeste = new Noticia();
        Noticia noticiaUsuarioTeste2 = new Noticia();
        noticiaUsuarioTeste.setTitulo("Testando a notícia");
        noticiaUsuarioTeste.setConteudo("Descrição da primeira notícia");
        noticiaUsuarioTeste.setComentarios(new ArrayList<>());
        listaNoticiaUsuarioTeste.add(noticiaUsuarioTeste);
        noticiaUsuarioTeste2.setTitulo("Segunda Notícia");
        noticiaUsuarioTeste2.setConteudo("Descrição da segunda notícia");
        noticiaUsuarioTeste2.setComentarios(new ArrayList<>());
        listaNoticiaUsuarioTeste.add(noticiaUsuarioTeste2);
        editorChefe2.setNoticiasPublicadas(listaNoticiaUsuarioTeste);
        //fim do teste
        
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
	             String[] listaIdJornalista = jornalista2.getIdJornalistas();
	             String[] listaIdEditorChefe = editorChefe2.getIdEditorChefe();
	             String[] listaIdAdministrador = administrador2.getIdAdm();
                
                 System.out.println("Entrar");
                 System.out.println("----------------");
                 System.out.print("Digite seu email: ");
                 String inputEmail = in.nextLine();
                 System.out.println(" ");
                 System.out.print("Digite sua senha: ");
                 String inputSenha = in.nextLine();
                 usuario.gerarId();
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

        Jornalista jornalistaPermitir = new Jornalista();
        EditorChefe editorChefePermitir = new EditorChefe();
        Administrador administradorPermitir = new Administrador();

        String[] listaIdJornalista = jornalistaPermitir.getIdJornalistas();
        String[] listaIdEditorChefe = editorChefePermitir.getIdEditorChefe();
        String[] listaIdAdministrador = administradorPermitir.getIdAdm();
        
        boolean permitirCriarNoticia = false;
        boolean permitirRevisar = false;
        boolean permitirAcesso = false;
        
        do {
            System.out.println(" ");
            System.out.println("Digite um número inteiro:");
            System.out.println("1 - Perfil");

            for (String s : listaIdJornalista) {
                if (s == usuario.getId()) {
                    permitirCriarNoticia = true;
                    break;
                }
            }

            for (String s : listaIdEditorChefe) {
                if (s == usuario.getId()) {
                    permitirRevisar = true;
                    break;
                }
            }
                
            for (String s : listaIdAdministrador) {
                if (s == usuario.getId()) {
                	permitirAcesso = true;
                    break;
                }
            }


            System.out.println("2 - Listar Notícia(Interagir com Like e Comentário)");

            if (permitirCriarNoticia){
                System.out.println("3 - Criar Notícia");
            }

            if (permitirRevisar){
                System.out.println("4 - Revisar notícias");
            }

            if (permitirAcesso){
                System.out.println("5 - Liberar acesso");
            }
            
            System.out.print("Digite o número: ");
            try {
                opcaoAvancar = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro!");
            }

            if (opcaoAvancar == 3 && !permitirCriarNoticia ){
                opcaoAvancar = 10;
            }

            if (opcaoAvancar == 4 && !permitirRevisar ){
                opcaoAvancar = 10;
            }

        switch (opcaoAvancar) {
            case 1:
                int opcaoPerfil = -1;
                do {
                    System.out.println(" ");
                    System.out.println("Digite um número inteiro:");
                    System.out.println("1 - Digitar nome");
                    System.out.println("2 - Escolher plano");
                    System.out.println("3 - Tipo de conta");
                    System.out.println("4 - Notícias salvas");
                    System.out.print("Digite o número: ");
                    try {
                        opcaoPerfil = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro!");
                    }
                } while (opcaoPerfil != 1 && opcaoPerfil != 2 && opcaoPerfil != 3 && opcaoPerfil != 4);
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
                    case 3:

                        int opcaoTipoConta = -1;
                        do {
                            System.out.println(" ");
                            System.out.println("Escolha o tipo de conta:");
                            System.out.println("1 - Administrador");
                            System.out.println("2 - Jornalista");
                            System.out.println("3 - Editor chefe");
                            System.out.println("4 - Voltar/manter como usuário");
                            System.out.print("Digite o número: ");
                            try {
                                opcaoTipoConta = Integer.parseInt(in.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Erro!");
                            }
                        } while (opcaoTipoConta != 1 && opcaoTipoConta != 2 && opcaoTipoConta != 3 && opcaoTipoConta != 4);

                        if (opcaoTipoConta == 1){
                            System.out.println("Solicitação para tornar Administrador solicitada...");
                        } else if(opcaoTipoConta == 2){
                            System.out.println("Solicitação para tornar Jornalista solicitada...");
                        } else if(opcaoTipoConta == 3){
                            System.out.println("Solicitação para tornar Editor chefe solicitada...");
                        }else {
                            System.out.println("Voltando...");
                            break;
                        }

                        break;
                    case 4:
                   	   System.out.println("---------------------------------------");
                    	List<Noticia> listaNoticiaSalva = usuario.getNoticiaSalva(); 
                    	for (int i = 0; i < listaNoticiaSalva.size(); i++) {
                    		System.out.println(" ");
                    		System.out.println(i+1 + " - Titulo: " + listaNoticiaSalva.get(i).getTitulo() + " - Conteúdo: " + listaNoticiaSalva.get(i).getConteudo());
                     	    System.out.println("Curtidas: " + listaNoticiaSalva.get(i).getCurtidas());
                     	    System.out.println(" ");
                     	    System.out.println("---------------------------------------");
						}
                    	break;
                }
                break;
            case 2:
               System.out.println("2 -- Listar Notícia(Interagir com Like e Comentário)");
               int j = 1;
        	   System.out.println(" ");
        	   System.out.println("---------------------------------------");
        	   System.out.println(" ");

               List<Noticia> listaNoticiaTeste = editorChefe2.getNoticiasPublicadas();

               if (listaNoticiaTeste == null) {
                   System.out.println("Sem notícias!");
                   break;
               }
               for(Noticia i : listaNoticiaTeste) {
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
            		   System.out.println((usuario.getNome() != null ? usuario.getNome() : "Visitante") + " - " + i.getComentarios().get(k));
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
			} while (opcaoInteragir > listaNoticiaTeste.size() || opcaoInteragir < 0);
               int opcaoCurtirComentar = -1;
               System.out.println("Escolha o número da opção que deseja efetuar: ");
               System.out.println("1 - Curtir");
               System.out.println("2 - Comentar");
               System.out.println("3 - Salvar");
               try {
            	   opcaoCurtirComentar = Integer.parseInt(in.nextLine());
               } catch (NumberFormatException e) {
                   System.out.println("Erro!");
               }               
               switch (opcaoCurtirComentar) {
	               case 1:
	            	Noticia objetoNoticia = listaNoticiaTeste.get(opcaoInteragir -1);
					objetoNoticia.setCurtidas(objetoNoticia.getCurtidas()+1);
					System.out.println("Quantidade de curtidas: " + objetoNoticia.getCurtidas());
                       listaNoticiaTeste.set(opcaoInteragir-1, objetoNoticia);
					break;
					case 2:
		            Noticia objetoComentar = listaNoticiaTeste.get(opcaoInteragir -1);
		            String comentario;
					System.out.print("Escreva seu comentário: ");
					comentario = in.nextLine();
					List<String> listaComentarios = objetoComentar.getComentarios();
					listaComentarios.add(comentario);
					objetoComentar.setComentarios(listaComentarios);
                    listaNoticiaTeste.set(opcaoInteragir-1, objetoComentar);
					break;
					case 3:
					List<Noticia> listNoticiaSalvaUsuario = usuario.getNoticiaSalva();
					listNoticiaSalvaUsuario.add(listaNoticiaTeste.get(opcaoInteragir -1));
					usuario.setNoticiaSalva(listNoticiaSalvaUsuario);
					break;
			}
               break;
            case 3:
                Noticia noticia = new Noticia();
                System.out.println("3 -- Criar Notícia");
                System.out.print("Digite o título: ");
                String inputTitulo = in.nextLine();
                noticia.setTitulo(inputTitulo);
                System.out.print("Digite o conteúdo: ");
                String inputConteudo = in.nextLine();
                noticia.setConteudo(inputConteudo);
                listaNoticias.add(noticia);
                noticia.setComentarios(new ArrayList<>());
                editorChefe2.setNoticiasParaRevisar(listaNoticias);
                jornalista2.setNoticiasProduzidas(listaNoticias);
                System.out.print("Notícia cadastrada com sucesso!");
                break;
            case 4:
                List<Noticia> listaNoticiasParaRevisar = editorChefe2.getNoticiasParaRevisar();
                System.out.println("Revisar notícias");
                int opcaoRevisar = -1;
                for (int i = 0; i < listaNoticiasParaRevisar.size(); i++) {
	                System.out.println(listaNoticiasParaRevisar.get(i).getTitulo());
	                System.out.println(listaNoticiasParaRevisar.get(i).getConteudo());
	                do {
	                    System.out.println("1 - Aprovar");
	                    System.out.println("2 - Reprovar");
	                    System.out.print("Digite um número inteiro: ");
	                    try {
	                        opcaoRevisar = Integer.parseInt(in.nextLine());
	                    } catch (NumberFormatException e) {
	                        System.out.println("Erro!");
	                    }
	                } while (opcaoRevisar != 1 && opcaoRevisar != 2);

                    if (opcaoRevisar == 1){
                        List<Noticia> listaPublicadas = editorChefe2.getNoticiasPublicadas() == null ? new ArrayList<Noticia>() : editorChefe2.getNoticiasPublicadas();
                        listaPublicadas.add(listaNoticiasParaRevisar.get(i));
                        editorChefe2.setNoticiasPublicadas(listaPublicadas);
                        listaNoticiasParaRevisar.remove(i);
                        editorChefe2.setNoticiasParaRevisar(listaNoticiasParaRevisar);
                    } else {
                        listaNoticiasParaRevisar.remove(i);
                    }
                }

                break;
            case 5:
                List<String> listaAcessosParaLiberar = administrador2.getAcessosParaLiberar();
                System.out.println("Liberar acesso");
                int opcaoLiberarAcesso = -1;
                for (int i = 0; i < listaAcessosParaLiberar.size(); i++) {
                    System.out.println(listaAcessosParaLiberar.get(i));
                    do {
                        System.out.println("1 - Liberar");
                        System.out.println("2 - Não Liberar");
                        System.out.print("Digite um número inteiro: ");
                        try {
                        	opcaoLiberarAcesso = Integer.parseInt(in.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Erro!");
                        }
                    } while (opcaoLiberarAcesso != 1 && opcaoLiberarAcesso != 2);

                    if (opcaoLiberarAcesso == 1){
                        List<String> listaLiberada = administrador2.getAcessosLiberados() == null ? new ArrayList<String>() : administrador2.getAcessosLiberados();
                        listaLiberada.add(listaAcessosParaLiberar.get(i));
                        administrador2.setAcessosLiberados(listaLiberada);
                        listaAcessosParaLiberar.remove(i);
                        administrador2.setAcessosParaLiberar(listaAcessosParaLiberar);
                        i--;
                    } else {
                    	listaAcessosParaLiberar.remove(i);
                    	i--;
                    }
                }
                 break; 
        }
  }while (opcaoAvancar != 0);
}}

