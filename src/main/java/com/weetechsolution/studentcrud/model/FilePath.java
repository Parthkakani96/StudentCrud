package com.weetechsolution.studentcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;;

@Entity
@Table(name = "tbl_file")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilePath {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String path;

}
