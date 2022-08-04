package com.example.week04.service;

import com.example.week04.dto.post.PostDataDto;
import com.example.week04.dto.post.PostPasswordDto;
import com.example.week04.dto.post.PostRequestDto;
import com.example.week04.model.Post;
import com.example.week04.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post;
    }

    //Get 발생 시, 수행되는 메서드
    @Transactional
    public List<PostDataDto> findAll(){
        List<Post> list = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostDataDto> dtoList = new ArrayList<>();
        for (Post post : list) {
            PostDataDto dto = new PostDataDto(post);
            dtoList.add(dto);
        }
        return dtoList;
    }

    // Get {id} 발생 시, 수행되는 메서드
    @Transactional
    public PostDataDto find(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다."));
        return  new PostDataDto(post);
    }


    // Post {id} 발생 시, 수행되는 메서드
    @Transactional
    public Boolean findPassword(Long id, PostPasswordDto postPasswordDto){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다."));
        String password = post.getPassword();
        return password.equals(postPasswordDto.getPassword());
    }
}
