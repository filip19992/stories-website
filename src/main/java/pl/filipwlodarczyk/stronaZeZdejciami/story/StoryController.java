package pl.filipwlodarczyk.stronaZeZdejciami.story;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }


    @GetMapping("/story/utilsstory/{id}")
    public String findContentById(@PathVariable("id") Long id) {
        return storyService.findContent(id);
    }


    //TODO: make method returns json with list of stories from author id!!!
    @GetMapping("/story/{authorId}")
    public Optional<List<Story>> findStoriesByAuthorId(@PathVariable("authorId") Long authorId) throws Exception {
        return storyService.findStoryByAuthorId(authorId);
    }

    @GetMapping("/stories/all")
    public List<Story> findAllStories() {
        return storyService.findAllStories();
    }



}
