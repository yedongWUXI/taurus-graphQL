package com.kaituo.comparison.back.core.graphqlresolver;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kaituo.comparison.back.core.dto.enums.CountryEnum;
import com.kaituo.comparison.back.core.dto.model.Animal;
import com.kaituo.comparison.back.core.dto.model.AuthData;
import com.kaituo.comparison.back.core.dto.model.Dog;
import com.kaituo.comparison.back.core.dto.model.Fish;
import com.kaituo.comparison.back.core.entity.graphQL.Author;
import com.kaituo.comparison.back.core.entity.graphQL.Book;
import com.kaituo.comparison.back.core.mapper.graphQL.AuthorMapper;
import com.kaituo.comparison.back.core.mapper.graphQL.BookMapper;
import com.kaituo.comparison.back.core.mapper.graphQL.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yedong
 * @create 2019-02-12 18:00
 */
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {


    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;


    public Author findAuthorById(Long id) {
        return authorMapper.selectById(id);
    }

    public List<Author> findAllAuthors() {
        return authorMapper.selectList(new QueryWrapper<>());
    }

    public Integer countAuthors() {
        return authorMapper.selectCount(new QueryWrapper<>());
    }

    public List<Book> findAllBooks() {
        return bookMapper.selectList(new QueryWrapper<>());
    }

    public Integer countBooks() {
        return bookMapper.selectCount(new QueryWrapper<>());
    }

    public Book findBookById(Long id) {
        return bookMapper.selectById(id);
    }



    public Book findBookByAuthor(AuthData authData) {
        return bookMapper.selectOne(new QueryWrapper<Book>().eq(Book.COL_AUTHOR_ID,authData.getId()));
    }

    public String testEnum(CountryEnum country) {
        return country.toString();
    }

    /**
     * 分页测试
     * @param first
     * @param after
     * @param env
     * @return
     */
//    public Connection<Book> books(int first,String after,DataFetchingEnvironment env) {
//        return new SimpleListConnection<>(bookMapper.findAll()).get(env);
//    }

    /**
     * @descript: 测试一下接口的使用
     * @auther: yedong
     * @date: 2019/3/3 18:31
     * @param name
     * @return
     */
    public Animal getAnimal(String name) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setLegs(4);

        Fish fish = new Fish();
        fish.setName(name);
        fish.setTailColor("BlueAndRead");

        if ("dog".equals(name)) {
            return dog;
        } else if ("fish".equals(name)) {
            return fish;
        }
        return null;
    }

    /**
     * @descript: 返回不同类型的数据
     * @auther: yedong
     * @date: 2019/3/3 20:42
     * @return
     */
    public List<Animal> animals() {
        Dog dog = new Dog();
        dog.setName("I am Dog");
        dog.setLegs(4);

        Fish fish = new Fish();
        fish.setName("I am Fish");
        fish.setTailColor("BlueAndRead");

        List<Animal> list = new ArrayList<>();
        list.add(dog);
        list.add(fish);

        return list;
    }
}
