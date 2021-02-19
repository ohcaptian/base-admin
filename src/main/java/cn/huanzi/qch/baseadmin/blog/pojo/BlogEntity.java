package cn.huanzi.qch.baseadmin.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description  
 * @Author  yyf
 * @Date 2021-02-11 
 */
@NoArgsConstructor
@Data
@Entity
@Table(name ="t_blog")
public class BlogEntity  implements Serializable {

	private static final long serialVersionUID =  167119844068034671L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue
	private Long id;

   	@Column(name = "title" )
	private String title;

   	@Column(name = "content" )
	private String content;

   	@Column(name = "first_picture" )
	private String firstPicture;

   	@Column(name = "flag" )
	private String flag;

   	@Column(name = "views" )
	private Long views;

   	@Column(name = "appreciation" )
	private Long appreciation;

   	@Column(name = "share_statement" )
	private Long shareStatement;

   	@Column(name = "commentabled" )
	private Long commentabled;

   	@Column(name = "published" )
	private Long published;

   	@Column(name = "recommend" )
	private Long recommend;

   	@Column(name = "create_time" )
	private Date createTime;

   	@Column(name = "update_time" )
	private Date updateTime;

   	@Column(name = "type_id" )
	private Long typeId;

   	@Column(name = "user_id" )
	private Long userId;

   	@Column(name = "description" )
	private String description;

   	@Column(name = "tag_ids" )
	private String tagIds;
}
