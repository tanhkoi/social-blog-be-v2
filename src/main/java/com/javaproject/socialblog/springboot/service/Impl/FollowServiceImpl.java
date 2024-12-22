package com.javaproject.socialblog.springboot.service.Impl;

import com.javaproject.socialblog.springboot.model.entities.Follow;
import com.javaproject.socialblog.springboot.model.entities.User;
import com.javaproject.socialblog.springboot.repository.FollowRepository;
import com.javaproject.socialblog.springboot.repository.UserRepository;
import com.javaproject.socialblog.springboot.service.FollowService;
import com.javaproject.socialblog.springboot.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final UserRepository userRepository;

    private final FollowRepository followRepository;

    private final UserService userService;

    @Override
    public boolean followUser(String thatUserId) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        User user = userService.findByUsername(username); // current user
        if (user.getId().equals(thatUserId))
            return false;
        User thatUser = userService.findById(thatUserId); // that user


        Follow follow = new Follow();
        follow.setUser(user.getId());
        follow.setFollowing(thatUser.getId());
        follow.setFollowedAt(LocalDateTime.now());
        followRepository.save(follow);

//        user.getFollowing().add(follow);
//        thatUser.getFollowers().add(follow);

        userRepository.save(user);
        userRepository.save(thatUser);

        return true;
    }

    @Override
    public void unfollowUser(String thatUserId) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        User user = userService.findByUsername(username); // current user
        User thatUser = userService.findById(thatUserId); // that user

        Follow follow = followRepository.findByUserAndFollowing(user.getId(), thatUser.getId())
                .orElseThrow(() -> new IllegalArgumentException("Follow relationship does not exist"));

        followRepository.delete(follow);

//        user.getFollowing().remove(follow);
//        thatUser.getFollowers().remove(follow);

        userRepository.save(user);
        userRepository.save(thatUser);
    }

    @Override
    public Set<User> getFollowers(String userId) {
        User user = userRepository.findById(userId).orElseThrow();

        Set<User> users = new HashSet<>();
//        for (var i : user.getFollowers()) {
//            User follower = userRepository.findById(i.getUser()).orElseThrow();
//            users.add(follower);
//        }

        return users;

    }

    @Override
    public Set<User> getFollowing(String userId) {
        User user = userRepository.findById(userId).orElseThrow();

        Set<User> users = new HashSet<>();
//        for (var i : user.getFollowing()) {
//            User following = userRepository.findById(i.getFollowing()).orElseThrow();
//            users.add(following);
//        }

        return users;
    }

    @Override
    public Set<User> getMyFollowers() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        User user = userService.findByUsername(username);

        Set<User> users = new HashSet<>();
//        for (var i : user.getFollowers()) {
//            users.add(userRepository.findById(i.getUser()).get());
//        }

        return users;
    }

    @Override
    public Set<User> getMyFollowing() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        User user = userService.findByUsername(username);

        Set<User> users = new HashSet<>();
//        for (var i : user.getFollowing()) {
//            users.add(userRepository.findById(i.getUser()).get());
//        }

        return users;
    }

}
