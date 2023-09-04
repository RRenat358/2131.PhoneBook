package ru.rrenat358.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.api.core.PhoneDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


/*
    @OneToMany
    @JoinTable(name = "clients_email",
            joinColumns = @JoinColumn(name = "clients_id"),
            inverseJoinColumns = @JoinColumn(name = "email_id"))
    private List<Email> emailList;

    @OneToMany
    @JoinTable(name = "clients_phone",
            joinColumns = @JoinColumn(name = "clients_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<Phone> phoneList;
*/


    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    public Client(Long id, String name) {

    }




}
