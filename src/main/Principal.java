package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Classes.Astros;
import Classes.Colisiveis;

//AstroJson ATIVIDADE AVALIATIVA PROGRAMACAO E SOLUCAO COMPUTACIONAIS, UNIFACS
//PROFESSOR: ARTUR HENRIQUE KRONBAUER
//
//AUTOR:PEDRO AZEVEDO DE QUEIROZ  RA: 1272123228

//v.1.01.2.alpha
//flow-flux futuro ao fim.

//dando inicio a classe Princpal em metodo main para poder ser executada com os args
public class Principal {
    public static void main (String[] args) {
        //Array que armazena todas as inst�ncias de objetos criados
        ArrayList<Astros> listaAsteroides= new ArrayList<Astros>();
        //variavel de controle <opcao de menu> e de codigo de cadastro do na Array
        int opcao, codCad;
        
        // instancia de 7 asteroides e os insere no ArrayList, conforme solicitado no escopo do trabalho, sendo: sendo dos 7 Asteroides, 3 Colisiveis.
        Colisiveis colide1, colide2, colide3;
        Astros asteroide1, asteroide2, asteroide3, asteroide4,asteroide5, asteroide6, asteroide7, asteroide8;
        colide1 = new Colisiveis("DoomsDay", "S", 44580, true, true, 5000, 1500000, true);
        listaAsteroides.add(colide1);
        colide2 = new Colisiveis("Kalopsys", "M", 880050, true, false, 8000, 8000000, false);
        listaAsteroides.add(colide2);
        colide3 = new Colisiveis("Aspergos", "C", 1258, true, true, 850, 800000000, false);
        listaAsteroides.add(colide3);
        asteroide1 = new Astros("DoomsDay", "S", 44580, true, false);
        listaAsteroides.add(asteroide1);
        asteroide2 = new Astros("Kalopsys", "M", 880050, true,false);
        listaAsteroides.add(asteroide2);
        asteroide3 = new Astros("Aspergos", "C", 1258, true,false);
        listaAsteroides.add(asteroide3);
        asteroide4 = new Astros("Lepard", "S", 1595, false,true);
        listaAsteroides.add(asteroide4);
        asteroide5 = new Astros("Yondur", "S", 1595, false,false);
        listaAsteroides.add(asteroide5);
        asteroide6 = new Astros("Mjolnir", "C", 1595, false,false);
        listaAsteroides.add(asteroide6);
        asteroide7 = new Astros("TheLegend1337", "S", 1337, false,false);
        listaAsteroides.add(asteroide7);
        asteroide8 = new Astros("Betina1M", "C", 1000000, false,true);
        listaAsteroides.add(asteroide8);
        // menu de navega�ao do sistema
        do {
            //instancia o objeto Scanner com o nome 'input'            
			Scanner input = new Scanner(System.in); 
            System.out.print("\n==== MENU =====\n");
            System.out.print("\n1- Cadastrar novo Asteroide\n");
            System.out.print("\n2- Remover Asteroide\n");
            System.out.print("\n3- Listar os Asteroides\n");
            System.out.print("\n4- Procurar Asteroides por ID e ver todas suas informacoes \n");
            System.out.print("\n5- Registrar rota de colisao para Asteroide existente\n");
            System.out.print("\n6- Sair\n");
            System.out.print("\nEscolha uma opcao do menu acima: \n");
            //recebe a opcao do input seguinte do usuario
            opcao = input.nextInt(); 
            //estrutura condicional usada para realizar a acao solicitada pelo usuario no menu anterior
            switch(opcao) {
                //Funcao para cadastro de Asteroide
                case 1:                
                	listaAsteroides.add(cadastrar());
                    break;
                //Funcao para remocao de Asteroides
                case 2:
                    System.out.print("\nInforme o codigo de cadastro do Asteroide que deseja remover:\n ");
                    codCad = input.nextInt();
                    remover(listaAsteroides, codCad);
                    break;
                //Funcao para listar os Asteroides cadastrados com 3 atributos apenas como requisitado
                case 3:
                    listarAstros(listaAsteroides);
                    break;
                //Funcao para pesquisar dentro da lista de Asteroides usando o codCad igualando essa variavel com o ID do Asteroide, ao imprimir, 
                //todos os dados de cada asteroide procurado serao impressos na tela    
                case 4:
                    System.out.print("\nInforme o ID do Asteroide que deseja pesquisar: \n");
                    codCad = input.nextInt();
                    filtro(listaAsteroides, codCad);
                    break;
                //Coloca o Asteroide selecionado como colisivel
                case 5:
                //Aviso de como se da5
                    int opcao2;
                    System.out.print("\n-----------------------ATENCAO-----------------------\n");
                    System.out.print("\nPara cadastrar nova rota de colisao sera necessario o recadastro do Asteroide.\n");
                    System.out.print("\nCaso nao deseje alterar os dados e recomendado grava-los antes de prosseguir.");
                    System.out.print("\n-----------------[Digite 1 para CONTINUAR  | Digite 0 para CANCELAR]----------------\n");
                    opcao2 = input.nextInt();
                        if(opcao2 == 1){
                        System.out.print("\nInforme o ID do Asteroide para por ele como em rota de colisao (Apenas numeros inteiros)': \n");
                        codCad = input.nextInt();
                        for (int i = 0; i < listaAsteroides.size();) {
                            if (listaAsteroides.get(i).getIdAstro() == codCad) {
                                listaAsteroides.get(i).asteroideColide();
                        //remove o asteroide para poder reinseri-lo pois as vezes eh necessario alterar o tipo de categoria e ate mesmo o nome na ciencia
                        } remover(listaAsteroides, codCad);
                        // roda nova funcao de cadastro para reinstaciar e redesignar o asteroide como colisivel
                        listaAsteroides.add(cadastrar2());
                        System.out.print("\nNovo Asteroide foi registrado como Colisivel\n");
                        break;  
                            }
                            {
                        if(opcao2 ==2){
                            break;
                        }
                     break;
                            }
                            }

                     
                // Fim do programa
                case 6:
                    System.out.print("\n\nSaindo..");
                    break;   
                //Mensagem de erro caso seja inserida qualquer opcao de maneira incorreta, informando-o do fato
                default:
                    System.out.print("\nOpcao nao reconhecida!\n");
                        break;
            }
        }while (opcao != 6);// Condicao para fazer o programa rodar enquanto o usuario nao pedir para Sair dele com a opcao 6
    }

