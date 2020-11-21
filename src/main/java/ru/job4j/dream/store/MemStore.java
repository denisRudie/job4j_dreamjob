package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {

    private static final MemStore INST = new MemStore();
    private static final AtomicInteger POST_ID = new AtomicInteger(0);
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(0);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private MemStore() {
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    @Override
    public void saveCand(Candidate cand) {
        if (cand.getId() == 0) {
            cand.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(cand.getId(), cand);
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public Candidate findCandById(int id) {
        return candidates.get(id);
    }

    @Override
    public int addPhoto(int id) {
        return 0;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public Collection<User> findAllUsers() {
        return null;
    }

    @Override
    public Collection<City> findAllCities() {
        return null;
    }

    @Override
    public City findCityByName(String name) {
        return null;
    }
}