package com.kaituo.comparison.back.core.graphqlresolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.kaituo.comparison.back.core.dto.enums.CountryEnum;
import com.kaituo.comparison.back.core.entity.graphQL.Author;
import com.kaituo.comparison.back.core.entity.graphQL.Book;
import com.kaituo.comparison.back.core.mapper.graphQL.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author yedong
 * @create 2019-02-12 17:36
 */
@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    private AuthorMapper authorMapper;

    public Author getAuthor(Book book) {
        return authorMapper.selectById(book.getAuthorId());
    }

    public String getMoney(Book book, CountryEnum country) {
        if (country == CountryEnum.CHINA) {
            return "¥:" + book.getPrice() * 6;
        } else if (country == CountryEnum.USA) {
            return "$:" + book.getPrice();
        } else {
            return "free";
        }
    }
}
