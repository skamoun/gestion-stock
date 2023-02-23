package com.kamoun.gestiondestock.services.Impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.kamoun.gestiondestock.services.FlickrService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@AllArgsConstructor
public class FlickrServiceImpl implements FlickrService {
    private final Flickr flickr;
    @Value("${flicker.apikey}")
    private String apiKey;
    @Value("${flicker.apiSecret}")
    private String apiSecret;
    @Value("${flicker.appkey}")
    private String appKey;
    @Value("${flicker.appSecret}")
    private String appSecret;

    @Override
    public String savePhoto(InputStream photo, String titre) throws FlickrException {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(titre);
        String photoId = flickr.getUploader().upload(photo, uploadMetaData);


        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }

}
