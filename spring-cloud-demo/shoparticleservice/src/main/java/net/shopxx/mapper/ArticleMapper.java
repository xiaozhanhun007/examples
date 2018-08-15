package net.shopxx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.shopxx.entity.Article;

@Mapper
public interface ArticleMapper {

	@Select("select * from article where id=#{id}")
	public Article findById(@Param("id")Long id);
	
}
