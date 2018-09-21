package com.twitter.swing;

import com.twitter.swing.presenters.TweetListPresenter;
import com.twitter.swing.views.TweetListView;

import javax.swing.*;

public class TwitterSwingApplication {
    private TwitterSwingApplication() {
        final TweetListView tweetListView = new TweetListView();
        new TweetListPresenter(tweetListView);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(TwitterSwingApplication::new);
    }
}