	//metodo do tipo Astros usado para realizar o cadastro de asteroides, conforme indicado
    public static Astros cadastrar () {
        //criacao de nova instancia do objeto Scanner, infelizmente nao podemos por suppress warning pra palavra 'input',
        // e declaracao de novas variaveis para controle e durante o processo de cadastro 
		Scanner input = new Scanner(System.in);
        int colisao;
        int terraopcao;
        int opcaocauda;
        boolean risco;
        boolean cauda;
        String nome, ctg;
        int idAstro;
        int veloM,posicaoE;
        boolean riscoTerra;
        Astros asteroide;
        Colisiveis colide;
        //Esta e a variavalve em boolean mais importante do codigo, pois define se o objeto pertence a classe pai ou filha
        //lembrando, que mesmo um Colisivel, nao deixa de ser Asteroide.
        System.out.print("\nO Asteroide possui rota de colisao? [Sim = 1/Nao = 0] ? \n");
        colisao = input.nextInt();
        //com base na resposta do usuario, faz o cadastro de Astros e/ou Colisiveis
            System.out.print("\nDesigne o nome do Asteroide: ");
            nome = input.next();
       //essa eh uma categorizacao REAL CONFORME OS PARAMETROS DA NASA, obviamente, de maneira mais simples, mas foi necessario para definir melhor o objeto     
            int resposta;
            String xString1 = null;
			System.out.print("\nPara categorizar o asteroide, obedeca os comandos a seguir:\n");
			System.out.print("\nSe o asteroide possui cor escura e baixa reflexividade da luz solar: Digite 1 para designa-lo a categoria C\n");
			System.out.print("\nSe o asteroide for composto de niquel-ferro e sao os que mais refletem a luz solar, Digite 2 para designa-lo a categoria M\n");
			System.out.print("\nSe o asteroide e mais claro e reflete melhor a luz do sol, o que caracteriza a sua luminosidade. Digite 3 para designa-lo a categoria S\n");
			resposta=input.nextInt();
			if(resposta == 1) {
				xString1 = "Categoria C";
				ctg = xString1;
			}
			if(resposta == 2) {
				xString1 = "Categoria M";
				ctg = xString1;
			}
			if(resposta == 3) {
				xString1 = "Categoria S";
				ctg = xString1;
			}
			
			ctg = xString1;
        	
        //o ID deve ser em inteiro, pois ele sera usado como meio de busca na array depoois		
            System.out.print("\nAgora informe o ID de registro do Asteroide(Apenas numeros inteiros):\n");
            idAstro = input.nextInt();
            System.out.print("\nFoi observada a presenca da 'cauda' no asteroide? [Sim = 1/Nao = 0]\n");
            opcaocauda = input.nextInt();
            	if(opcaocauda != 0) {
        		cauda = true;
            	}else {
        		 cauda = false;
            	}
        if (colisao == 0) {
            //instancia um objeto da classe Astros
        	risco = false;
        	asteroide = new Astros(nome, ctg, idAstro, risco, cauda);
            System.out.print("\n\nCadastro de Asteroide realizado!\n");
            System.out.print(asteroide);
            return asteroide;
            
            
        }else {
        	//instancia um objeto a classe Astros com mais alguns atributos ocultos que so mostrarao em busca pelo ID dele.
        	risco = true;
            System.out.print("\nInforme a velocidade media estimada do corpo celeste em 1000km/s:(Apenas numeros inteiros)\n");
            veloM = input.nextInt();
            System.out.print("\nQual distancia estimada do Asteroide, em relacao a terra, em 100000km:(Apenas numeros inteiros)\n");
            posicaoE = input.nextInt();
            
            System.out.print("\n O asteroide possui rota de colisao com a terra ou de afetala com sua colisao?[Sim = 1/Nao = 0]\n");
            terraopcao = input.nextInt();
            	if(terraopcao == 1) {
            		riscoTerra = true;
            	}else {
            		riscoTerra = false;
            	}
            //instancia um objeto da classe Asteroides Colisiveis
            colide = new Colisiveis(nome, ctg, idAstro, risco, cauda, veloM, posicaoE, riscoTerra);
            System.out.print("\n\nCadastro de Asteroide em rota de colisao realizado!\n");
            
            return colide;
            
        } 
    }
    //metodo e/ou funcao para recadastrar o asteroide existente como colisivel apos remove-lo.
    public static Astros cadastrar2() {
        //criacao de nova instancia do objeto Scanner, infelizmente nao podemos por suppress warning pra palavra 'input', e declaracao de novas variaveis para controle e uso
    	//durante o processo de cadastro 
		Scanner input = new Scanner(System.in);
        int colisao;
        int terraopcao;
        int opcaocauda;
        boolean risco;
        boolean cauda;
        String nome, ctg;
        int idAstro;
        int veloM,posicaoE;
        boolean riscoTerra;
        //Apenas usando a variavel para que o programa reconheca os supers de maneria mais rapida com a heranca
        Astros asteroide;
        Colisiveis colide;
        //Nesta nova funcao de cadastro a variavel de risco eh TRUE, pois define que o objeto pertence a classe filha
        //lembrando, que mesmo um Colisivel, nao deixa de ser Asteroide.
       
        colisao = 1;
        //Nesta nova funcao a colisao sera sempre 1 pois estamos reinserindo o Asteroide como Colisivel na Array
            System.out.print("\nReinsira o nome do Asteroide: ");
            nome = input.next();
       //essa eh uma categorizacao REAL CONFORME OS PARAMETROS DA NASA, obviamente, de maneira mais simples, mas foi necessario para definir melhor o objeto     
            int resposta;
            String xString1 = null;
			System.out.print("\nPara recategorizar o asteroide, obedeca os comandos a seguir:\n");
			System.out.print("\nSe o asteroide possui cor escura e baixa reflexividade da luz solar: Digite 1 para designa-lo a categoria C\n");
			System.out.print("\nSe  o asteroide for composto de nquel-ferro e sao os que mais refletem a luz solar, Digite 2 para designa-lo a categoria M\n");
			System.out.print("\nSe o asteroide e mais claro e reflete melhor a luz do sol, o que caracteriza a sua luminosidade. Digite 3 para designa-lo a categoria S\n");
			resposta=input.nextInt();
			if(resposta == 1) {
				xString1 = "Categoria C";
				ctg = xString1;
			}
			if(resposta == 2) {
				xString1 = "Categoria M";
				ctg = xString1;
			}
			if(resposta == 3) {
				xString1 = "Categoria S";
				ctg = xString1;
			}
			
			ctg = xString1;
        	
        //o ID deve ser em inteiro, pois ele sera usado como meio de busca na array depoois		
            System.out.print("\nAgora informe o novo ID de registro do Asteroide(Apenas numeros inteiros):\n");
            idAstro = input.nextInt();
            System.out.print("\nFoi observada a presenca da 'cauda' no asteroide? [Sim = 1/Nao = 0]\n");
            opcaocauda = input.nextInt();
            	if(opcaocauda != 0) {
        		cauda = true;
            	}else {
        		 cauda = false;
            	}
        if (colisao == 0) {
            //Erro no sistema ao tentar recadastrar o Asteroide como Colisiveis ao inves de Astros
            // Apenas mantive a funcao para poder rodar como instanciando a classe Astros.3

        	System.out.print("\n Houve um erro no cadastro da rota de colisao");
            return asteroide = new Astros(nome, ctg, idAstro, risco=false, cauda);
            
            
        }else {
        	//instancia um objeto a classe Astros com mais alguns atributos ocultos que so mostrarao em busca pelo ID dele.
        	risco = true;
            System.out.print("\nInforme a velocidade media estimada do corpo celeste em 1000km/s:(Apenas numeros inteiros)\n");
            veloM = input.nextInt();
            System.out.print("\nQual distancia estimada do Asteroide, em relacao a terra, em 100000km:(Apenas numeros inteiros)\n");
            posicaoE = input.nextInt();
            
            System.out.print("\n O asteroide possui rota de colisao com a terra ou de afetala com sua colisao?[Sim = 1/Nao = 0]\n");
            terraopcao = input.nextInt();
            	if(terraopcao == 1) {
            		riscoTerra = true;
            	}else {
            		riscoTerra = false;
            	}
            //instancia um objeto da classe Asteroides Colisiveis
            colide = new Colisiveis(nome, ctg, idAstro, risco, cauda, veloM, posicaoE, riscoTerra);
            System.out.print("\n\nCadastro de Asteroide em rota de colisao realizado!\n");
            
            return colide;
            
        } 
    }



