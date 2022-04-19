package com.endava.web.app.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @Column(name = "NAME")
    private String departmentName;

    @Column(name = "LOCATION")
    private String location;
}
