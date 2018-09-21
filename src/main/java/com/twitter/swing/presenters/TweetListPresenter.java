package com.twitter.swing.presenters;

import com.twitter.swing.views.TweetListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TweetListPresenter implements StatusListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TweetListPresenter.class);
    private final TweetListView tweetListView;

    public TweetListPresenter(TweetListView tweetListView) {
        this.tweetListView = tweetListView;
        new TwitterStreamFactory().getInstance().addListener(this).filter("javascript");
    }

    public void onStatus(Status status) {
        try {
            tweetListView.addTweet(new URL(status.getUser().getProfileImageURL()), status.getText());
        } catch (MalformedURLException e) {
            LOGGER.error("Malformed URL: ", e);
        }
    }

    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        throw new UnsupportedOperationException();
    }

    public void onTrackLimitationNotice(int i) {
        throw new UnsupportedOperationException();
    }

    public void onScrubGeo(long l, long l1) {
        throw new UnsupportedOperationException();
    }

    public void onStallWarning(StallWarning stallWarning) {
        throw new UnsupportedOperationException();
    }

    public void onException(Exception e) {
        LOGGER.error("Exception: ", e);
    }
}
