package hello;

import hello.Entities.Comments;
import hello.Services.CommentService;

import java.util.Arrays;
import java.util.List;

public class CommentData {
    private List<Comments> comments;
    private String name;
    private String comment;
//    public CommentData(CommentService commentService) {
//        comments= commentService.get_comments();
//            this.name=new String[comments.size()];
//            for(int i =0;i<comments.size();i++){
//                this.name[i]=(comments.get(i).getName());
//            }
//        this.comment=new String[comments.size()];
//        for(int i =0;i<comments.size();i++){
//            this.comment[i]=(comments.get(i).getComment());
//        }
//
//    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
