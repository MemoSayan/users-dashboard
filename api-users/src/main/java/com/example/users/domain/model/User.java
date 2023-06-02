package com.example.users.domain.model;



import com.example.users.domain.base.EntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "users_validated")
public class User extends EntityBase {

    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;
    @NotEmpty
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    @Email
    private String email;

    @Column(name = "job_title")
    private String jobTitle;
    @Size(min = 5, max = 10)
    private String phone;

    private String token;

}
