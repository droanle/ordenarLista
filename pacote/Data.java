package pacote;
import java.util.ArrayList;

public class Data {

  // Guarda o nome das opções de votos
  private ArrayList<String> listaDeItens_nome = new ArrayList<String>();

  // Guarda os votos em cada opções de voto
  private ArrayList<Integer> listaDeItens_vote = new ArrayList<Integer>();

  public Data(){
    // Define as opções de voto que estariam no ranking
    addItem("Leandro");
    addItem("Marcelo");
    addItem("Dheniylsom");
    addItem("Tioril ");
    addItem("Dedor  ");
    addItem("Kofob  ");
    addItem("Xizue  ");

    // Vota 3 vezes no "Leandro"
    vote(0);
    vote(0);
    vote(0);

    // Vota 5 vezes no "Marcelo"
    vote(1);
    vote(1);
    vote(1);
    vote(1);
    vote(1);

    // Vota 4 vezes no "Kofob"
    vote(5);
    vote(5);
    vote(5);
    vote(5);

    // Vota 4 vezes no "Dedor"
    vote(4);
    vote(4);

    vote(6);
  }
  
  public void addItem(String nome){
    listaDeItens_nome.add(nome);
    listaDeItens_vote.add(0);
  }

  public void vote(int posicao){
    listaDeItens_vote.set(posicao, (
      listaDeItens_vote.get(posicao) + 1
    ));
  }

  public String getItemName(int posicao){
    return listaDeItens_nome.get(posicao);
  }

  public Integer getItemVote(int posicao){
    return listaDeItens_vote.get(posicao);
  }

  public ArrayList<Integer> getArrayList(){
    return listaDeItens_vote;
  }
}