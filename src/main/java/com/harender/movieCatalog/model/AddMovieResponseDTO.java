package com.harender.movieCatalog.model;

public class AddMovieResponseDTO {
    private int statusCode;
    private String message;

    public AddMovieResponseDTO(String message, int responseCode) {
        this.message = message;
        this.statusCode = responseCode;
    }

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
