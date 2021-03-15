package com.yin.bolgs.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * @Description  
 * @Author  yyf
 * @Date 2021-02-11 
 */
@NoArgsConstructor
@Data
@Entity
@Table ( name ="t_blog_tags" )
public class BlogTagsEntity  implements Serializable {

	private static final long serialVersionUID =  8901576529687963638L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "tag_id" )
	private Long tagId;

   	@Column(name = "blog_id" )
	private String blogId;

}
