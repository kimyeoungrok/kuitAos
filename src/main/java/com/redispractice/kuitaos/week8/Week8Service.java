package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.Entity.Member;
import com.redispractice.kuitaos.Entity.Picture;
import com.redispractice.kuitaos.Entity.Post;
import com.redispractice.kuitaos.repository.MemberRepository;
import com.redispractice.kuitaos.repository.PictureRepository;
import com.redispractice.kuitaos.repository.PostRepository;
import com.redispractice.kuitaos.week8.Response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Week8Service {
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;
    public PostResponse getPost() {
        Post post = postRepository.findById(1L).get();
        Picture picture = pictureRepository.findByPost(post);
        Member member = post.getMember();

        return PostResponse.of(
                member.getProfileUrl(),
                member.getNickName(),
                picture.getPictureUrl(),
                post.getLikeCount(),
                post.getContents()
        );
    }
}
