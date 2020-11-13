package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class PsqlMain {

    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.savePost(new Post(0, "Java Job"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }

        store.saveCand(new Candidate(0, "Java senior"));
        for (Candidate cand : store.findAllCandidates()) {
            System.out.printf("%d %s%n", cand.getId(), cand.getName());
        }

        System.out.println(store.findCandById(1).getName());
        System.out.println(store.findPostById(1).getName());
    }
}
