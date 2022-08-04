package com.example.week04.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    
    //댓글 생성
    @PostMapping("/api/auth/comment")
    public String updateComment(){
        return updateComment();
    }
    
    //댓글 목록 조회
    @GetMapping("/api/comment{id}")
    public String getComment(){
        return getComment();
    }
    
    //댓글 수정
    @PutMapping("/api/auth/comment/{id}")
    public String modifyComment(){
        return modifyComment();
    }
    
    //댓글 삭제
    @DeleteMapping("/api/auth/comment/{id}")
    public String deleteComment(){
        return deleteComment();
    }
}
