package cn.huanzi.qch.baseadmin.blog.pojo;

import javax.persistence.*;
import java.io.Serializable;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name ="t_blog")
public class BlogEntity  implements Serializable {

	private static final long serialVersionUID =  167119844068034671L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "title" )
	private String title;

   	@Column(name = "content" )
	private String content;

   	@Column(name = "first_picture" )
	private String firstPicture;

   	@Column(name = "flag" )
	private String flag;
	/**
	 * 将views类型修改为string 是否出错未知
	 */
   	@Column(name = "views" )
	private String views;
	/**
	 * 将appreciation类型修改为string 是否出错未知
	 */
   	@Column(name = "appreciation" )
	private String appreciation;
	/**
	 * 将shareStatement类型修改为string 是否出错未知
	 */
   	@Column(name = "share_statement" )
	private String shareStatement;
	/**
	 * 将commentabled类型修改为string 是否出错未知
	 */
   	@Column(name = "commentabled" )
	private String commentabled;
	/**
	 * 将pubic类型修改为string 是否出错未知
	 */
   	@Column(name = "published" )
	private String published;
	/**
	 * 将recommend类型修改为string 是否出错未知
	 */
   	@Column(name = "recommend" )
	private String recommend;

   	@Column(name = "create_time" )
	@CreatedDate
	private Date createTime;

   	@Column(name = "update_time" )
	@LastModifiedDate
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
