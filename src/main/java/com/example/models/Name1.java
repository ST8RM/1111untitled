package com.example.models;



import lombok.*;

import javax.persistence.*;
import java.awt.*;

//@Bean В Spring-е бином (bean) называют любой класс,
// который управляется контейнером Spring. То есть такими вещами,
// как создание экземпляра бина, его инициализация, внедрение зависимостей и параметров,
// деинициализация, генерация всевозможных оберток над бином, занимается не ваш код, а IoC-контейнер Springgett Inversion of Control.
@NoArgsConstructor// создаёт конструктор по умолчанию. В случае, если в классе есть final поля, такой конструктор сгенерирован не будет.
@Entity//Entity это обычный POJO Java класс, свойства которого, отображаются на поля таблицы базы данных, а объект Entity класса, по сути своей представляет определенную запись в таблице базы данны
@AllArgsConstructor//генерирует конструктор для всех полей класса.
//какая анотация используется для того что бы создать конструктор под каждое поле
@Getter//Геттер - это метод возвращающий значение некоего свойства класса
@Setter//а сеттер соответственно то что устанавливает свойство класса.
@Builder//
public class Name1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String price;
    private String image;



//findbytext, deletebytext, Post , Boot

    public Name1(String name, String description, String price, String image){
        this.name=name;
        this.description=description;
        this.price=price;

    }

    public Name1(String name, String description, String price) {

    }
}




