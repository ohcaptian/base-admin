package com.yin.bolgs.blog.pojo;

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
@Table ( name ="t_comment" )
public class CommentEntity  implements Serializable {

	private static final long serialVersionUID =  2955293543567618256L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "nickname" )
	private String nickname;

   	@Column(name = "email" )
	private String email;

   	@Column(name = "content" )
	private String content;

   	@Column(name = "avatar" )
	private String avatar;

   	@Column(name = "create_time" )
	private Date createTime;

   	@Column(name = "blog_id" )
	private Long blogId;

   	@Column(name = "parent_comment_id" )
	private Long parentCommentId;

   	@Column(name = "admincomment" )
	private Long admincomment;

	//父评论
	@Transient
	private CommentEntity parentComment;
	@Transient
	private BlogEntity blog;


}
