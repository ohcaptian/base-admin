package cn.huanzi.qch.baseadmin.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	/**
	 *
	 */
	@Column(name = "type_id",insertable=false,updatable=false)
	private Long typeId;

   	@Column(name = "user_id" )
	private Long userId;

   	@Column(name = "description" )
	private String description;

   	@Column(name = "tag_ids",insertable=false,updatable=false)
	private String tagIds;

	@ManyToOne(fetch = FetchType.LAZY)
	private TypeEntity type;//

	@Transient
	private List<TagEntity> tags = new ArrayList<>();//Blog = Tag 多对多
//	@OneToMany
//	private List<CommentEntity> comments = new ArrayList<>();//一对多映射
	public void init(){
		this.tagIds = tagsToIds(this.getTags());
	}

	//将tags集合转换为tagIds字符串形式：“1,2,3”,用于编辑博客时显示博客的tag
	private String tagsToIds(List<TagEntity> tags){
		if(!tags.isEmpty()){
			StringBuffer ids = new StringBuffer();
			boolean flag = false;
			for(TagEntity tag: tags){
				if(flag){
					ids.append(",");
				}else {
					flag = true;
				}
				ids.append(tag.getId());
			}
			return ids.toString();
		}else {
			return tagIds;
		}
	}
}
