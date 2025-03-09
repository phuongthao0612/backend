package com.example.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clothings")
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Mã sản phẩm là bắt buộc")
    private String code;

    @NotBlank(message = "Tên sản phẩm là bắt buộc")
    @Size(max = 100, message = "Tên sản phẩm không được vượt quá 100 ký tự")
    private String name;

    @Min(value = 1, message = "Số lượng phải là số nguyên dương")
    private int quantity;

    @NotNull(message = "Ngày nhập là bắt buộc")
    @PastOrPresent(message = "Ngày nhập không được lớn hơn ngày hiện tại")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
