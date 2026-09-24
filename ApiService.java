package com.example.RestAPI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;


@Service 
public class ApiService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private RestClient restClient = RestClient.create();

    public String buscarClima(double latitude,double longitude){
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +"&current=temperature_2m,wind_speed_10m";
        String clima = restClient.get()
        .uri(url)
        .retrieve()
        .body(String.class);
        return clima;
    }
    public String climaBH(){
        String clima = restClient.get()
        .uri("https://api.open-meteo.com/v1/forecast?latitude=-19.9167&longitude=-43.9345&current=temperature_2m,wind_speed_10m")
        .retrieve()
        .body(String.class);
        return clima;
    }
    public String buscarCidade(String cidade) throws Exception{
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + cidade + "&count=1&language=pt&format=json";
        String clima = restClient.get()
        .uri(url)
        .retrieve()
        .body(String.class);
        JsonNode json = objectMapper.readTree(clima);
    
        double latitude = json.get("results").get(0).get("latitude").asDouble();
        double longitude = json.get("results").get(0).get("longitude").asDouble();
        
        String url2 = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude="+ longitude + "&current=temperature_2m,wind_speed_10m";
        String resultado = restClient.get()
        .uri(url2)
        .retrieve()
        .body(String.class);
        return resultado;


    }
    
}
        