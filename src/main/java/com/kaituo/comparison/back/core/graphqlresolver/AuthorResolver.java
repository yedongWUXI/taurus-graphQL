package com.kaituo.comparison.back.core.graphqlresolver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.kaituo.comparison.back.core.entity.graphQL.Author;
import com.kaituo.comparison.back.core.entity.graphQL.Book;
import com.kaituo.comparison.back.core.mapper.graphQL.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author yedong
 * @create 2019-02-12 17:33
 */
@Component
@AllArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private BookMapper bookMapper;

    public String getCreatedTime(Author author) {
        return sdf.format(author.getCreatedTime());
    }

    public List<Book> getBooks(Author author) {
        return bookMapper.selectList(new QueryWrapper<Book>().eq(Book.COL_AUTHOR_ID, author.getId()));

    }
}
