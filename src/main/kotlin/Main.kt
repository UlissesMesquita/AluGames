import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner


fun main(args: Array<String>) {


    val leitura = Scanner(System.`in`);
    println("Escolha o proximo id: ")
    leitura.nextLine()
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$leitura";

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build();

    val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())


    val json = response.body();
    val gson = Gson();

    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java);

    println(meuInfoJogo);



}