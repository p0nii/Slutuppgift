package com.example.slutuppgift;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/v1/blog")

public class BlogController {

    ArrayList<Blog> myBlog;

    int latestBlogPost;


    public BlogController() {
        myBlog = new ArrayList<Blog>();
        latestBlogPost = 0;
    }

    //skapa blogginlägg
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Blog createBlogPost(@RequestBody Blog blog) {
        latestBlogPost++;
        blog.setId(latestBlogPost);
        myBlog.add(blog);
        return blog;
    }

    //lista alla blogginlägg
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ArrayList<Blog> ListBlogPost() {

        return myBlog;
    }

    //Listar specifikt blogginlägg
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Blog ListBlogPosts(@PathVariable("id") int id) {
        return getBlogByID(id);

    }
    //Ta bort specifikt inlägg
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void DeleteBlogPost(@PathVariable("id") int id) {
        Blog postToDelete = deleteBlogByID(id);

        myBlog.remove(postToDelete);
    }



        //Rensar alla blogginlägg
        @RequestMapping(value = "clear", method = RequestMethod.DELETE)
        public void clearBlogPosts () {
            myBlog.clear();

        }

        //Uppdatera specifikt blogginlägg
        @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
        public Blog UpdateBlogPost(@PathVariable("id") int id, @RequestBody Blog blogChanges) {
            System.out.println("hh" + id);
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

        //hör ihop med lista specifika blogginlägg
        private Blog getBlogByID(int id) {
            for (int i = 0; i < myBlog.size(); i++) {
                Blog currentBlog = myBlog.get(i);
                if (currentBlog.getId() == id) {
                    return myBlog.get(i);
                }
            }
                return new Blog();
            }

            //Hör ihop med uppdatera specifikt blogginlägg
         private Blog updateBlogByID (int id, Blog updatedBlog) {
             for (int i = 0; i < myBlog.size(); i++) {
                 Blog currentBlog = myBlog.get(i);
                 if (currentBlog.getId() == id) {
                     myBlog.set(i, updatedBlog);
                     return myBlog.get(i);
                 }
             }
             return new Blog();
         }

        //hör ihop med ta bort specifikt inlägg
        private Blog deleteBlogByID(int id) {
            for (int i = 0; i < myBlog.size(); i++) {
                Blog currentBlog = myBlog.get(i);
                if (currentBlog.getId() == id) {
                    return myBlog.get(i);
                }
            }
            return new Blog();
        }


            }




