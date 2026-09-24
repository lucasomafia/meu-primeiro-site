package com.example.RestAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clima")
public class ApiController {
    private ApiService apiService;

    public ApiController(ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping
    public String buscarClima(@RequestParam double latitude,@RequestParam double longitude){
        return apiService.buscarClima(latitude,longitude);
    }
    @GetMapping("/bh")
    public String climaBH(){
        return apiService.climaBH();
    }
    @GetMapping ("/{cidade}")
    public String buscarCidade(@PathVariable String cidade) throws Exception{
        return apiService.buscarCidade(cidade);
    }
}

