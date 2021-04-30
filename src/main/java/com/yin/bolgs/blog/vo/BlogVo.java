package com.yin.bolgs.blog.vo;/**
 * @author 17694
 * @date 2021/02/13
 **/

import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.common.pojo.PageCondition;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : BlogVo 
 * @Description :   
 */
@Data
public class BlogVo extends PageCondition {
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private Long typeId;
    private String tagIds;
    private Long userId;
    //private UserEntity user;//多对一
    private TypeEntity type;//
    private List<TagEntity> tags = new ArrayList<>();
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
