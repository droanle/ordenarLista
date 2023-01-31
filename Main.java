import pacote.Data;


// olha que legal 
// https://codigosdascarinhas.blogspot.com/2014/12/face-carinhas-de-caracteres-letras-texto.html

class Main {
  private static Data dataRanking = new Data();

  public static void main(String[] args) {

    // O "relativeDataRanking" armazena os votos que foram feitos. ele é relativo
    // por que conforme a colocação é definida seu dados são alterados
    int[] relativeDataRanking = new int[dataRanking.getArrayList().size()];
    
    for (int i = 0; i < dataRanking.getArrayList().size(); i++)
      relativeDataRanking[i] = dataRanking.getItemVote(i);

    // Armazena a posição de exibição, basicamente é a variável que vc vai usar para
    // saber a colocação (1º, 2º, 3º...]) dos itens do Ranking
    int[] rankedDataRanking = new int[dataRanking.getArrayList().size()];

    // Armazena a posição com maior voto em cada loop
    int highestPosition = 0;

    // Percorre todas as posições de voto
    for (int i = 0; i < relativeDataRanking.length; i++) {
      highestPosition = 0;

      // Percorre todas as posições de voto, obtem a maior e atribui a
      // "highestPosition"
      for (int e = 0; e < relativeDataRanking.length; e++)
        if (relativeDataRanking[e] > relativeDataRanking[highestPosition])
          highestPosition = e;

      // armazena a posição do item mais votado desse loop
      rankedDataRanking[i] = highestPosition;

      // Como esse item já havia recebido uma colocação (ação na linha anterior),
      // agora ele não precisa mais ser considerado, por isso eu atribuo "-1" de votos
      // a ele já que em um sistema de ranking não pode atribuir um voto negativo.
      // OBS: eu não posso adicionar "0" (ou seja 0 votos) porque é um valor que um
      // item do ranking pode ter então ele receberia mais de uma posição entre os que
      // também tiveram 0 votos, já o "-1" não é considerado por estar fora do limite
      // de valores que um sistema de rankings define naturalmente.
      relativeDataRanking[highestPosition] = -1;
    }

    // Mostra a colocação (pódio). Considere:
    //     1º, 2º e 3º = primeiro, segundo e terceiro
    //     (〒﹏〒)     = qualquer item que não esteja no pódio de votação;
    for (int i = 0; i < rankedDataRanking.length; i++) {

      String nome = dataRanking.getItemName(rankedDataRanking[i]);
      Integer votos = dataRanking.getItemVote(rankedDataRanking[i]);

      if (i == 0) {
        System.out.println("   1º    - " + nome + " com " + votos + " votos");
      } else if (i == 1) {
        System.out.println("   2º    - " + nome + " com " + votos + " votos");
      } else if (i == 2) {
        System.out.println("   3º    - " + nome + " com " + votos + " votos");
      } else {
        System.out.println("(〒﹏〒) - " + nome + " com " + votos + " votos");
      }
    }

  }
}