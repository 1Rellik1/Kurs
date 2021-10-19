package hello.Controllers;

import hello.CommentData;
import hello.Entities.Comments;
import hello.Get_data;
import hello.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<Comments> greetingForm() {
        return commentService.get_comments();
    }

    @PostMapping("/comment")
    public Comments addcomment(@RequestBody Comments comment) {
        commentService.addComment(comment);
        return comment;
    }
}
