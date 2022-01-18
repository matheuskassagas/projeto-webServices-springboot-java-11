package springWeb.DTO.request;

import springWeb.repositoryJPA.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank @Size(min=8)
    private String password;
    @NotBlank @Size(max=11)
    private String phone;

    public UserRequest() {
    }

    public UserRequest(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User toModel (UserRequest userRequest){
        return new User(userRequest.getName(), userRequest.getEmail(), userRequest.getPassword(), userRequest.getPhone());
    }
}
