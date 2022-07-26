import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        

        // fazer uma conexão HTTP E BUSCAR OS TOP 250 filmes

        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body); imprime o json inteiro (dados brutos)


        // extrair os dados importantes (titulo, poster, e nota) "Parsear"

         var parser = new JsonParser(); //colocando o objeto (referencia) na variável parser
         List<Map<String, String>> listaDeFilmes = parser.parse(body);
            // System.out.println(listaDeFilmes.get(0)); imprime o dado bruto de um item da lista

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }


    }
}
