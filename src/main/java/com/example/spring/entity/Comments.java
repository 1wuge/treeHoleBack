package com.example.spring.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    String account;
    int tid;
    int cid;
    String comment;
    String ctime;

}
