package com.harry.springboot.web;

import com.harry.springboot.domain.posts.Posts;
import com.harry.springboot.service.posts.PostsService;
import com.harry.springboot.web.dto.PostsListResponseDto;
import com.harry.springboot.web.dto.PostsResponseDto;
import com.harry.springboot.web.dto.PostsSaveRequestDto;
import com.harry.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);

        return id;
    }

    @GetMapping("/api/v1/posts")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
