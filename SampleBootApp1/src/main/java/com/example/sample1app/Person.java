package com.example.sample1app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private long id;

	@Column(length = 50, nullable = false)
	@NotBlank(message="名前は書かないとダメ!")
	private String name;

	@Column(length = 200, nullable = true)
	@Email(message="メールアドレスを教えて")
	private String mail;

	@Column(nullable = true)
	@Min(value=0, message="いやいや、マイナスの歳ってないでしょ？")
	@Max(value=200, message="200歳以上って、魔女ですか?")
	private Integer age;

	@Column(nullable = true)
	private String memo;

}
