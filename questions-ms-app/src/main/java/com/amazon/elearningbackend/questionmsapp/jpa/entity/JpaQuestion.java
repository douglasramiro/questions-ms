package com.amazon.elearningbackend.questionmsapp.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_QUESTION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JpaQuestion {

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String userId;

    @OneToMany(mappedBy = "question")
    private List<JpaComment> comments;

}