    //metodo do tipo 'void()' que lista todos os Asteroides, Case 3. nesse caso recebe-se como parametro o ArrayList do tipo Astros
    public static void listarAstros (ArrayList<Astros> listaAsteroides) {
        // imprime os dados dos asteroides com 3 atributos reais, e o boolean de risco, que determina se colisivel ou nao. necessaria sua exposicao na listagem
    	// pois se nao ficaria incrivelmente dificil uma pessoa buscar informacoes sobre um asteroide colisivel, ele teria que buscar em um por um neste codigo
    	// de acordo com a funcao filtro
        System.out.print("\nLista de Asteroides com seus atributos)\n");
        for (int i = 0; i < listaAsteroides.size(); ++i) {      	
            System.out.println("\n\nAsteroide: "+ (i+1));
            System.out.print("\nNome: "+ listaAsteroides.get(i).getNome());
            System.out.print("\nID: \n"+ listaAsteroides.get(i).getIdAstro());
            System.out.print("\nCategoria: \n"+ listaAsteroides.get(i).getCtg());
            System.out.print("\n Possui rota de colisao\n?" + listaAsteroides.get(i).getRisco());
            }
    }
     	   
	//metodo do tipo 'void()' que busca, com base em seu ID, um Asteroide e imprime os seus atributos ,
    // chamando o metodo 'imprimir()' criado inicialmente na classe pai
    public static void filtro (ArrayList<Astros> listaAsteroides, int codCad) {
        boolean achouAsteroide = false; //Verifica se o asteroide existe
        for (int i = 0; i < listaAsteroides.size(); ++i) {
            //estrutura condicional usada para verificar se o codigo de cadastro informado para a busca existe 
            //e, existindo, devolve os atributos impressos na tela ou informa que o asteroide nao foi encontrado 
            if(listaAsteroides.get(i).getIdAstro() == codCad) {
            	listaAsteroides.get(i).imprimir();
                achouAsteroide = true;
                    break;
            }
        }
        if(achouAsteroide == false) {
            System.out.print("\nAsteroide NAO ENCONTRADO\n");
        }
    }
    
