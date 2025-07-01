package com.example.thymeleafsample.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    private Integer artistId;

    private String memberName;

    private String memberHiraganaName;

    private LocalDate memberBirthday;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="artistId",insertable = false, updatable = false)
    private Artist artist;

    /**
     * 画面表示の時間と誕生日を比較し、画面表示時点での年齢を返す
     * @return 画面表示時の年齢
     */
    public long getAge(){
        return ChronoUnit.YEARS.between(memberBirthday,LocalDate.now());
    }
}
