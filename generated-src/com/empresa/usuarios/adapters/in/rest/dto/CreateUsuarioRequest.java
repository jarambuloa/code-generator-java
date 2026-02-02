
package com.empresa.usuarios.adapters.in.rest.dto;

public class CreateUsuarioRequest {


    private String username;

    private String email;


    public CreateUsuarioRequest() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
