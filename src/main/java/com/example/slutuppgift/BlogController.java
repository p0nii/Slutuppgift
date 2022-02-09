package com.example.slutuppgift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/v1/blog")


public class BlogController {
    private BlogService blogService;
    private Logger logger;


    //Dependency Injection
    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;

        logger = LoggerFactory.getLogger(BlogController.class);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Blog> ListBlogPost() {
        logger.info("Listar alla blogginlägg");
        return blogService.getBlogPosts();

    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Blog> createBlogPost(@RequestBody Blog blog) {
        Blog blogEntry = blogService.createBlogPost(blog);

        if (blogEntry == null) {
            logger.warn("Det gick inte att skapa ett nytt blogginlägg");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Blogginlägg skapades: " + blogEntry.getTitle());
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);

    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> listBlogPosts(@PathVariable("id") int id) {
        Blog blogEntry = blogService.listBlogPosts(id);

        if (blogEntry == null) {
            logger.warn("Hittade inget blogginlägg med detta ID" + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Hämtade blogginlägg: " + blogEntry.getTitle());
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlogPost(@PathVariable("id") int id) {
        Blog blogEntry = blogService.deleteBlogPost(id);

        if (blogEntry == null) {
            logger.warn("Det gick inte att ta bort detta inlägg:" + blogEntry.getTitle());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("blogginlägg med detta ID togs bort: " + id);
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public ResponseEntity<Blog> UpdateBlogPost(@PathVariable("id") int id, @RequestBody Blog blogChanges) {
        Blog blogEntry = blogService.updateBlogPost(id, blogChanges);

        if (blogEntry == null) {
            logger.warn("Det gick inte att uppdatera detta inlägg: " + blogEntry.getTitle());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Blogginlägg vid detta ID har uppdaterats: " + id);
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);
    }


}
















