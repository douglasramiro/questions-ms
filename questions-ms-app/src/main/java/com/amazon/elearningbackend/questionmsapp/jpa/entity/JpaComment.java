package com.amazon.elearningbackend.questionmsapp.jpa.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "TBL_COMMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JpaComment {

    @Id
    private String id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne(optional = false)
    private JpaQuestion question;

}
