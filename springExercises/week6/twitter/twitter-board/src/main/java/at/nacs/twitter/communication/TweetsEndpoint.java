package at.nacs.twitter.communication;

import at.nacs.twitter.persistence.Tweet;
import at.nacs.twitter.logic.Twitter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/tweets")
@RestController
public class TweetsEndpoint {

    private final Twitter twitter;

    @GetMapping
    List<Tweet> get() {
        return twitter.findAll();
    }

    @GetMapping("/user/{user}")
    List<Tweet> get(@PathVariable String user) {
        return twitter.findBy(user);
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet) {
        return twitter.save(tweet);
    }

    @PutMapping("/{id}/likes")
    void like(@PathVariable String id) {
        twitter.like(id);
    }

    @PutMapping("/{id}/comments")
    void comment(@PathVariable String id, @RequestBody String comment) {
        twitter.comment(id, comment);
    }
}
