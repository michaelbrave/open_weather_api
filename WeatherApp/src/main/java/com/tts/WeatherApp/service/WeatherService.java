package com.tts.WeatherApp.service;

import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;
    @Autowired
    private ZipCodeRepository zipCodeRepository;

    public Response getForecast(String zipCode){
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        try{
            return restTemplate.getForObject(url, Response.class);
        }catch(HttpClientErrorException exception){
            Response response = new Response();
            response.setName("ERROR");
            return response;
        }
    }

    public ZipCode findByZipCode(String zip) {
        return zipCodeRepository.findByZipCode(zip);
    }

    public List<String> findMostRecent() {
        return zipCodeRepository.findMostRecent();
    }

    public void createZip(String zip) {
        ZipCode zipCode = new ZipCode();
        zipCode.setZipCode(zip);

        zipCodeRepository.save(zipCode);
    }
}