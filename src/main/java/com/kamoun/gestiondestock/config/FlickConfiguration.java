package com.kamoun.gestiondestock.config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@Configuration

public class FlickConfiguration {
    @Value("${flicker.apikey}")
    private String apiKey;
    @Value("${flicker.apiSecret}")
    private String apiSecret;

    public Flickr getFlickr() throws IOException, ExecutionException, InterruptedException {
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());

        OAuth10aService service = new ServiceBuilder(apiKey)
                .apiSecret(apiSecret)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));
        final Scanner scanner = new Scanner(System.in);
        final OAuth1RequestToken request = service.getRequestToken();
        final String authUrl = service.getAuthorizationUrl(request);
        return flickr;
    }
}
