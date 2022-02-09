package com.example.slutuppgift;


import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BlogService {

    ArrayList<Blog> myBlog;
    int latestBlogPost = 0;

    public BlogService() {
        myBlog = new ArrayList<>();
    }

    //Listar alla blogginlägg
    public ArrayList<Blog> getBlogPosts() {
        return myBlog;
    }

    //Skapar ett nytt blogginlägg
    public Blog createBlogPost(Blog newPost) {
        latestBlogPost++;
        newPost.setId(latestBlogPost);
        myBlog.add(newPost);
        return newPost;
    }

    //Listar specifikt blogginlägg
    public Blog listBlogPosts(int id) {
        Blog listBlogPosts = getBlogByID(id);

        return listBlogPosts;

    }

    //Tar bort ett blogginlägg
    public Blog deleteBlogPost(int id) {
        Blog postToDelete = getBlogByID(id);

        if (postToDelete != null) {
            myBlog.remove(postToDelete);
        }

        return postToDelete;
    }

    //Uppdaterar ett blogginlägg
    public Blog updateBlogPost(int id, Blog blogChanges) {
        Blog blogToUpdate = getBlogByID(id);

        if (blogChanges.getTitle() != null) {
            blogToUpdate.setTitle(blogChanges.getTitle());
        }
        if (blogChanges.getBody() != null) {
            blogToUpdate.setBody(blogChanges.getBody());
        }

        updateBlogByID(id, blogToUpdate);

        return blogToUpdate;
    }

    //Metod som hör ihop med lista specifika blogginlägg och ta bort specifikt inlägg
    private Blog getBlogByID(int id) {
        for (int i = 0; i < myBlog.size(); i++) {
            Blog currentBlog = myBlog.get(i);
            if (currentBlog.getId() == id) {
                return myBlog.get(i);
            }
        }
        return null;
    }

    //Metod som hör ihop med uppdatera specifikt blogginlägg
    private Blog updateBlogByID(int id, Blog updatedBlog) {
        for (int i = 0; i < myBlog.size(); i++) {
            Blog currentBlog = myBlog.get(i);
            if (currentBlog.getId() == id) {
                myBlog.set(i, updatedBlog);
                return myBlog.get(i);
            }
        }
        return null;
    }
}
