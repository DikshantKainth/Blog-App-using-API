package com.upgrad.blog.controller;

import com.upgrad.blog.model.Post;
import com.upgrad.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    /*
    /posts      - get
    /posts/id   - get
    /posts      - post
    /posts/id   - delete
    /posts/id   - put
    */
    @RequestMapping("/posts")   //localhsot:8080/posts - get (response is json)
    public List<Post> getAllPosts(){
        return this.postService.getAllPosts();
    }
    @RequestMapping("/posts/{id}")
    public Post getPost(@PathVariable Integer id){
        return this.postService.getPost(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/posts")
    public String addPost(@RequestBody Post post){
        System.out.println(post.getTitle());//temp
        post.setDate(new Date());
        postService.addPost(post);
        String response ="{\"success\":true,\"message\":\"Post has been added successfully\"}";
        return response;
    }
    @DeleteMapping("/posts/{id}")
    public String deletePosts(@PathVariable Integer id){
        this.postService.deletePost(id);
        String response="{\"success\":true,\"message\":\"Post has been deleted successfully\"}";
        return response;
    }


    //Update
    /*@RequestMapping(method = RequestMethod.POST, value="/posts/{id}")
    public String addPost(@RequestBody Post post, @PathVariable Integer id){
        System.out.println(post.getTitle());//temp
        post.setDate(new Date());
        postService.updatePost(id,post);
        String response ="{\"success\":true,\"message\":\"Post has been updated successfully\"}";
        return response;
    }*/

}
