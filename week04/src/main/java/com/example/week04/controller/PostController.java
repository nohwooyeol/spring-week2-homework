package com.example.week04.controller;


import com.example.week04.dto.post.PostDataDto;
import com.example.week04.dto.post.PostPasswordDto;
import com.example.week04.dto.post.PostRequestDto;
import com.example.week04.dto.post.PostResponseDto;
import com.example.week04.model.Post;
import com.example.week04.repository.PostRepository;
import com.example.week04.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;


    // 전체 게시글 목록 조회
    @GetMapping
    public PostResponseDto<List<PostDataDto>> getBoard(){ //get으로 받아서 responsedto에 T(제네릭)에 List<BoardDataDto>
        return new PostResponseDto<>(true,postService.findAll(),null); //
    }

    // 게시글 조회
    @GetMapping("/{id}")
    public PostResponseDto<PostDataDto> getBoardOne(@PathVariable Long id){
        return new PostResponseDto<>(true, postService.find(id),null);
    }

    // 게시글 작성
    @PostMapping
    public PostResponseDto<PostDataDto> createBoard(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);
        PostDataDto dataDto = new PostDataDto(post);
        return  new PostResponseDto<>(true,dataDto,null);
    }

    // 게시글 비밀번호 확인
    @PostMapping("/{id}")
    public PostResponseDto<Boolean> findPassword(@PathVariable Long id, @RequestBody PostPasswordDto postPasswordDto){
        boolean b = postService.findPassword(id,postPasswordDto);
        return new PostResponseDto<>(true,b,null);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public PostResponseDto<PostDataDto> updateBoard(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return new PostResponseDto<>(true,new PostDataDto(postService.update(id,requestDto)),null);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public PostResponseDto<Boolean> deletePos(@PathVariable Long id){
        postRepository.deleteById(id);
        return new PostResponseDto<>(true,true,null);
    }

    // 출력 예외처리
    @ExceptionHandler(Exception.class)
    public PostResponseDto<Object> handleE(Exception e){
        return new PostResponseDto<>(false,null,e.getMessage());
    }


}