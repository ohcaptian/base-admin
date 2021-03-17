package com.yin.bolgs.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  
 * @Author  yyf
 * @Date 2021-02-11 
 */
@NoArgsConstructor
@Data
@Entity
@Table ( name ="t_tag" )
public class TagEntity  implements Serializable {

	private static final long serialVersionUID =  4603394724637694155L;
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   	@Column(name = "name" )
	private String name;
   	@Transient
	private List<BlogEntity> blogs = new ArrayList<>();

}
