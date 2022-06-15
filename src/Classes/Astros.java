package Classes;


//AstroJson ATIVIDADE AVALIATIVA PROGRAMACAO E SOLUCAO COMPUTACIONAIS, UNIFACS
//PROFESSOR: ARTUR HENRIQUE KRONBAUER
//
//AUTOR:PEDRO AZEVEDO DE QUEIROZ  RA: 1272123228

//v.1.01.l.alpha
public class Astros {
    /*
    Bloco de variaveis que formarao o metodo construtor desta classe
*/
protected String nome, ctg;
protected int idAstro;
protected boolean risco = false; // Checagem de risco do asteroide ter risco de colisao necessitando uma observacao maior
protected boolean cauda = false;
public Astros (String nome, String ctg, int idAstro, boolean risco, boolean cauda) { 
    this.nome = nome;
    this.ctg = ctg;
    this.cauda = cauda;
    this.idAstro = idAstro;
    this.risco = risco;
    
}
//m�todo implementado para marcar o asteroide como em rota de colisao
public boolean asteroideColide () {
    return risco = true;
}
//funcao para imprimir os dados dos Asteroides
public void imprimir() { 
    System.out.print("\nNome:\n "+ nome);
    System.out.print("\nCategoria: \n"+ ctg);
    System.out.print("\nCodigo de ID do Asteroide: \n"+ idAstro);
    System.out.print("\nO asteroide possui algum risco de colisao?:\n "+ risco);
    System.out.print("\nO Asteroide possui cauda observada?\n" + cauda);
   
}

//Abaixo, conjunto de Getters e Setters de todos os atributos criados
public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCtg() {
    return ctg;
}

public void setCtg(String ctg) {
    this.ctg = ctg;
}

public int getIdAstro() {
    return idAstro;
}
public void setIdAstro(int idAstro) {
    this.idAstro = idAstro;
}
public void setRisco(boolean risco) {
    this.risco = risco;
}
public boolean getRisco() {
    return risco;
}

public boolean getCauda() {
    return cauda;
}
public void setCauda(boolean cauda) {
    this.cauda = cauda;
}

}