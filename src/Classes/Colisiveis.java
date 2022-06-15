package Classes;


//AstroJson ATIVIDADE AVALIATIVA PROGRAMACAO E SOLUCAO COMPUTACIONAIS, UNIFACS
//PROFESSOR: ARTUR HENRIQUE KRONBAUER
//
//AUTOR:PEDRO AZEVEDO DE QUEIROZ  RA: 1272123228


//v.1.01.l.alpha
public class Colisiveis extends Astros{ //classe de Asteroides Colisiveis que herda atributos e metodos da classe Astros com o comando 'extends'
    // os atributos propris dos Colisiveis
    protected int veloM;
    protected int posicaoE;
    protected boolean riscoTerra = false; // novo boolean definindo o risco de a colisao afetar a terra ou de atingir ela definindo como falso
    //metodo construtor da classe. comando'super()' usado para definir quais os atributos que sao herdados da classe pai 'Astros',o que e obrigatorio para iniciar esse tipo de Classe
    
    public Colisiveis(String nome, String ctg, int idAstro, boolean risco, boolean cauda, int veloM, int posicaoE, boolean riscoTerra) {
        super(nome, ctg, idAstro, true, cauda); // atributos super da classe pai Astros juntamente como definido que para ser da classe Colisiveis o risco tem q ser true
        this.veloM = veloM;
        this.posicaoE = posicaoE;
        this.riscoTerra = riscoTerra;
    }
    
    //polimorfando o `imprimir()`  da classe Astros
    public void imprimir() {
        super.imprimir();
        System.out.print("\nA velocidade media estimada do corpo celeste e de(em 1000km/s: "+ veloM);
        System.out.print("\nA distancia estimada do Asteroide, em relacao a terra, e de(em 100000km): "+ posicaoE);
        System.out.print("\nO Asteroide possui risco de colidir com o planeta Terra ou colidir com outro corpo celeste e afeta-la?"+ riscoTerra);   
    }
  //metodo implementado para marcar o  asteroide  como  em risco de colisao com a terra ou risco de afetar ela em colisao
    public boolean colisaoTerra() {
        return riscoTerra = true;
    }
    //conjunto de Getters e Setters dos atributos criados dentro dessa classe
    public int getVeloM() {
        return veloM;
    }

    public void setVeloM(int veloM) {
        this.veloM = veloM;
    }

    public int getPosicaoE() {
        return posicaoE;
    }

    public void setPosicaoE(int posicaoE) {
        this.posicaoE = posicaoE;
    }
    public void setRiscoTerar(boolean riscoTerra) {
        this.riscoTerra = riscoTerra;
    }
    public boolean getRiscoTerra() {
        return riscoTerra;
    }
    //metodos get para os super so em caso necessidade do sistema em futuras versoes otimizadas
    public  String getSuperNome() {
		return nome;
	}
    
    public  String getSuperCtg() {
    	return ctg;
    }
    public  int getSuperIdAstro() {
    	return idAstro;
    }
    public  boolean getSuperRisco() {
    	return risco;
    }
    public  boolean getSuperCauda() {
    	return cauda;
    }
}
