package com.yin.bolgs.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Description  
 * @Author  yyf
 * @Date 2021-02-11 
 */
@NoArgsConstructor
@Data
@Entity
@Table ( name ="t_user" )
public class UserEntity  implements Serializable {

	private static final long serialVersionUID =  8962037842721867710L;

	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "nickname" )
	private String nickname;

   	@Column(name = "username" )
	private String username;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "email" )
	private String email;

   	@Column(name = "avatar" )
	private String avatar;

   	@Column(name = "type" )
	private Long type;

   	@Column(name = "create_time" )
	private Date createTime;

   	@Column(name = "update_time" )
	private Date updateTime;

}
