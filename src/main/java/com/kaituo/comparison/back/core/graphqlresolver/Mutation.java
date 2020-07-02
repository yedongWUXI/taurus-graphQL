package com.kaituo.comparison.back.core.graphqlresolver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kaituo.comparison.back.core.dto.model.*;
import com.kaituo.comparison.back.core.entity.graphQL.Author;
import com.kaituo.comparison.back.core.entity.graphQL.Book;
import com.kaituo.comparison.back.core.entity.graphQL.User;
import com.kaituo.comparison.back.core.mapper.graphQL.AuthorMapper;
import com.kaituo.comparison.back.core.mapper.graphQL.BookMapper;
import com.kaituo.comparison.back.core.mapper.graphQL.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yedong
 * @create 2019-02-12 18:58
 */
@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {


    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorMapper.insert(author);
        return author;
    }

    public Book newBook(String title, String isbn, int pageCount, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);
        book.setAuthorId(authorId);
        bookMapper.insert(book);
        return book;
    }


    public Book saveBook(BookInput input) {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setIsbn(input.getIsbn());
        book.setPageCount(input.getPageCount());
        book.setAuthorId(input.getAuthorId());
        bookMapper.insert(book);
        return book;
    }

    public Boolean deleteBook(Long id) {
        bookMapper.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(int pageCount, long id) {
        Book book = bookMapper.selectById(id);
        book.setPageCount(pageCount);
        bookMapper.updateById(book);
        return book;
    }


    public CreateUserResult createUser(String name, AuthData authData) {
        if (userMapper.selectOne(new QueryWrapper<User>().eq(User.COL_NAME,name)) != null) {
            return new ErrorContainer(Stream.of("The user already exists.").collect(Collectors.toList()));
        } else {
            User user = new User();
            user.setPwd(authData.getPwd());
            user.setEmail(authData.getEmail());
            user.setName(name);
            userMapper.insert(user);
            return new CreatedUser(user);
        }
    }

    public LoginResult login(AuthData authData) {
        String email = authData.getEmail();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq(User.COL_EMAIL,email));
        if (user == null) {
            return new ErrorContainer(Stream.of("Unregistered email.").collect(Collectors.toList()));
        } else if (userMapper.selectOne(new QueryWrapper<User>().eq(User.COL_EMAIL,email).eq(User.COL_PWD,authData.getPwd())) == null) {
            return new ErrorContainer(Stream.of("Wrong password.").collect(Collectors.toList()));
        } else {
            return new LoginPayload(user.getId(), user);
        }
    }
}