    //metodo  usado para remover cadastros de Astros do sistema. Recebe como parametro um ArrayList do tipo asteroide, com todos os asteroides cadastrados,
    //e um codigo de cadastro passado como sendo o do asteroide que queremos remover
    public static void remover (ArrayList<Astros> listaAsteroides, int codCad) {
         //Flag que verifica se o asteroide existe
        boolean achouAsteroide = false;
        //Estrutura condicional usada para verificar se o asteroide foi achado ou nao. Caso seja, ele sera removido, caso nao, 
        //sera impressa mensagem na tela informando que nao foi encontrado
        for (int i = 0; i < listaAsteroides.size(); ++i) {
            if (listaAsteroides.get(i).getIdAstro() == codCad) {
                achouAsteroide = true;
                listaAsteroides.remove(i);
                
                System.out.print("\nAsteroide REMOVIDO");
            }
        }
        if (achouAsteroide == false) {
            System.out.print("\nAsteroide nao encontrado para ser removido!\n");
        }
    }

    
}

//to-do nas proximas versoes:
//Criar interface inicial de login e senha, com jre talvez
// criar classe usuario para tale distinguir entre lider de equipe de observacao, e componentes desta
// 
//implementacao de bdd sql para maior quantidade de alocacao de asteroides e melhor gerenciamento em tabelas assim como 
//as infos e senhas de login
//seria o fim do patch 1.2
//A necessidade deste codigo seria apenas para uma equipe pequena de um escopo de observacao fixo e "finito", como uma galaxia so, talvez

//patch 2.0
// por fim, darei continuidade ao desenvolvimento deste software como um dashboard de asteroides que pode ser acessado pelo publico

// adicionando lista de asteroides favoritos, galaxias favoritas, notificacoes com interporabilidade e integracoes de api para notificar ate mesmo no celular
// adicionar integracao com app mobile para notificao de eventos astrologicos favoritados e quando vao ocorrer, como eclipses, etc
// para os aficcionados em asteroides, acredito ser um produto viavel e que soma.