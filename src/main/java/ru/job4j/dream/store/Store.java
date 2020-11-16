package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void savePost(Post post);

    void saveCand(Candidate cand);

    Post findPostById(int id);

    Candidate findCandById(int id);

    int addPhoto(int id);

    void saveUser(User user);

    User findUserByEmail(String email);

    Collection<User> findAllUsers();
}
