package com.kamoun.gestiondestock.config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//@Configuration

public class FlickConfiguration {
    @Value("${flicker.apikey}")
    private String apiKey;
    @Value("${flicker.apiSecret}")
    private String apiSecret;
    @Value("${flicker.appkey}")
    private String appKey;
    @Value("${flicker.appSecret}")
    private String appSecret;

    /*  public Flickr getFlickr() throws IOException, ExecutionException, InterruptedException, FlickrException {
          Flickr flickr = new
                  Flickr(apiKey, apiSecret, new REST());

          OAuth10aService service = new ServiceBuilder(apiKey).apiSecret(apiSecret)
                  .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));

          final Scanner scanner = new Scanner(System.in);

          final OAuth1RequestToken request = service.getRequestToken();

          final String authUrl = service.getAuthorizationUrl(request);
          System.out.println(authUrl);
          System.out.println("Paste it here >> ");

          final String authVerifier = scanner.nextLine();

          OAuth1AccessToken accessToken = service.getAccessToken(request, authVerifier);

          System.out.println(accessToken.getToken());
          System.out.println(accessToken.getTokenSecret());

          Auth auth = flickr.getAuthInterface().checkToken(accessToken);

          System.out.println("---------------------------");
          System.out.println(auth.getToken());
          System.out.println(auth.getTokenSecret());

          return flickr;
      }*/
    @Bean
    public Flickr getFilck() {
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
        return flickr;
    }

}
